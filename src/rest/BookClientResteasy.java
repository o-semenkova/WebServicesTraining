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

        try {
            int bookId = 1;
            ClientRequest request = new ClientRequest(
                    "http://localhost:8080/rest/books/" + bookId);
            request.accept("application/json");
            ClientResponse<String> response = request.get(String.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            Gson gson = new Gson();
            Book book = gson.fromJson(response.getEntity(), Book.class);

            System.out.println("Output from Server .... \n");

            System.out.println(book.toString());


        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
