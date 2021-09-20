package poc.filter;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;



//@WebFilter(
//        urlPatterns = {
//                "*.action",
//                "*.do"
//        },
//        dispatcherTypes = {
//                DispatcherType.REQUEST,
//                DispatcherType.FORWARD
//        }
//)
public class AuthorizationFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        System.out.printf("AuthorizationFilter: Före chain.doFilter för URI: %s (%s)%n",
                ((HttpServletRequest)request).getRequestURI(),
                hashCode());
        chain.doFilter(request, response);
        System.out.printf("AuthorizationFilter: Efter chain.doFilter för URI: %s (%s)%n",
                ((HttpServletRequest)request).getRequestURI(),
                hashCode());
    }


    @Override
    public void destroy()
    {
    }
}
