package bean;

import java.util.Date;

/**
 * Author: Georgy Gobozov
 * Date: 24.04.13
 */
public class Content {

    private String title;
    private String content;
    private Date date;


    public Content(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
