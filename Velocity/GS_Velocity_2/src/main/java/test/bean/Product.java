package test.bean;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 02.09.2009
 * Time: 14:41:36
 * To change this template use File | Settings | File Templates.
 */
public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
