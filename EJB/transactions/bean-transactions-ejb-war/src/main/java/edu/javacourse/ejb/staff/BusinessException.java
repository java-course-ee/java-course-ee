package edu.javacourse.ejb.staff;

import javax.ejb.ApplicationException;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class BusinessException extends Exception {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

}
