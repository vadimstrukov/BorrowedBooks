package ee.strukov.books.api.controller;

import ee.strukov.books.api.model.OwnedBookStatus;
import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.book.BorrowedBook;
import ee.strukov.books.api.model.book.OwnedBook;
import ee.strukov.books.api.model.enums.BookStatus;
import ee.strukov.books.api.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by strukov on 28.11.16.
 */
@RestController
@RequestMapping(value = "/api/v1/books")
public class AuthBookController {

    @Autowired
    BooksService booksService;


    @RequestMapping(method = RequestMethod.POST, path = "/borrowed")
    public ResponseEntity<BorrowedBook> save(@RequestBody BorrowedBook borrowedBook){
        return new ResponseEntity<>(booksService.save(borrowedBook), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/borrowed")
    public ResponseEntity<List<BorrowedBook>> getBorrowedBooks(@AuthenticationPrincipal User user){
        return new ResponseEntity<>(booksService.findBorrowedBooks(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/borrowed")
    public ResponseEntity<BorrowedBook> deleteBorrowed(@RequestParam(value = "id")Long id) {
        booksService.deleteBorrowed(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/owned")
    public ResponseEntity<OwnedBook> save(@RequestBody OwnedBook book, @AuthenticationPrincipal User user) {
        return new ResponseEntity<>(booksService.save(book, user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/owned")
    public ResponseEntity<List<OwnedBook>> getBooks(@AuthenticationPrincipal User user){
        return new ResponseEntity<>(booksService.findOwnedBooks(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/owned")
    public ResponseEntity<OwnedBook> deleteOwned(@RequestParam(value = "id")Long id) {
        booksService.deleteOwned(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/owned")
    public ResponseEntity<OwnedBook> update(@RequestBody OwnedBook book){
        return new ResponseEntity<>(booksService.update(book), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/owned/check")
    public ResponseEntity<OwnedBookStatus> ownedBookExists(@RequestParam(value = "id") String book_id, @AuthenticationPrincipal User user){
        OwnedBookStatus bookStatus;
        if(booksService.existsByBookAndUserId(book_id, user.getId()))
            bookStatus = new OwnedBookStatus(book_id, BookStatus.EXISTS);
        else
            bookStatus = new OwnedBookStatus(book_id, BookStatus.NULL);
        return new ResponseEntity<>(bookStatus, HttpStatus.OK);

    }
}


