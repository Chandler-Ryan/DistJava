package com.chandlerryan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateCoolProductsDB
{
    public CreateCoolProductsDB()
    {

        try
        {
            // Create a named constant for the URL.
            // NOTE: This value is specific for Java DB.
            final String DB_URL = "jdbc:derby:CoolProductsDB;create=true";

            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);

            // If the DB already exists, drop the tables.
            dropTables(conn);

            // Build the Product table.
            buildProductTable(conn);

            // Build the Customer table.
            buildCustomerTable(conn);

            // Close the connection.
            conn.close();
        } catch (Exception e)
        {
            System.out.println("Error Creating the Product Table");
            System.out.println(e.getMessage());
        }

    }

    /**
     * The dropTables method drops any existing
     * in case the database already exists.
     */
    public static void dropTables(Connection conn)
    {
        System.out.println("Checking for existing tables.");

        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            try
            {
                // Drop the Customer table.
                stmt.execute("DROP TABLE Customer");
                System.out.println("Customer table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }

            try
            {
                // Drop the Coffee table.
                stmt.execute("DROP TABLE Product");
                System.out.println("Product table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }
            try
            {
                // Drop the Coffee table.
                stmt.execute("DROP TABLE Cart");
                System.out.println("Product table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * The buildCoffeeTable method creates the
     * Coffee table and adds some rows to it.
     */
    public static void buildProductTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Product (" +
                    "Description CHAR(25), " +
                    "ProdNum CHAR(10) NOT NULL PRIMARY KEY, " +
                    "Price DOUBLE " +
                    ")");

            // Insert row #1.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 1', " +
                    "'14-001', " +
                    "8.95 )");

            // Insert row #1.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 2', " +
                    "'14-002', " +
                    "8.95 )");

            // Insert row #2.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 3', " +
                    "'15-001', " +
                    "7.95 )");

            // Insert row #3.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 4', " +
                    "'15-002', " +
                    "7.95 )");

            // Insert row #4.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 5', " +
                    "'15-003', " +
                    "8.55 )");

            // Insert row #5.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 6', " +
                    "'16-001', " +
                    "9.95 )");

            // Insert row #6.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 7', " +
                    "'16-002', " +
                    "9.95 )");

            // Insert row #1.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 8', " +
                    "'17-001', " +
                    "7.95 )");

            // Insert row #7.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 9', " +
                    "'17-002', " +
                    "8.95 )");

            // Insert row #8.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 10', " +
                    "'17-003', " +
                    "7.95 )");

            // Insert row #9.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 11', " +
                    "'17-004', " +
                    "11.95 )");

            // Insert row #10.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 12', " +
                    "'18-001', " +
                    "18.45 )");

            // Insert row #11.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 13', " +
                    "'18-002', " +
                    "18.45 )");

            // Insert row #12.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 14', " +
                    "'19-001', " +
                    "9.65 )");

            // Insert row #13.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 15', " +
                    "'20-001', " +
                    "6.85 )");

            // Insert row #14.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 16', " +
                    "'21-001', " +
                    "9.95 )");

            // Insert row #15.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 17', " +
                    "'21-002', " +
                    "10.45 )");

            // Insert row #16.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cool Product 18', " +
                    "'21-003', " +
                    "9.95 )");

            System.out.println("Coffee table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * The buildCustomerTable method creates the
     * Customer table and adds some rows to it.
     */
    public static void buildCustomerTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Customer" +
                    "( CustomerNumber CHAR(10) NOT NULL PRIMARY KEY, " +
                    "  Name CHAR(25)," +
                    "  Address CHAR(25)," +
                    "  City CHAR(12)," +
                    "  State CHAR(2)," +
                    "  Zip CHAR(5) )");

            // Add some rows to the new table.
            stmt.executeUpdate("INSERT INTO Customer VALUES" +
                    "('101', 'Downtown Cafe', '17 N. Main Street'," +
                    " 'Asheville', 'NC', '55515')");

            stmt.executeUpdate("INSERT INTO Customer VALUES" +
                    "('102', 'Main Street Grocery'," +
                    " '110 E. Main Street'," +
                    " 'Canton', 'NC', '55555')");

            stmt.executeUpdate("INSERT INTO Customer VALUES" +
                    "('103', 'The Coffee Place', '101 Center Plaza'," +
                    " 'Waynesville', 'NC', '55516')");

            System.out.println("Customer table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * The buildCustomerTable method creates the
     * Customer table and adds some rows to it.
     */
    public static void buildCartTable(Connection conn)
    {
        try
        {
            /*
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Cart" +
                    "( CartNumber CHAR(10) NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY\n" +
                    "        (START WITH 1, INCREMENT BY 1), " +
                    "  Product CHAR(25)," +
                    "  Address CHAR(25)," +
                    "  City CHAR(12)," +
                    "  State CHAR(2)," +
                    "  Zip CHAR(5) )");

            // Add some rows to the new table.
            stmt.executeUpdate("INSERT INTO Customer VALUES" +
                    "('101', 'Downtown Cafe', '17 N. Main Street'," +
                    " 'Asheville', 'NC', '55515')");

            stmt.executeUpdate("INSERT INTO Customer VALUES" +
                    "('102', 'Main Street Grocery'," +
                    " '110 E. Main Street'," +
                    " 'Canton', 'NC', '55555')");

            stmt.executeUpdate("INSERT INTO Customer VALUES" +
                    "('103', 'The Coffee Place', '101 Center Plaza'," +
                    " 'Waynesville', 'NC', '55516')");*/

            System.out.println("Customer table created.");
        } catch (Exception ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}