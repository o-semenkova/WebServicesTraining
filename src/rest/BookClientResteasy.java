package rest;

import com.google.gson.Gson;
import org.apache.http.client.ClientProtocolException;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import domain.Book;

import java.io.IOException;

/**
 * Created by osemenkova on 11/27/2016.
 */
public class BookClientResteasy {

    public static void main(String[] args) {
        Gson gson = new Gson();
        try {
            int bookId = 1;
            ClientRequest getBookRequest = new ClientRequest(
                    "http://localhost:8080/rest/books/" + bookId);
            getBookRequest.accept("application/json");
            ClientResponse<String> getBookResponse = getBookRequest.get(String.class);

            if (getBookResponse.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + getBookResponse.getStatus());
            }
            Book book = gson.fromJson(getBookResponse.getEntity(), Book.class);
            System.out.println("Output from Server .... \n");

            System.out.println(book.toString());
//***************************************************************************************************
            Book newBook = new Book();
            newBook.setAuthor("Tomson");
            newBook.setTitle("Fly");
            newBook.setId(2);


            ClientRequest postBookRequest = new ClientRequest(
                    "http://localhost:8080/rest/books/");
            postBookRequest.accept("application/json");
            String gsonBook = gson.toJson(newBook);

            postBookRequest.body("application/json", gsonBook);

            ClientResponse<String> postBookResponse = postBookRequest.post(String.class);

            System.out.println("Output from Server .... \n");

            System.out.println(postBookResponse.getStatus());

        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
