package ee.strukov.books.api.service;

import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.book.Book;
import ee.strukov.books.api.model.book.OwnedBook;

/**
 * Created by strukov on 28.11.16.
 */
public interface BooksService {
    OwnedBook save(OwnedBook ownedBook);
}
