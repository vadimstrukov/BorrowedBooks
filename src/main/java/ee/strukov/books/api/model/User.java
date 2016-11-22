package ee.strukov.books.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by strukov on 20.11.16.
 */
@Entity
@Table(name = "user")
@EqualsAndHashCode(of = "id")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String fullname;
    @Getter @Setter
    private String email;
    @Getter @Setter
    @Column(name = "password")
    private String pass;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "userrole", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    @Getter @Setter
    private Set<Role> roles = new HashSet<>();

    public User(){}

    public User(User user) {
        super();
        this.id = user.getId();
        this.fullname = user.getFullname();
        this.email = user.getEmail();
        this.pass = user.getPass();
        this.roles = user.getRoles();
    }
}
