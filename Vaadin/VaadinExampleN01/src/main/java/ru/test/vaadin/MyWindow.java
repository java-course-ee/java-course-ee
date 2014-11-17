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
    private Window window = new Window("Test Vaadin window");

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        hLayout.setWidth(400, Sizeable.Unit.PIXELS);
        hLayout.setSpacing(true);

        hLayout.addComponent(textField);

        button.addClickListener(new MyButtonListener());

        hLayout.addComponent(button);

        hLayout.setComponentAlignment(textField, Alignment.BOTTOM_LEFT);
        hLayout.setComponentAlignment(button, Alignment.BOTTOM_RIGHT);

        hLayout.setMargin(true);

        window.setWidth(420, Unit.PIXELS);
        window.setHeight(200, Unit.PIXELS);
        window.setContent(hLayout);

        window.center();

        addWindow(window);
    }

    class MyButtonListener implements Button.ClickListener {

        @Override
        public void buttonClick(Button.ClickEvent event) {
            Notification.show("Hello " + textField.getValue().toString(), Notification.Type.TRAY_NOTIFICATION);
        }

    }

}