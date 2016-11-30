package ee.strukov.books.api.service.impl;

import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.book.Book;
import ee.strukov.books.api.model.book.OwnedBook;
import ee.strukov.books.api.model.enums.ReadStatus;
import ee.strukov.books.api.repository.BookRepository;
import ee.strukov.books.api.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by strukov on 28.11.16.
 */
@Service
@Transactional
public class BookServiceImpl implements BooksService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public OwnedBook save(User user, Book book) {
        OwnedBook ownedBook = new OwnedBook();
        ownedBook.setReadStatus(ReadStatus.UNREAD);
        ownedBook.setUser(user);
        ownedBook.setBook(book);
        ownedBook.setDate_added(new Date());
        return bookRepository.save(ownedBook);
    }

    @Override
    public List<OwnedBook> findByUser(User user) {
        return bookRepository.findByUser(user);
    }
}
