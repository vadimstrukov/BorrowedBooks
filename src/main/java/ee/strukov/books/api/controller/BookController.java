package ee.strukov.books.api.controller;

import ee.strukov.books.api.model.OwnedBookStatus;
import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.book.Book;
import ee.strukov.books.api.model.book.OwnedBook;
import ee.strukov.books.api.model.enums.BookStatus;
import ee.strukov.books.api.model.enums.ReadStatus;
import ee.strukov.books.api.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by strukov on 28.11.16.
 */
@RestController
@RequestMapping(value = "api/v1/books")
public class BookController {

    @Autowired
    BooksService booksService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OwnedBook> save(@RequestBody Book book, @AuthenticationPrincipal User user) {
        return new ResponseEntity<>(booksService.save(user, book), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OwnedBook>> getBooks(@AuthenticationPrincipal User user){
        return new ResponseEntity<>(booksService.findByUser(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<OwnedBook> delete(@RequestBody OwnedBook book) {
        booksService.delete(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/check")
    public ResponseEntity<OwnedBookStatus> ownedBookExists(@RequestParam(value = "id") String book_id, @AuthenticationPrincipal User user){
        OwnedBookStatus bookStatus;
        if(booksService.existsByBookAndUserId(book_id, user.getId()))
            bookStatus = new OwnedBookStatus(book_id, BookStatus.EXISTS);
        else
            bookStatus = new OwnedBookStatus(book_id, BookStatus.NULL);
        return new ResponseEntity<>(bookStatus, HttpStatus.OK);

    }
}


