package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class User extends Model {

    @Id
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @MapKey(name = "id")
    public Map<Long, Role> roles = new HashMap<Long, Role>();

    public static Finder<Long, User> find =
            new Finder(Long.class, User.class);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Long, Role> getRoles() {
        return roles;
    }

    public void setRoles(Map<Long, Role> roles) {
        this.roles = roles;
    }
}
