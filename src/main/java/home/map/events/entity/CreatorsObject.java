package home.map.events.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by greg on 14.07.15.
 */

@Entity
public abstract class CreatorsObject extends BaseEntity {
    @Column
    private UserDetail createdBy;
    @OneToMany
    private Collection <UserDetail> usersTagged = new HashSet<UserDetail>();
    public CreatorsObject(UserDetail createdBy){
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
