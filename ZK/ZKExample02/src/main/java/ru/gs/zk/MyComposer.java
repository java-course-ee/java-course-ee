package ru.gs.zk;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class MyComposer extends SelectorComposer<Component> {
    public final String DATE_FORMAT = "dd.MM.yyyy HH:mm:ss";
    @Wire
    private Datebox firstDate;
    @Wire
    private Datebox secondDate;
    @Wire
    private Label count;
    @Wire
    private Label someElseParam;
    @Wire
    private Label fromDate;
    @Wire
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
    
    
    @Listen("onClick = #request")
    public void requestButtonOnClick() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

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
