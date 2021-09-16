package poc.filter;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;


@Component
public class WebBrowserCacheFilter implements Filter {
    static final String VERSION_PARAM = "v=1";
    private static final String REQ_SEPARATOR_VERSION_PARAM = "?" + VERSION_PARAM;
    private static final String REQ_OCH_SEPARATOR_VERSION_PARAM = "&" + VERSION_PARAM;

    private static final String REG_EXP_NUMERIC_MATCHER = ".*\\d.*";
    private static final String DOC_ELEMENT_LINK_HREF_MATCHER = "link[href]";
    private static final String DOC_ELEMENT_SCRIPT_SRC_MATCHER = "script[src]";
    private static final String ELEMENT_ATTR_HREF = "href";
    private static final String ELEMENT_ATTR_SRC = "src";


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        String content = extraheraInnehall(req, res, filterChain);

        String newContent;
        if (!res.getContentType().contains(MediaType.TEXT_HTML_VALUE)) {
            newContent = content;
        } else {
            Document doc = Jsoup.parse(content);
            hittaAttributOchLaggTillVersionsnummer(doc, DOC_ELEMENT_LINK_HREF_MATCHER, ELEMENT_ATTR_HREF);
            hittaAttributOchLaggTillVersionsnummer(doc, DOC_ELEMENT_SCRIPT_SRC_MATCHER, ELEMENT_ATTR_SRC);
            newContent = doc.toString();
        }

        skrivOmInnehall(res, newContent);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // nothing to initialize
    }


    @Override
    public void destroy() {
        // nothing to destroy
    }


    String extraheraInnehall(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws
            IOException, ServletException {
        CustomResponseWrapper wrapper = new CustomResponseWrapper(res);
        filterChain.doFilter(req, wrapper);

        return wrapper.getResponseContent();
    }


    private void hittaAttributOchLaggTillVersionsnummer(Document doc, String elementMatcher, String attr) {
        for (Element link : doc.select(elementMatcher)) {
            String attrValue = link.attr(attr);
            if (attrValue != null && !attrValue.matches(REG_EXP_NUMERIC_MATCHER)) {
                link.removeAttr(attr);
                link.attr(attr, laggTillVersionsnummer(attrValue));
            }
        }
    }


    private String laggTillVersionsnummer(String s) {
        return s.concat(s.contains("?") ? REQ_OCH_SEPARATOR_VERSION_PARAM : REQ_SEPARATOR_VERSION_PARAM);
    }


    private void skrivOmInnehall(HttpServletResponse res, String content) throws IOException {
        CharArrayWriter writer = new CharArrayWriter();
        writer.write(content);

        try (PrintWriter out = res.getWriter()) {
            out.write(writer.toString());
            out.flush();
        }
    }
}
