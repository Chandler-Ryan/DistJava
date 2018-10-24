import Product.Controller.ProductCRUD;
import Product.Controller.ProductDAO;
import Product.Model.Product;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        CreateCoolProductsDB cc = new CreateCoolProductsDB();
        System.out.println("Original Data");
        System.out.println("==========================");
        outputDB();
        boolean exit = false;
        String uInput;
        while (!exit){
            System.out.println("1) Get all Product.Model.Product");
            System.out.println("2) Get ONE Products");
            System.out.println("3) Add Product.Model.Product");
            System.out.println("4) Update Product.Model.Product");
            System.out.println("5) Delete Product.Model.Product");
            System.out.println("Anything else to exit");
            System.out.println("==========================");
            uInput = keyboard.nextLine().substring(0,1);
            //init DAO
            ProductDAO productDB = new ProductCRUD();
            switch(uInput){
                case "1":
                    List<Product> productList = productDB.getAllProducts();
                    for(Product product: productList){
                        System.out.println(product.getProdnum() + " " + product.getDescription() + " " + product.getPrice());
                    }
                    break;
                case "2":
                    Product item = productDB.getProduct("21-003");
                    System.out.println("Product.Model.Product:");
                    System.out.println("==========================");
                    System.out.println(item.getProdnum() + " " + item.getDescription() + " " + item.getPrice());
                    System.out.println("==========================");
                    break;
                case "3":
                    System.out.println("What is the product number?");
                    String prodNo = keyboard.nextLine();
                    System.out.println("What is the description?");
                    String desc = keyboard.nextLine();
                    boolean parse = false;
                    double price = 0;
                    while (!parse){
                        System.out.println("Enter price");
                        try{
                            price = Double.parseDouble(keyboard.nextLine());
                            parse = true;
                        }
                        catch (Exception e){
                            System.out.println("not a price");
                        }
                    }
                    if(productDB.addProduct(new Product(prodNo,desc, price))){
                        System.out.println("Inserted records into the table...");
                    }else{
                        System.out.println("ERROR Inserting record into the table...");
                    }
                    break;
                case "4":
                    System.out.println("What is the product number?");
                    prodNo = keyboard.nextLine();
                    System.out.println("What is the description?");
                    desc = keyboard.nextLine();
                    parse = false;
                    price = 0;
                    while (!parse){
                        System.out.println("Enter price");
                        try{
                            price = Double.parseDouble(keyboard.nextLine());
                            parse = true;
                        }
                        catch (Exception e){
                            System.out.println("not a price");
                        }
                    }
                    if(productDB.updateProduct(new Product(prodNo,desc, price))){
                        System.out.println("Updated records into the table...");
                    }else{
                        System.out.println("ERROR Updating record into the table...");
                    }
                    break;
                case "5":
                    System.out.println("What is the product number to Delete?");
                    prodNo = keyboard.nextLine();
                    if(productDB.deleteProduct(prodNo)){
                        System.out.println("Deleted record into the table...");
                    }else{
                        System.out.println("ERROR Deleting record into the table...");
                    }
                    break;
                default: exit = true;
            }
        }
    }

    public static void outputDB() {
        final String DB_URL = "jdbc:derby:Productf" +
                "DB";
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

            while(rs.next()){
                //Retrieve by column name
                String id  = rs.getString("ProdNum");
                double price = rs.getDouble("Price");
                String description = rs.getString("Description");

                //Display values
                System.out.print("ID: " + id.trim());
                System.out.print(", Price: " + price);
                System.out.println(", Description: " + description);
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
    }
}
