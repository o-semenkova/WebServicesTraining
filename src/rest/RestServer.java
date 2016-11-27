package rest;

import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by osemenkova on 11/26/2016.
 */

@Path("/rest/SimpleRestServer")
public class RestServer extends HttpServlet {

@GET
@Produces(MediaType.APPLICATION_JSON)
public Response calculateWithGet(@QueryParam("a") double a, @QueryParam("b") double b, @QueryParam("operation") String operation) throws OperationNotSupportedException {

    Gson gson = new Gson();
    String output = gson.toJson(calculate(a, b, operation));

    return Response.status(200).entity(output).build();

}
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculateWithPost(@QueryParam("a") double a, @QueryParam("b") double b, @QueryParam("operation") String operation) throws OperationNotSupportedException {

        Gson gson = new Gson();
        String output = gson.toJson(calculate(a, b, operation));

        return Response.status(200).entity(output).build();
    }

    private double calculate(double a, double b, String operation) throws OperationNotSupportedException {
        double calculationResult = 0;

        if(operation.equalsIgnoreCase("sum")){
            calculationResult = a + b;
        }else if(operation.equalsIgnoreCase("multiply")){
            calculationResult = a * b;
        }else if(operation.equalsIgnoreCase("divide")){
            calculationResult = a / b;
        }else if(operation.equalsIgnoreCase("subtract")){
            calculationResult = a - b;
        }else{
            throw new OperationNotSupportedException();
        }
        return calculationResult;
    }

}
