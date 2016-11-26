
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by osemenkova on 11/26/2016.
 */

@WebServlet("/SimpleRestServer")
public class RestServer extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        double calculationResult = 0;

        double a = Double.valueOf(request.getParameter("a"));
        double b = Double.valueOf(request.getParameter("b"));
        String operation = request.getParameter("operation");

        if(operation.equals("sum")){
            calculationResult = a + b;
        }else if(operation.equals("multiply")){
            calculationResult = a * b;
        }else if(operation.equals("divide")){
            calculationResult = a / b;
        }else if(operation.equals("subtract")){
            calculationResult = a - b;
        }

        Gson gson = new Gson();
        String output = gson.toJson(calculationResult);

        response.setContentType("application/json");

        response.getWriter().append(output);
    }
}
