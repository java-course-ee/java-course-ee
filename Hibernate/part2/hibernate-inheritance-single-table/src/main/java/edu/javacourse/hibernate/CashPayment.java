package edu.javacourse.hibernate;

import javax.persistence.*;

@Entity
@DiscriminatorValue("2")
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
