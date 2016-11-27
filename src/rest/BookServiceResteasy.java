package rest;

import domain.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by osemenkova on 11/27/2016.
 */

@Path("/rest")
public class BookServiceResteasy {

    @GET
    @Path("/books/{id}")
    @Produces("application/json")
    public Book getBookInJSON() {

        Book book = new Book();
        book.setTitle("Java");
        book.setAuthor("Ekkel");
        book.setId(1);

        return book;
    }

    @POST
    @Path("/books")
    @Consumes("application/json")
    public Response createBookInJSON(Book book) {

        String result = "Book created : " + book;
        return Response.status(201).entity(result).build();

    }
}
