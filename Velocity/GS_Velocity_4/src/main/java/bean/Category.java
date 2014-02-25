package bean;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 24.04.13
 */
public class Category {

    private String name;
    private List<Content> content;


    public Category(String name) {
        this.name = name;
    }

    public Category(String name, List<Content> content) {
        this.name = name;
        this.content = content;
    }

    public List<Content> getContent() {
        if (content == null)
            content = new ArrayList<Content>();
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
