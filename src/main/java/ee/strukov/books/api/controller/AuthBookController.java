package ee.strukov.books.api.controller;

import ee.strukov.books.api.BookApiConstants.*;
import ee.strukov.books.api.annotations.BookApiRequest;
import ee.strukov.books.api.annotations.BookController;
import ee.strukov.books.api.model.OwnedBookStatus;
import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.UserLibrary;
import ee.strukov.books.api.model.book.BorrowedBook;
import ee.strukov.books.api.model.book.OwnedBook;
import ee.strukov.books.api.model.enums.BookStatus;
import ee.strukov.books.api.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by strukov on 28.11.16.
 */
@BookController(Api.BOOKS)
public class AuthBookController {

    @Autowired
    BooksService booksService;

    @BookApiRequest(method = GET, path = "/count")
    public UserLibrary getLibraryLength(@AuthenticationPrincipal User user){
        return booksService.userLibraryLength(user);
    }

    @BookApiRequest(method = POST, path = "/borrowed")
    public BorrowedBook save(@RequestBody BorrowedBook borrowedBook){
        return booksService.save(borrowedBook);
    }

    @BookApiRequest(method = GET, path = "/borrowed")
    public List<BorrowedBook>getBorrowedBooks(@AuthenticationPrincipal User user){
        return booksService.findBorrowedBooks(user);
    }

    @BookApiRequest(method = PUT, path = "/borrowed")
    public BorrowedBook updateBorrowed(@RequestBody BorrowedBook book){
        return booksService.updateBorrowed(book);
    }

    @BookApiRequest(method = DELETE, path = "/borrowed")
    public void deleteBorrowed(@RequestParam(value = "id")Long id) {
        booksService.deleteBorrowed(id);
    }

    @BookApiRequest(method = POST, path = "/owned")
    public OwnedBook save(@RequestBody OwnedBook book, @AuthenticationPrincipal User user) {
        return booksService.save(book, user);
    }

    @BookApiRequest(method = GET, path = "/owned")
    public List<OwnedBook> getBooks(@AuthenticationPrincipal User user){
        return booksService.findOwnedBooks(user);
    }

    @BookApiRequest(method = DELETE, path = "/owned")
    public void deleteOwned(@RequestParam(value = "id")Long id) {
        booksService.deleteOwned(id);
    }

    @BookApiRequest(method = PUT, path = "/owned")
    public OwnedBook update(@RequestBody OwnedBook book){
        return booksService.updateOwned(book);
    }

    @BookApiRequest(method = GET, path= "/owned/check")
    public OwnedBookStatus ownedBookExists(@RequestParam(value = "id") String book_id, @AuthenticationPrincipal User user){
        OwnedBookStatus bookStatus = booksService.existsByBookAndUserId(book_id, user.getId()) ? new OwnedBookStatus(BookStatus.EXISTS) : new OwnedBookStatus(BookStatus.NULL);
        bookStatus.setBook_id(book_id);
        return bookStatus;
    }
}


