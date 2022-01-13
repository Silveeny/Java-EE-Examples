package rest.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/mocktails")
public class Mocktails {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMocktails() throws IOException {
        Client client = ClientBuilder.newClient();

        String mocktails = client.target("http://host.docker.internal:8081/brain/api/mocktails")
            .request(MediaType.APPLICATION_JSON)
            .get(String.class);

        return mocktails;
    }
}
