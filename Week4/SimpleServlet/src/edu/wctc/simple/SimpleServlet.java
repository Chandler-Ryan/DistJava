package edu.wctc.simple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "SimpleServlet")
public class SimpleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Students theStudents2 = new Students();

        ArrayList<Individual> result2;

        result2 = theStudents2.findStudents(FindColumns.valueOf(request.getParameter("searchType")), request.getParameter("message"));
        PrintWriter out = response.getWriter();
        out.println("<html><head>\n" +
                "        <!-- Latest compiled and minified CSS -->\n" +
                "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" \n" +
                "        integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n" +
                "    </head><body><div class=\"container\"><h1>Search results:</h1><table class=\"table table-hover table-striped\">");
        out.println("<tr><th>Account Number</th><th>First Name</th><th>Last Name</th><th>Email</th><th>IP Address</th></tr>");
        for (Individual i: result2) {

            out.println("<tr><td>"+i.getAccountNumber() + "</td><td>" + i.getFname() + "</td><td>" + i.getLname()+
                    "</td><td>" + i.getEmail()+ "</td><td>" + i.getIpAddress()+"</td></tr>");
        }

        out.println("</table></div></body></html>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<html><head></head><body><h1>Simple Web Page</h1><p>The Test.");
        out.println(request.getParameter("message"));
        out.println("</p></body></html>");
    }


}