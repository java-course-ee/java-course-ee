package ru.gs.zk;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class MyComposer extends SelectorComposer<Window> {
//	@Wire
//	private Grid grid;
	@Wire
	private Listbox grid;
	private ListModelList<Employee> lml;

	public ListModelList<Employee> getLml() {
		return lml;
	}

	public void setLml(ListModelList<Employee> lml) {
		this.lml = lml;
	}

	@Override
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1, "Ivan", "Ivanov", new Date(), 456.54));
		list.add(new Employee(2, "Ivan2", "Ivanov2", new Date(), 556.54));
		list.add(new Employee(3, "Ivan3", "Ivanov3", new Date(), 656.54));
		list.add(new Employee(4, "Ivan4", "Ivanov4", new Date(), 756.54));
		list.add(new Employee(5, "Ivan5", "Ivanov5", new Date(), 856.54));
		list.add(new Employee(6, "Ivan6", "Ivanov6", new Date(), 956.54));
		
		lml = new ListModelList(list);

		grid.setModel(lml);

		System.out.println("Grid: " + grid + ", size: " + list.size());
		
    }

	@Listen("onClick = #ok")
	public void okClickHandler() {
		Messagebox.show("Selected Employee with id: " + ((Employee)grid.getSelectedItem().getValue()).getId(), "Message", Messagebox.OK, null);
	}
    
}
