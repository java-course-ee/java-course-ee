package ru.test.struts2.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author artem.pronchakov@calisto.email
 */
@Entity
@Table(name = "transfer")
@NamedQueries({
        @NamedQuery(name = "Transfer.findAll", query = "SELECT t FROM Transfer t")})
public class Transfer implements Serializable, AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    @Column(name = "comment", length = 1000)
    private String comment;
    @JoinColumn(name = "senders_account", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Account sendersAccount;
    @JoinColumn(name = "recievers_account", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Account recieversAccount;

    public Transfer() {
    }

    public Transfer(Long id) {
        this.id = id;
    }

    public Transfer(Long id, BigDecimal amount, String comment) {
        this.id = id;
        this.amount = amount;
        this.comment = comment;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Account getSendersAccount() {
        return sendersAccount;
    }

    public void setSendersAccount(Account sendersAccount) {
        this.sendersAccount = sendersAccount;
    }

    public Account getRecieversAccount() {
        return recieversAccount;
    }

    public void setRecieversAccount(Account recieversAccount) {
        this.recieversAccount = recieversAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transfer)) {
            return false;
        }
        Transfer other = (Transfer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.test.struts2.entity.Transfer[ id=" + id + " ]";
    }

}
