package Product.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Cart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");

        for (Cookie cookie : request.getCookies()) {
            cookie.setValue("");
            cookie.setMaxAge(0);
            cookie.setPath("/Project5_war_exploded");

            response.addCookie(cookie);
        }

        response.sendRedirect("index.jsp");





    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        for (Cookie cookie : request.getCookies()) {
            if(cookie.getName().equals(request.getParameter("remove"))){
                cookie.setValue("");
                cookie.setMaxAge(0);
                cookie.setPath("/Project5_war_exploded");

                response.addCookie(cookie);
            }
        }

        response.sendRedirect("viewCart.jsp");

    }
}
