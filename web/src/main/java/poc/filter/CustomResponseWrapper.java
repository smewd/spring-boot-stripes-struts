package poc.filter;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.PrintWriter;


public class CustomResponseWrapper extends HttpServletResponseWrapper {

    private CharArrayWriter output;


    CustomResponseWrapper(HttpServletResponse response) {
        super(response);
        output = new CharArrayWriter();
    }


    String getResponseContent() {
        return output.toString();
    }


    public PrintWriter getWriter() {
        return new PrintWriter(output);
    }
}
