package ee.strukov.books.api.service;

import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.book.Book;
import ee.strukov.books.api.model.book.OwnedBook;

import java.util.List;

/**
 * Created by strukov on 28.11.16.
 */
public interface BooksService {
    OwnedBook save(User user, Book book);
    List<Book> findByUser(User user);
}
