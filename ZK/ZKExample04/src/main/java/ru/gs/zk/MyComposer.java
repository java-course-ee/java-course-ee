package ru.gs.zk;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.WrongValuesException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.*;

/**
 *
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class MyComposer extends GenericForwardComposer {
	private AnnotateDataBinder dataBinder;
	private Grid grid;
	private ListModelList lml;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
		
		dataBinder = new AnnotateDataBinder(comp);
		
		List<MyEntity> list = new ArrayList<MyEntity>();
		list.add(new MyEntity(1, "Ivan", "Ivanov", new Date(), 456.54));
		list.add(new MyEntity(2, "Ivan2", "Ivanov2", new Date(), 556.54));
		list.add(new MyEntity(3, "Ivan3", "Ivanov3", new Date(), 656.54));
		list.add(new MyEntity(4, "Ivan4", "Ivanov4", new Date(), 756.54));
		list.add(new MyEntity(5, "Ivan5", "Ivanov5", new Date(), 856.54));
		list.add(new MyEntity(6, "Ivan6", "Ivanov6", new Date(), 956.54));
		
		lml = new ListModelList(list);
		
		dataBinder.bindBean("lml", lml);
		dataBinder.loadAll();
    }
    
}
