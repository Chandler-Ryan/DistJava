package product.controller;

import product.model.product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class products extends HttpServlet{
    /**
     * This is the main controller for the Store App
     *
     * @author    Just wingging it
     * @version   1.00
     */
        private static final String RESULT_PAGE = "viewCart.jsp";//"result.jsp";

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

            Enumeration<String> names = request.getParameterNames();

            List<product> result = new ArrayList<>(); //be.getBrands(c.trim());
            int productCount = 0;
            while (names.hasMoreElements()){
                productCount++;
                names.nextElement();
            }
            //while(names.hasMoreElements()) {
             //   result.add(names.nextElement());
            //}
            for(int i = 1; i < (productCount/4) + 1; i++){
             product item = new product(
                        Integer.parseInt(request.getParameter("id" + i)),
                        request.getParameter("name" + i),
                        Double.parseDouble(request.getParameter("price" + i))
                );
             if (request.getParameter("qty" + i) != null){
                 if (isInteger(request.getParameter("qty" + i))){
                     item.setQuantity(Integer.parseInt(request.getParameter("qty" + i)));
                 }else{
                     item.setQuantity(0);
                 }

             }
                result.add(item);
            }
// TODO set viewCart to a jsp and adjust routing to match
            // Parameters are read only Request object properties, but attributes
            // are read/write. We can use attributes to store data for use on
            // another page.
            request.setAttribute("products", result);

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
            return "Main Controller";
        }// </editor-fold>

    private static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        if (str.isEmpty()) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (str.length() == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    }


