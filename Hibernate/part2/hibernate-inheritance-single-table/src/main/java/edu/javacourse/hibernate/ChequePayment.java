package edu.javacourse.hibernate;

import javax.persistence.*;

@Entity
@DiscriminatorValue("3")
public class ChequePayment extends Payment {

    @Column(name = "BANK_ID")
    private String bankId;

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    @Override
    public String toString() {
        return "ChequePayment{" +
                "bankId='" + bankId + '\'' +
                "} " + super.toString();
    }
}
