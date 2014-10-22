package bean;

/**
 * Created by IntelliJ IDEA.
 * User: gb
 * Date: 02.09.2009
 * Time: 1:48:21
 * To change this template use File | Settings | File Templates.
 */
public class Product {

    private String name;
    private double price;

    public Product(String aName, double aPrice) {
        name = aName;
        price = aPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String val) {
        name = val;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double val) {
        price = val;
    }

    public String getNameAndPrice() {
        return "Name: " + getName() + " Price: " + getPrice();
    }
}
