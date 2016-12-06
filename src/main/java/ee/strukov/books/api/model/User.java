package ee.strukov.books.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ee.strukov.books.api.model.book.OwnedBook;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by strukov on 20.11.16.
 */
@Entity
@Table(name = "user")
@EqualsAndHashCode(of = "id")
@ToString(exclude="ownedBooks")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    @Column(nullable = false)
    private String fullname;
    @Getter @Setter
    @Column(unique = true, nullable = false)
    private String email;
    @Getter @Setter
    @Column(name = "password", nullable = false)
    private String pass;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "userrole", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    @Getter @Setter
    private Set<Role> roles = new HashSet<>();
    @Getter @Setter
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<OwnedBook> ownedBooks = new ArrayList<>();

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
