package lab2.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {
    private static long startupTime = 0L;

    public void contextInitialized(ServletContextEvent ce) {
        startupTime = System.currentTimeMillis();

        ServletContext ctx = ce.getServletContext();

        String defaultCategory = ctx.getInitParameter("defaultCategory");

        ctx.setAttribute("defaultCategory", defaultCategory);
    }

    public void contextDestroyed(ServletContextEvent ce) {   }
}