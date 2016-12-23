package ee.strukov.books.api.model.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.book.Book;
import ee.strukov.books.api.model.enums.ReadStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by strukov on 28.11.16.
 */
@Entity
@Table(name = "OWNEDBOOK")
@Data
@EqualsAndHashCode(of="id")
public class OwnedBook implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ReadStatus readStatus;
    private Date date_added;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "book_id")
    private Book book;
    private Boolean borrowed;

}
