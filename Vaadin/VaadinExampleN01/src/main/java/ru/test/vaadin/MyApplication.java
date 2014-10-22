package ru.test.vaadin;

import com.vaadin.Application;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

import java.util.Locale;

/**
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public class MyApplication extends Application {
    private Window mainWindow;
    private HorizontalLayout hLayout = new HorizontalLayout();
    private Label label = new Label("Имя");
    private TextField textField = new TextField();
    private Button button = new Button("OK");

    @Override
    public void init() {
        //setTheme("chameleon");
        setTheme("reindeer");
        setLocale(new Locale("RU"));

        mainWindow = new Window("Test Vaadin application");

        mainWindow.setWidth(400, Window.UNITS_PIXELS);
        mainWindow.setHeight(100, Window.UNITS_PIXELS);

        hLayout.setWidth(400, HorizontalLayout.UNITS_PIXELS);
        hLayout.setSpacing(true);

        hLayout.addComponent(label);
        hLayout.addComponent(textField);

        mainWindow.addComponent(hLayout);

        button.addListener(new MyButtonListener());

        mainWindow.addComponent(button);

        setMainWindow(mainWindow);
    }

    class MyButtonListener implements Button.ClickListener {

        @Override
        public void buttonClick(ClickEvent event) {
            mainWindow.showNotification(textField.getValue().toString());
        }

    }

}
