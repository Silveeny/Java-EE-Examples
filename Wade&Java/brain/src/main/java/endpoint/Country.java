package endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.JenaWrapper;
//import jakarta.inject.Singleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Path("/country")
//@Singleton
public class Country extends Application {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCountries() throws IOException {
        //        ... returnam un json cu tarile

        List<String> contries = JenaWrapper.getAllCountries();

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(out, contries);

        final byte[] data = out.toByteArray();

        String json = new String(data);
        System.out.println(new String(data));

        return json;
    }

}
