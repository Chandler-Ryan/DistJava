package com.chandlerryan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductCRUD implements ProductDAO {
    final String DB_URL = "jdbc:derby:CoolProductsDB";
    @Override
    public List<Product> getAllProducts(){
        List<Product>products = new ArrayList<>();
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ProdNum, Description, Price FROM Product";
            ResultSet rs = stmt.executeQuery(sql);
            if (!rs.wasNull()){
                while(rs.next()){
                    // Create Product Object
                    Product product = new Product(
                            rs.getString("ProdNum"),
                            rs.getString("Description"),
                            rs.getDouble("Price")
                    );
                    products.add(product);
                }
            }


            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return products;
    }
    @Override
    public Product getProduct(String ProdNum){
        Product product = new Product("","",0);
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ProdNum, Description, Price FROM Product WHERE PRODNUM = '" + ProdNum +"'";
            ResultSet rs = stmt.executeQuery(sql);
            if (!rs.wasNull()){
                while(rs.next()){
                    // Create Product Object
                    product = new Product(
                            rs.getString("ProdNum"),
                            rs.getString("Description"),
                            rs.getDouble("Price")
                    );
                }
            }


            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return product;
    }
    @Override
    public boolean addProduct (Product product){
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO Product " +
                    "VALUES ('"+product.getProdnum()+"','"+ product.getDescription()+ "',"+ product.getPrice()+")";
            stmt.execute(sql);
            //Clean-up environment
            stmt.close();
            conn.close();
            return true;
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }
    @Override
    public boolean updateProduct(Product product){
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            System.out.println("Updating records in the table...");
            stmt = conn.createStatement();

            String sql = "Update  Product SET DESCRIPTION ='"+ product.getDescription()+ "', PRICE="+ product.getPrice()+
                    "WHERE PRODNUM ='"+product.getProdnum()+"'";
            stmt.executeUpdate(sql);
            //Clean-up environment
            stmt.close();
            conn.close();
            return true;
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }
    @Override
    public boolean deleteProduct(String ProdNum){
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            System.out.println("Updating records in the table...");
            stmt = conn.createStatement();

            String sql = "Delete FROM Product WHERE PRODNUM ='"+ProdNum+"'";
            stmt.executeUpdate(sql);
            //Clean-up environment
            stmt.close();
            conn.close();
            return true;
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }
}
