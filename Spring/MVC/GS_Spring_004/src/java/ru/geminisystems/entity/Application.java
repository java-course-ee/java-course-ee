package ru.geminisystems.entity;

/**
 * Created by IntelliJ IDEA.
 * User: gb
 * Date: 08.07.2009
 * Time: 2:24:44
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicationId", nullable = false)
    private Long applicationId;

    @Column(name = "applicationName", nullable = false)
    private String applicationName;

    @Column(name = "description", nullable = true)
    private String description;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "statusId", nullable = false)
    private Status status;


    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
