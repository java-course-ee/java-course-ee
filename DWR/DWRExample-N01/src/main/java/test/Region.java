package test;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="regions")
public class Region implements Serializable {
  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="region_id")
    private Long regionId;
    
    @Column(name="region_name", nullable=true)
    private String name;

    public Region() {
    }

    public Region(String name) {
        this.name = name;
    }
    
    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return regionId+":"+name;
    }
}
