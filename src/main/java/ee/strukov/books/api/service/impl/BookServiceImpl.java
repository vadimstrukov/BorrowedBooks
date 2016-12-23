package ee.strukov.books.api.service.impl;

import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.book.Book;
import ee.strukov.books.api.model.book.BorrowedBook;
import ee.strukov.books.api.model.book.OwnedBook;
import ee.strukov.books.api.repository.BookRepository;
import ee.strukov.books.api.repository.BorrowedBookRepository;
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
    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    @Override
    public BorrowedBook save(BorrowedBook borrowedBook) {
        return borrowedBookRepository.save(borrowedBook);
    }

    @Override
    public OwnedBook save(OwnedBook ownedBook, User user) {
        Book book = bookRepository.findOne(ownedBook.getBook().getId());
        if (book != null)
            ownedBook.setBook(book);
        ownedBook.setUser(user);
        return ownedBookRepository.save(ownedBook);
    }

    @Override
    public OwnedBook update(OwnedBook ownedBook) {
        OwnedBook book = ownedBookRepository.findOne(ownedBook.getId());
        book.setReadStatus(ownedBook.getReadStatus());
        book.setBorrowed(ownedBook.getBorrowed());
        return ownedBookRepository.save(book);
    }

    @Override
    public List<OwnedBook> findOwnedBooks(User user) {
        return ownedBookRepository.findByUser(user);
    }

    @Override
    public List<BorrowedBook> findBorrowedBooks(User user) {
        return borrowedBookRepository.findByUser(user);
    }

    @Override
    public void deleteOwned(Long ownedBookId) {
        ownedBookRepository.delete(ownedBookId);
    }

    @Override
    public void deleteBorrowed(Long borrowedBookId) {
        borrowedBookRepository.delete(borrowedBookId);
    }


    @Override
    public boolean existsByBookAndUserId(String book_id, Long user_id) {
        return ownedBookRepository.existsByBookAndUserId(book_id, user_id);
    }

}
