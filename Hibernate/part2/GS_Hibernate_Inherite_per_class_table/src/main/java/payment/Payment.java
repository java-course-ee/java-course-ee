package payment;

import javax.persistence.*;

@Entity
@Table(name = "jc_payment_full")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Payment {

    @Id
    @Column(name = "PAYMENT_ID")
    protected Integer paymentId;

    @Column(name = "AMOUNT")
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }
}
