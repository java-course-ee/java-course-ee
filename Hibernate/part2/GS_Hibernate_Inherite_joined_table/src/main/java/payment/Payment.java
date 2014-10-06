package payment;

import javax.persistence.*;

@Entity
@Table(name = "jc_payment")
@Inheritance(strategy = InheritanceType.JOINED)

//@NamedQueries({
//    @NamedQuery(name = "Payment.findByAmount",
//            query = "from Payment p where p.amount>:amount"),
//    @NamedQuery(name = "Payment.findAmountOnly",
//            query = "select p.amount from Payment p")
//})
public class Payment {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
