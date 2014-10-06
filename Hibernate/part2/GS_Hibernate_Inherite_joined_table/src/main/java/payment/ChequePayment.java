package payment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="jc_cheque_payment")
@PrimaryKeyJoinColumn(name="PAYMENT_ID")
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
