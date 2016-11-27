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
    public Book getBookInJSON(@PathParam("id") int bookId) {

        Book book = new Book();
        book.setTitle("Java");
        book.setAuthor("Ekkel");
        book.setId(bookId);

        return book;
    }

    @POST
    @Path("/books")
    @Consumes("application/json")
    public Response createBookInJSON(Book book) {

        String result = "Book created : " + book;
        return Response.status(201).entity(result).build();

    }

    @PUT
    @Path("/books/{id}")
    @Consumes("application/json")
    public Response updateBookInJSON(@PathParam("id") int bookId) {

        String result = "Book updated : " + bookId;
        return Response.status(201).entity(result).build();

    }

    @DELETE
    @Path("/books/{id}")
    @Consumes("application/json")
    public Response deleteBookInJSON(@PathParam("id") int bookId) {

        String result = "Book delete : " + bookId;
        return Response.status(201).entity(result).build();

    }
}
