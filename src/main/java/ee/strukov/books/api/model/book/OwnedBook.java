package ee.strukov.books.api.model.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.book.Book;
import ee.strukov.books.api.model.enums.ReadStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by strukov on 28.11.16.
 */
@Entity
@Table(name = "OWNEDBOOK")
@Data
public class OwnedBook implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @Enumerated(EnumType.STRING)
    private ReadStatus readStatus;
    private Date date_added;
    @OneToOne(cascade=CascadeType.MERGE)
    private User user;
    @OneToOne(cascade=CascadeType.ALL)
    private Book book;

}
