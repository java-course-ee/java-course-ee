package ru.test.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.renderers.DateRenderer;

import java.util.Set;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
@Theme("valo")
public class MyWindow extends UI {
    private Window mainWindow = new Window("Test Vaadin application");
    private VerticalLayout verticalLayout = new VerticalLayout();
    Grid grid = new Grid("Person list");


    private PersonFormLayout formLayout = new PersonFormLayout();

    class PersonFormLayout extends FormLayout {
        public TextField id = new TextField("ID");
        public TextField name = new TextField("Full name");
        public DateField birth = new DateField("Birth Date");

        public PersonFormLayout() {
            birth.setDateFormat("dd-MM-yyyy");
            addComponents(id, name, birth);
        }
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        mainWindow = new Window("Test Vaadin application");

        mainWindow.setWidth(800, Unit.PIXELS);
        mainWindow.setHeight(600, Unit.PIXELS);
        mainWindow.center();

        grid.setWidth("100%");
        grid.setHeight(300, Unit.PIXELS);
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);

        grid.setContainerDataSource(new BeanItemContainer<Person>(Person.class, DaoImpl.getAllPersons()));
        grid.setColumns("name", "birth");
        Grid.Column bornColumn = grid.getColumn("birth");
        bornColumn.setRenderer(new DateRenderer("%1$td-%1$tm-%1$tY"));
        grid.addSelectionListener(event -> {
            Set<Object> selected = event.getSelected();
            Person o = (Person) selected.toArray()[0];
            BeanFieldGroup.bindFieldsUnbuffered(o, formLayout);
            formLayout.id.setEnabled(true);
            formLayout.name.setEnabled(true);
            formLayout.birth.setEnabled(true);
        });

        formLayout.id.setEnabled(false);
        formLayout.name.setEnabled(false);
        formLayout.birth.setEnabled(false);

        verticalLayout.setMargin(true);

        verticalLayout.addComponent(grid);
        verticalLayout.addComponent(formLayout);

        mainWindow.setContent(verticalLayout);

        addWindow(mainWindow);
    }
}

