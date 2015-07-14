package home.map.events.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by greg on 14.07.15.
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Ancestry extends BaseEntity {
    private UserDetail createdBy;
    @ElementCollection
    private Collection <UserDetail> usersTagged = new HashSet<UserDetail>();
    public Ancestry(UserDetail createdBy){
        super();
        this.createdBy = createdBy;
        usersTagged.add(createdBy);
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

    public void setUsersTagged(Collection<UserDetail> usersTagged) {
        this.usersTagged = usersTagged;
    }
}
