package ee.strukov.books.api.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ee.strukov.books.api.model.enums.BookStatus;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created by strukov on 5.12.16.
 */
@JsonSerialize
@Data
public class OwnedBookStatus implements Serializable {
    private String book_id;
    private BookStatus status;
    public OwnedBookStatus(BookStatus status){
        this.status = status;
    }
}
