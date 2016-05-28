package ru.test.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
@Theme("valo")
public class MyWindow extends UI {
    private Window mainWindow = new Window("Test Vaadin application");;
    private HorizontalLayout hLayout = new HorizontalLayout();
    private PopupDateField datetime;
    private TextField textField;

    @Override
    public void init(VaadinRequest vaadinRequest) {
        hLayout.setSpacing(true);
        hLayout.setMargin(true);

        datetime = new PopupDateField("Выберите дату: ");
        datetime.setValue(new Date());
        datetime.setResolution(Resolution.HOUR);

        datetime.addValueChangeListener(new MyWindow.MyPropertyChangeListener());
        datetime.setImmediate(true);
        datetime.setRequired(true);
        datetime.setRequiredError("Обязательно для заполнения");
        datetime.setParseErrorMessage("Неправильный формат даты");

        hLayout.addComponent(datetime);

        textField = new TextField("Выбранное значение: ");
        textField.setWidth(200, Unit.PIXELS);

        hLayout.addComponent(textField);

        mainWindow.setWidth(600, Unit.PIXELS);
        mainWindow.setHeight(200, Unit.PIXELS);

        mainWindow.center();
        mainWindow.setContent(hLayout);

        addWindow(mainWindow);
    }

    class MyPropertyChangeListener implements Property.ValueChangeListener {

        @Override
        public void valueChange(ValueChangeEvent event) {
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