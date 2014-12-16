package edu.javacourse.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "jc_cash_payment")
@PrimaryKeyJoinColumn(name = "PAYMENT_ID")
public class CashPayment extends Payment {

    @Column(name = "CASH_DESK")
    private String cashDesk;

    public String getCashDesk() {
        return cashDesk;
    }

    public void setCashDesk(String cashDesk) {
        this.cashDesk = cashDesk;
    }

    @Override
    public String toString() {
        return "CashPayment{" +
                "cashDesk='" + cashDesk + '\'' +
                "} " + super.toString();
    }
}
