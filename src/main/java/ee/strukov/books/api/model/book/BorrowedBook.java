package ee.strukov.books.api.model.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by strukov on 8.12.16.
 */
@Entity
@Table(name = "BORROWEDBOOK")
@Data
@EqualsAndHashCode(of="id")
public class BorrowedBook implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.MERGE)
    private OwnedBook ownedBook;
    private Date borrowDate;
    private Date returnDate;
    private String borrowDescription;
}
