package ru.gs.zk;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;

/**
 *
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public class MyComposer extends GenericForwardComposer {
    public static final String DATE_FORMAT = "dd.MM.yyyy HH:mm:ss";
    private Datebox firstDate;
    private Datebox secondDate;
    private Label count;
    private Label someElseParam;
    private Label fromDate;
    private Label toDate;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        
        firstDate.setFormat(DATE_FORMAT);
        firstDate.setLocale("RU");
        firstDate.setValue(new Date());
        
        secondDate.setFormat(DATE_FORMAT);
        secondDate.setLocale("RU");
    }
    
    
    
    public void onClick$request(Event event) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        DateFormat dateFormat = DateFormat.getDateInstance();
        
        if (firstDate.getValue() != null) {
            fromDate.setValue(sdf.format(firstDate.getValue()));
        } else {
            fromDate.setValue("'не указано'");
        }
        
        if (secondDate.getValue() != null) {
            toDate.setValue(sdf.format(secondDate.getValue()));
        } else {
            toDate.setValue("'не указано'");
        }
        
        count.setValue("456");
        someElseParam.setValue("23");
    }
    
}
