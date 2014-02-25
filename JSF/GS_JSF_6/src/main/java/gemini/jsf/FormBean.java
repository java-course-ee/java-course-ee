package gemini.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 08.04.13
 */
@ManagedBean(name = "formbean")
@RequestScoped
public class FormBean {

    private String text;
    private String password;
    private String textArea;
    public boolean rememberMe;
    private List<String> selectedBox;
    private String radio;
    private String select;
    private String dropdown;

    public String getDropdown() {
        return dropdown;
    }

    public void setDropdown(String dropdown) {
        this.dropdown = dropdown;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public List<String> getSelectedBox() {
        return selectedBox;
    }

    public void setSelectedBox(List<String> selectedBox) {
        this.selectedBox = selectedBox;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getTextArea() {
        return textArea;
    }

    public void setTextArea(String textArea) {
        this.textArea = textArea;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
