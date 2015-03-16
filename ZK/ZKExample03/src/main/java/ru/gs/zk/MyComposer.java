package ru.gs.zk;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class MyComposer extends GenericForwardComposer {
    private Textbox name;
    private Textbox login;
    private Textbox email;
    private Datebox birthDate;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

    }

    public void onClick$ok(Event event) throws WrongValueException {
        if (!name.isValid()) {
            throw new WrongValueException(name, WrongValueException.NULL_CODE);
        } else if (!login.isValid()) {
            throw new WrongValueException(login, "Логин обязателен на заполнение");
        } else if (!email.isValid()) {
            throw new WrongValueException(email, "E-mail это e-mail. Не хитри.");
        } else if (!birthDate.isValid()) {
            throw new WrongValueException(birthDate, "Дата рождения обязательна и она должна быть в прошлом");
        } else {
            String info = "name: " + name.getValue() +
                    "\r\nlogin: " + login.getValue() +
                    "\r\nemail: " + email.getValue() +
                    "\r\nbirth: " + birthDate.getValue();
            Messagebox.show(info, "Введенная информация", Messagebox.OK, Messagebox.INFORMATION);
        }
    }

}
