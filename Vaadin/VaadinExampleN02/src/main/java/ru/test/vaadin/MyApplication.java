package ru.test.vaadin;

import com.vaadin.Application;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class MyApplication extends Application {
    private Window mainWindow;
    private HorizontalLayout hLayout = new HorizontalLayout();
    private PopupDateField datetime;
    private TextField textField;

    @Override
    public void init() {
        setTheme("reindeer");
        setLocale(new Locale("RU"));

        mainWindow = new Window("Test Vaadin application");

        mainWindow.setWidth(500, Window.UNITS_PIXELS);
        mainWindow.setHeight(100, Window.UNITS_PIXELS);

        hLayout.setWidth(500, HorizontalLayout.UNITS_PIXELS);
        hLayout.setSpacing(true);

        datetime = new PopupDateField("Выберите дату: ");
        datetime.setValue(new Date());
        datetime.setResolution(PopupDateField.RESOLUTION_HOUR);

        datetime.addListener(new MyApplication.MyPropertyChangeListener());
        datetime.setImmediate(true);
        datetime.setRequired(true);
        datetime.setRequiredError("Обязательно для заполнения");
        datetime.setParseErrorMessage("Неправильный формат даты");

        hLayout.addComponent(datetime);

        textField = new TextField("Выбранное значение: ");
        textField.setWidth(300, TextField.UNITS_PIXELS);

        hLayout.addComponent(textField);

        mainWindow.addComponent(hLayout);

        setMainWindow(mainWindow);
    }

    class MyPropertyChangeListener implements Property.ValueChangeListener {

        @Override
        public void valueChange(ValueChangeEvent event) {
//			if (event.getProperty().getValue() == null) {
            if (!datetime.isValid()) {
                textField.setValue("Дата не выбрана");
            } else if (event.getProperty().getType() == Date.class) {
                Date date = (Date) event.getProperty().getValue();
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                textField.setValue(sdf.format(date));
            }
        }

    }

}