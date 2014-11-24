package gemini.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Author: Georgy Gobozov
 * Date: 31.03.13
 */
@ManagedBean(name = "address")
@SessionScoped
public class AddressBean implements Serializable {

    private String city;
    private String street;
    private int building;

    public AddressBean() {
    }

    public AddressBean(String city, String street, int building) {
        this.city = city;
        this.street = street;
        this.building = building;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }
}
