package ee.strukov.books.api.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * Created by strukov on 4.01.17.
 */
@JsonSerialize
@Data
public class UserLibrary {
    private Long ownedBooks;
    private Long borrowedBooks;
    public UserLibrary(Long ownedBooks, Long borrowedBooks){
        this.borrowedBooks = borrowedBooks;
        this.ownedBooks = ownedBooks;
    }
}
