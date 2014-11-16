package ru.test.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

/**
 * Created by apronchakov on 16.11.14.
 */
@Theme("reindeer")
public class MyWindow extends UI {
    private HorizontalLayout hLayout = new HorizontalLayout();
    private TextField textField = new TextField("Имя");
    private Button button = new Button("OK");

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        button.addClickListener(new MyButtonListener());

        hLayout.setWidth(400, Sizeable.Unit.PIXELS);
        hLayout.setSpacing(true);

        hLayout.addComponent(textField);

        button.addClickListener(new MyButtonListener());

        hLayout.addComponent(button);

        setContent(hLayout);
    }

    class MyButtonListener implements Button.ClickListener {

        @Override
        public void buttonClick(Button.ClickEvent event) {
            Notification.show(textField.getValue().toString());
        }

    }

}