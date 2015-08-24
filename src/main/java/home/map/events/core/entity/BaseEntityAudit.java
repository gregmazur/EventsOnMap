package home.map.events.core.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by greg on 21.07.15.
 */
@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity {

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    @Column(name = "createdBy", length = 20)
    private UserDetail createdBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


    @Column(name = "updated_by", length = 20)
    private UserDetail updatedBy;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UserDetail getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDetail createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UserDetail getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserDetail updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * Sets createdAt before insert
     */
    @PrePersist
    public void setCreationDate() {
        this.createdAt = new Date();
    }

    /**
     * Sets updatedAt before update
     */
    @PreUpdate
    public void setChangeDate() {
        this.updatedAt = new Date();
    }

}
