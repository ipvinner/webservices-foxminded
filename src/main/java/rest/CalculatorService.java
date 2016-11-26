package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by ipvinner on 26.11.2016.
 */
@Path("/calc")
public class CalculatorService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSum(@QueryParam("number1") int number1,
                           @QueryParam("number2") int number2) {

        int result = number1 + number2;
        String output = "{result : " +  result + "}";

        return Response.status(200).entity(output).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComp(@QueryParam("number1") int number1,
                           @QueryParam("number2") int number2) {

        int result = number1 * number2;
        String output = "{result : " +  result + "}";

        return Response.status(200).entity(output).build();

    }
}
