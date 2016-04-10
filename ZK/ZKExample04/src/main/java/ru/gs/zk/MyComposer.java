package ru.gs.zk;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.*;

/**
 *
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class MyComposer extends SelectorComposer<Window> {
//	private Grid grid;
	@Wire
	private Listbox grid;
	private ListModelList lml;

	public Listbox getGrid() {
		return grid;
	}

	public void setGrid(Listbox grid) {
		this.grid = grid;
	}

	public ListModelList getLml() {
		return lml;
	}

	public void setLml(ListModelList lml) {
		this.lml = lml;
	}

	@Override
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

		System.out.println("1");
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1, "Ivan", "Ivanov", new Date(), 456.54));
		list.add(new Employee(2, "Ivan2", "Ivanov2", new Date(), 556.54));
		list.add(new Employee(3, "Ivan3", "Ivanov3", new Date(), 656.54));
		list.add(new Employee(4, "Ivan4", "Ivanov4", new Date(), 756.54));
		list.add(new Employee(5, "Ivan5", "Ivanov5", new Date(), 856.54));
		list.add(new Employee(6, "Ivan6", "Ivanov6", new Date(), 956.54));
		
		lml = new ListModelList(list);

		System.out.println("2");

		grid.setModel(lml);

		System.out.println("3");

		System.out.println("Grid: " + grid + ", size: " + list.size());
		
    }
    
}
