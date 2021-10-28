package lab2.controllers;

import lab2.persistence.DataStorage;
import lab2.persistence.impl.FileDataStorage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResultServlet extends HttpServlet {

    public DataStorage ds = new FileDataStorage();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setAttribute("triples", ds.retrieveTriple());

        getServletContext().getRequestDispatcher("/jsp/result.jsp")
            .forward(request, response);
    }
}
