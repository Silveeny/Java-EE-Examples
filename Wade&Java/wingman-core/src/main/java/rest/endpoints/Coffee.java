package rest.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/coffee")
public class Coffee {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCoffee() throws IOException {
        Client client = ClientBuilder.newClient();

        String coffee = client.target("http://host.docker.internal:8081/brain/api/coffee")
            .request(MediaType.APPLICATION_JSON)
            .get(String.class);

        return coffee;
    }
}
