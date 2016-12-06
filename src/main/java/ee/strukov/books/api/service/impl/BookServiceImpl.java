package ee.strukov.books.api.service.impl;

import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.book.Book;
import ee.strukov.books.api.model.book.OwnedBook;
import ee.strukov.books.api.repository.BookRepository;
import ee.strukov.books.api.repository.OwnedBookRepository;
import ee.strukov.books.api.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by strukov on 28.11.16.
 */
@Service
@Transactional
public class BookServiceImpl implements BooksService {

    @Autowired
    private OwnedBookRepository ownedBookRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public OwnedBook save(OwnedBook ownedBook) {
        Book book = bookRepository.findOne(ownedBook.getBook().getId());
        if (book != null)
            ownedBook.setBook(book);
        return ownedBookRepository.save(ownedBook);
    }

    @Override
    public List<OwnedBook> findByUser(User user) {
        return ownedBookRepository.findByUser(user);
    }

    @Override
    public void delete(OwnedBook book) {
        ownedBookRepository.delete(book);
    }

    @Override
    public boolean existsByBookAndUserId(String book_id, Long user_id) {
        return ownedBookRepository.existsByBookAndUserId(book_id, user_id);
    }

}
