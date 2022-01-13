package rest.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/carbonateddrinks")
public class CarbonatedDrinks {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCarbonatedDrinks() throws IOException {
        Client client = ClientBuilder.newClient();
        System.out.println("dgdgdgdgfdfg");
        String carbonatedDrinks = client.target("http://host.docker.internal:8081/brain/api/carbonateddrinks")
            .request(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .get(String.class);

        return carbonatedDrinks;
    }

}
