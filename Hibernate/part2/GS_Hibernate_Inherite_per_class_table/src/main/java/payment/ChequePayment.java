package payment;

import javax.persistence.*;

@Entity
@Table(name="jc_cheque_payment_full")
@AttributeOverrides({
        @AttributeOverride(name="amount", column=@Column(name="amount"))
})
public class ChequePayment extends Payment {

    @Column(name="BANK_ID")
    private String bankId;

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }
}
