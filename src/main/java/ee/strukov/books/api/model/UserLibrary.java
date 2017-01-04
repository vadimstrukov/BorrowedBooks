package ee.strukov.books.api.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by strukov on 4.01.17.
 */
@JsonSerialize
@Data
public class UserLibrary implements Serializable{
    private Long ownedBooksLength;
    private Long borrowedBooksLength;
    public UserLibrary(Long ownedBooksLength, Long borrowedBooksLength){
        this.borrowedBooksLength = borrowedBooksLength;
        this.ownedBooksLength = ownedBooksLength;
    }
}
