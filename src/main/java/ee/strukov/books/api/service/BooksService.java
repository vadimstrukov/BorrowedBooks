package ee.strukov.books.api.service;

import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.book.Book;
import ee.strukov.books.api.model.book.BorrowedBook;
import ee.strukov.books.api.model.book.OwnedBook;

import java.util.List;

/**
 * Created by strukov on 28.11.16.
 */
public interface BooksService {
    BorrowedBook save(BorrowedBook borrowedBook);
    OwnedBook save(OwnedBook ownedBook);
    OwnedBook update(OwnedBook ownedBook);
    List<OwnedBook> findOwnedBooks(User user);
    List<BorrowedBook> findBorrowedBooks(User user);
    void delete(OwnedBook book);
    void delete(BorrowedBook borrowedBook);
    boolean existsByBookAndUserId(String book_id, Long user_id);
}
