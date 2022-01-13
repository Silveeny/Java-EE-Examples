package controllers;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/main")
public class Main extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = ClientBuilder.newClient();
        String countries = client.target("http://host.docker.internal:8081/brain/api/country")
            .request(MediaType.APPLICATION_JSON)
            .get(String.class);

        String ingredients = client.target("http://host.docker.internal:8081/brain/api/ingredients")
            .request(MediaType.APPLICATION_JSON)
            .get(String.class);

        String events = client.target("http://host.docker.internal:8081/brain/api/events")
            .request(MediaType.APPLICATION_JSON)
            .get(String.class);

        String restrictions = client.target("http://host.docker.internal:8081/brain/api/restrictions")
            .request(MediaType.APPLICATION_JSON)
            .get(String.class);

        System.out.println(countries);
        System.out.println(ingredients);
        System.out.println(events);
        System.out.println(restrictions);

        ObjectMapper mapper = new ObjectMapper();
        List<String> desCountries = mapper.readValue(countries, new TypeReference<List<String>>(){});
        List<String> desIngredients = mapper.readValue(ingredients, new TypeReference<List<String>>(){});
        List<String> desEvents = mapper.readValue(events, new TypeReference<List<String>>(){});
        List<String> desRestrictions = mapper.readValue(restrictions, new TypeReference<List<String>>(){});

        request.setAttribute("desCountries", desCountries);
        request.setAttribute("desIngredients", desIngredients);
        request.setAttribute("desEvents", desEvents);
        request.setAttribute("desRestrictions", desRestrictions);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    }

}
