package edu.javacourse.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "jc_credit_payment")
@PrimaryKeyJoinColumn(name = "PAYMENT_ID")
public class CreditCardPayment extends Payment {

    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "CreditCardPayment{" +
                "cardNumber='" + cardNumber + '\'' +
                "} " + super.toString();
    }
}
