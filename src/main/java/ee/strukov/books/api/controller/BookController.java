package ee.strukov.books.api.controller;

import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.book.Book;
import ee.strukov.books.api.model.book.OwnedBook;
import ee.strukov.books.api.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by strukov on 28.11.16.
 */
@RestController
@RequestMapping(value = "api/v1")
public class BookController {

    @Autowired
    BooksService booksService;

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity<OwnedBook> save(@RequestBody Book book, @AuthenticationPrincipal User user) {
        OwnedBook ownedBook = new OwnedBook();
        ownedBook.setBook(book);
        ownedBook.setUser(user);
        return new ResponseEntity<>(booksService.save(ownedBook), HttpStatus.OK);
    }
}


