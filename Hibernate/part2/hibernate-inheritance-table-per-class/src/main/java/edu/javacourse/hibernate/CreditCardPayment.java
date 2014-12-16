package edu.javacourse.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "jc_credit_payment_full")
@AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(name = "amount"))
})
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
