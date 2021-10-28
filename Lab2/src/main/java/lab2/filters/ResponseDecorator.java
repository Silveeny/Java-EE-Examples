package lab2.filters;

import lab2.wrappers.SimpleResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "ResponseDecorator", urlPatterns = {"/*"})
public class ResponseDecorator implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        SimpleResponseWrapper wrapper
                = new SimpleResponseWrapper((HttpServletResponse) response);
        //Send the decorated object as a replacement for the original response
        chain.doFilter(request, wrapper);

        String prelude = "<p> Begin filter </p>!";

        //Get the dynamically generated content from the decorator
        String content = prelude + wrapper.toString();
        // Modify the content
        content += "<p> Filter end! </p>";
        //Send the modified content using the original response
        PrintWriter out = response.getWriter();
        out.write(content);
    }
}