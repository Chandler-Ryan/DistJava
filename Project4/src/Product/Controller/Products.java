package Product.Controller;

import Product.Model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Products extends HttpServlet {
    /**
     * This is the main controller for the Store App
     *
     * @author    Just wingging it
     * @version   1.00
     */
        private static final String RESULT_PAGE = "viewCart.jsp";

        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Handles the HTTP <code>GET</code> method. Not currently used.
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

        } // </editor-fold>

        /**
         * Handles the HTTP <code>POST</code> method.
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.setContentType("text/html");
            ArrayList<Product>ProductList = new ArrayList<Product>();
            ProductList.add(new Product(1, "Cool Product 1", 0.99 ));
            ProductList.add(new Product(2, "Cool Product 2", 9.99));
            ProductList.add(new Product(3, "Cool Product 3", 99.99));

            String productID = request.getParameter("id");
            int quantity = 0;
            try
            {
                quantity = parseInt(request.getParameter("qty"+productID));
                if (quantity > 0)
                {
                    Cookie cookie = new Cookie(productID, Integer.toString(quantity));
                    cookie.setMaxAge(60*60*24);
                    response.addCookie(cookie);
                }
            }
            catch (Exception e)
            {

            }
            request.setAttribute("Catalog", ProductList);
            // This object lets you forward both the request and response
            // objects to a destination page
            RequestDispatcher view =
                    request.getRequestDispatcher(RESULT_PAGE);
            view.forward(request, response);
        }

        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Returns a short description of the servlet.
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo() {
            return "Main Product.Controller";
        }// </editor-fold>
    }