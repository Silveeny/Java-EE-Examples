package javalab1;


import branch.KeyBranchResponseBuilder;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import logging.LabLogger;


import java.io.IOException;
import java.io.PrintWriter;

public class Lab1Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LabLogger.log("method: get \n" +
                "IP: " + request.getRemoteAddr() + "\n" +
                "UserAgent: " + request.getHeader("User-Agent") + "\n" +
                "Parameters: " + request.getParameterMap().toString() + "\n");


        String key    = null;
        Integer value = null;
        Boolean mock  = null;
        Boolean sync  = null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (!request.getHeader("User-Agent").equals("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36")) {
            out.println("Not so fast python!");
        }


        if (request.getParameter("key") == null
            && request.getParameter("value") == null
            && request.getParameter("mock") == null
            && request.getParameter("sync") == null) {

            out.write(getBasicForm());

        } else {
            key = request.getParameter("key");
            value = Integer.parseInt(request.getParameter("value"));
            mock = Boolean.parseBoolean(request.getParameter("mock"));
            sync = Boolean.parseBoolean(request.getParameter("sync"));

            if (mock) {
                out.println("<h1> confirmation </h1>");
            } else {
                KeyBranchResponseBuilder branch = new KeyBranchResponseBuilder();

                if (sync != null && sync) {
                    branch.updateRepoFileSafely(value, key);
                } else {
                    branch.updateRepoFileUnsafe(value, key);
                }

                // pe web nu o sa apara de value ori ca mapurile nu suporta duplicate
                // am fi putut sa nu folosim un map pentru a tine datele sortatte (treemap in cazul asta)
                // sau sa stocam si numarul de repetitii; dar e mai eficient asa
                out.println(branch.getHtmlSortedContent());
            }
        }

    }


    private String getBasicForm() {
        return "<html>" +
                "<body>" +
                "   <form method=\"GET\" action=\"lab1\">" +
                "      key: <input type=\"text\" name=\"key\" size=\"20\" value=\"\"/> <br/> " +
                "      value: <input type=\"text\" name=\"value\" size=\"20\" value=\"\"/> <br/> " +
                "      mock: <input type=\"text\" name=\"mock\" size=\"20\" value=\"\"/> <br/> " +
                "      sync: <input type=\"text\" name=\"sync\" size=\"20\" value=\"\"/> <br/> " +
                "       <input type=\"submit\" name=\"submit\" value=\"Submit\">" +
                "   </form>" +
                "</body>" +
                "</html>";
    }

}
