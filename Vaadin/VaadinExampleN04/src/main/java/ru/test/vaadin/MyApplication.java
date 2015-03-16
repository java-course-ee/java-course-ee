package ru.test.vaadin;

import com.vaadin.Application;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.*;

import java.util.Locale;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class MyApplication extends Application {
    private Window mainWindow;
    private HorizontalLayout hLayout = new HorizontalLayout();

    @Override
    public void init() {
        setTheme("reindeer");
        setLocale(new Locale("RU"));

        mainWindow = new Window("Test Vaadin application");

        mainWindow.setWidth(600, Window.UNITS_PIXELS);
        mainWindow.setHeight(300, Window.UNITS_PIXELS);

        hLayout.setWidth(600, HorizontalLayout.UNITS_PIXELS);
        hLayout.setSpacing(true);

        TwinColSelect colSelect = new TwinColSelect();
        colSelect.setImmediate(true);
        colSelect.setRows(7);
        colSelect.setLeftColumnCaption("Откуда берем:");
        colSelect.setRightColumnCaption("Куда складываем:");
        colSelect.setWidth("600px");
        colSelect.setMultiSelect(true);

        CustomValue cv1 = new CustomValue(1004L, "Первое значение");
        CustomValue cv2 = new CustomValue(22L, "Второе значение");
        CustomValue cv3 = new CustomValue(389L, "Третье значение");
        CustomValue cv4 = new CustomValue(253L, "Четвертое значение");
        CustomValue cv5 = new CustomValue(512L, "Пятое значение");

        IndexedContainer indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("id", Long.class, null);
        indexedContainer.addContainerProperty("name", String.class, null);

        Item item = indexedContainer.addItem(cv1.getName());
        item.getItemProperty("id").setValue(cv1.getId());
        item.getItemProperty("name").setValue(cv1.getName());

        item = indexedContainer.addItem(cv2.getName());
        item.getItemProperty("id").setValue(cv2.getId());
        item.getItemProperty("name").setValue(cv2.getName());

        item = indexedContainer.addItem(cv3.getName());
        item.getItemProperty("id").setValue(cv3.getId());
        item.getItemProperty("name").setValue(cv3.getName());

        item = indexedContainer.addItem(cv4.getName());
        item.getItemProperty("id").setValue(cv4.getId());
        item.getItemProperty("name").setValue(cv4.getName());

        item = indexedContainer.addItem(cv5.getName());
        item.getItemProperty("id").setValue(cv5.getId());
        item.getItemProperty("name").setValue(cv5.getName());

        indexedContainer.sort(new Object[]{"id"}, new boolean[]{true});

        colSelect.setContainerDataSource(indexedContainer);

        hLayout.addComponent(colSelect);

        mainWindow.addComponent(hLayout);

        setMainWindow(mainWindow);
    }

}

