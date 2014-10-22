package com.geminisystems.subscription.domain;

import com.geminisystems.subscription.util.SubscriptionUtil;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 07.11.2011
 * Time: 13:33:26
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "T_SUBSCRIPTION")
public class SBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBSCR_ID", nullable = false, length = 10)
    private Integer subscrId;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "HASH", nullable = false)
    private String hash = SubscriptionUtil.getHash(String.valueOf(System.currentTimeMillis()));

    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean isActive;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "T_SUBSCRIPTION_CATEGORY",
            joinColumns = @JoinColumn(name = "SUBSCR_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    private List<SCategory> categories;

    //UPDATE SUBSCR.SUBSCRIPTION SET TYPE='USERS'
    @Column(name = "TYPE", nullable = true)
    @Enumerated(EnumType.STRING)
    private SType type = SType.USERS;

    public SBean() {
    }


    public SType getType() {
        return type;
    }

    public void setType(SType type) {
        this.type = type;
    }

    public Integer getSubscrId() {
        return subscrId;
    }

    public void setSubscrId(Integer subscrId) {
        this.subscrId = subscrId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<SCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<SCategory> categories) {
        this.categories = categories;
    }


}
