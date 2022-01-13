package rest.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/tea")
public class Tea {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTea() throws IOException {
        Client client = ClientBuilder.newClient();

        String tea = client.target("http://host.docker.internal:8081/brain/api/tea")
            .request(MediaType.APPLICATION_JSON)
            .get(String.class);

        return tea;
    }

}
