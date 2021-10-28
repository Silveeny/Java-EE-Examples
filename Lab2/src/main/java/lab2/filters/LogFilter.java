package lab2.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

@WebFilter(urlPatterns = {"/*"})
public class LogFilter implements Filter {

    public static final String LOGS_PATH = "D:\\11 - Syncthing\\Java Tehnologies\\Lab2\\src\\main\\resources\\logs.txt";

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        // Find the IP of the request
        String ipAddress = request.getRemoteAddr();
        // Write something in the log
        String resString =  "IP: " + ipAddress + ", Time: " + new Date().toString() + "\n";
        System.out.println(resString);

        try {
            Files.write(Paths.get(LOGS_PATH), resString.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {  }

        chain.doFilter(req, res);
    }
}