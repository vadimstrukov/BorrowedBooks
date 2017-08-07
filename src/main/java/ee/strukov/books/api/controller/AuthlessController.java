package ee.strukov.books.api.controller;

import ee.strukov.books.api.annotations.BookApi;
import ee.strukov.books.api.annotations.BookApiRequest;
import ee.strukov.books.api.model.User;
import ee.strukov.books.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by strukov on 8.12.16.
 */
@BookApi
public class AuthlessController {

    @Autowired
    private UserService userService;

    @BookApiRequest(path = "register", method = POST)
    public User register(@RequestBody User user) {
        return userService.register(user);
    }
}
