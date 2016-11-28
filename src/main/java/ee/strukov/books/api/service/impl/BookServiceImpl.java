package ee.strukov.books.api.service.impl;

import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.book.Book;
import ee.strukov.books.api.model.book.OwnedBook;
import ee.strukov.books.api.repository.BookRepository;
import ee.strukov.books.api.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by strukov on 28.11.16.
 */
@Service
@Transactional
public class BookServiceImpl implements BooksService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public OwnedBook save(OwnedBook ownedBook) {
        return bookRepository.save(ownedBook);
    }
}
