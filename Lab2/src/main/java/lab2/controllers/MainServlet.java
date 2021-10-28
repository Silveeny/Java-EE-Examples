package lab2.controllers;

import lab2.persistence.DataStorage;
import lab2.persistence.impl.FileDataStorage;
import lab2.utils.Triplet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainServlet extends HttpServlet {

    public static List<String> categories = new ArrayList<String>();
    public DataStorage storage = new FileDataStorage();

    //Static - dar putem folosi un DB sau altceva pentru a livra content dinamic
    static {

        categories.add("categoria 1");
        categories.add("categoria 2");
        categories.add("categoria 3");
        categories.add("listener");
    }

     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        boolean hasCookie = false;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; ++i) {
                if (cookies[i].getName().equals("category-cookie")) {
                    hasCookie = true;
                    request.setAttribute("previous-category", cookies[i].getValue());
                }
            }
        }

        if (!hasCookie) {
            request.setAttribute("previous-category", "");
        }

        response.setContentType("text/html");


        request.setAttribute("categories", categories);
        request.setAttribute("warning", "");
        getServletContext().getRequestDispatcher("/jsp/input.jsp")
            .forward(request, response);
     }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        String category = request.getParameter("category");


        if (/*category == null || */category.equals("listener")) {
            category = (String) request.getServletContext().getAttribute("defaultCategory");
        }

        if (request.getAttribute("previous-category") != null
            && !request.getAttribute("previous-category").equals("")
            && category.equals("listener")) {
            category = (String) request.getAttribute("previous-category");
        }

        if ((key != null && !key.equals(""))
            && (value != null && !value.equals(""))) {
            // formular valid
            Triplet<String, String, String> entry = new Triplet<>(key, value, category);
            storage.persistTriple(entry);

            Cookie cookie = new Cookie("category-cookie", category);

            response.addCookie(cookie);

            response.sendRedirect("/lab2/result");


        } else {

            request.setAttribute("categories", categories);
            request.setAttribute("warning", "nu este valid formularul");
            getServletContext().getRequestDispatcher("/jsp/input.jsp")
                .forward(request, response);
        }


    }




}
