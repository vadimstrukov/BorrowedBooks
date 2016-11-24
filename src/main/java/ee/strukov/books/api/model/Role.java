package ee.strukov.books.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by strukov on 20.11.16.
 */
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority, Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String role;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    @Getter @Setter
    private Set<User> users = new HashSet<>();

    @Override
    public String getAuthority() {
        return role;
    }
}
