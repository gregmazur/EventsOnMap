package home.map.events.entity;

/**
 * Created by greg on 13.07.15.
 */
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    private Date modifiedAt;
    @ManyToOne
    private UserDetail createdBy;
    @OneToMany
    private Collection<UserDetail> usersTagged = new HashSet<UserDetail>();

    public BaseEntity() {
        createdAt = new Date();
    }

    public UserDetail getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDetail createdBy) {
        this.createdBy = createdBy;
    }

    public Collection<UserDetail> getUsersTagged() {
        return usersTagged;
    }

    @Column
    @Temporal(TemporalType.DATE)
    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setUsersTagged(Collection<UserDetail> usersTagged) {
        this.usersTagged = usersTagged;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

}
