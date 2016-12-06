package ee.strukov.books.api.service;

import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.book.Book;
import ee.strukov.books.api.model.book.OwnedBook;

import java.util.List;

/**
 * Created by strukov on 28.11.16.
 */
public interface BooksService {
    OwnedBook save(OwnedBook ownedBook);
    List<OwnedBook> findByUser(User user);
    void delete(OwnedBook book);
    boolean existsByBookAndUserId(String book_id, Long user_id);
}
