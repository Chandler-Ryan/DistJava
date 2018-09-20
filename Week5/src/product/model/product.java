package product.model;

public class product {
    private int ID;
    private String Name;
    private double price;
    private int quantity;

    public product(int ID, String name, double price) {
        this.ID = ID;
        Name = name;
        this.price = price;
    }


    public int getQuantity() {return quantity; }

    public void setQuantity(int quantity) {this.quantity = quantity; }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
