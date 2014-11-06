package ru.test.struts2.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author artem.pronchakov@calisto.email
 */
@Entity
@Table(name = "account")
@NamedQueries({
        @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")})
public class Account implements Serializable, AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sendersAccount", fetch = FetchType.EAGER)
    private List<Transfer> outcommingTransfers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recieversAccount", fetch = FetchType.EAGER)
    private List<Transfer> incommingTransfers;
    @JoinColumn(name = "owner", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Person owner;

    public Account() {
    }

    public Account(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public List<Transfer> getOutcommingTransfers() {
        return outcommingTransfers;
    }

    public void setOutcommingTransfers(List<Transfer> outcommingTransfers) {
        this.outcommingTransfers = outcommingTransfers;
    }

    public List<Transfer> getIncommingTransfers() {
        return incommingTransfers;
    }

    public void setIncommingTransfers(List<Transfer> incommingTransfers) {
        this.incommingTransfers = incommingTransfers;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
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
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public double getCurrentAmount() {
        double amount = 0;
        for (Transfer t : incommingTransfers) {
            amount += t.getAmount().doubleValue();
        }
        for (Transfer t : outcommingTransfers) {
            amount -= t.getAmount().doubleValue();
        }
        return amount;
    }

    @Override
    public String toString() {
        return "Счет № " + getId() + ", сумма: " + getCurrentAmount();
    }

}
