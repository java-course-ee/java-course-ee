package ru.geminisystems.entity;

/**
 * Created by IntelliJ IDEA.
 * User: gb
 * Date: 08.07.2009
 * Time: 2:25:36
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "statuses")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statusId", nullable = false)
    private Long statusId;

    @Column(name = "statusName", nullable = false)
    private String statusName;

    @Column(name = "alias", nullable = true)
    private String alias;

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
