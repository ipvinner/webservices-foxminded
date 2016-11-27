package resteasy;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


/**
 * Created by ipvinner on 27.11.2016.
 */
@Path("/json/book")
public class BookRestEasyService {
    @GET
    @Path("/get")
    @Produces("application/json")
    public Book getBookInJSON() {
        Book book = new Book();
        book.setId(1);
        book.setTitle("Startup");
        book.setAuthor("Gay Kavasaki");
        return book;
    }

    @POST
    @Path("/post")
    @Consumes("application/json")
    public Response createProductInJSON(Book book) {

        String result = "book created : " + book;
        return Response.status(201).entity(result).build();

    }

}
