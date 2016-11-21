package ee.strukov.books.api.controller;

import ee.strukov.books.api.model.User;
import ee.strukov.books.api.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by strukov on 20.11.16.
 */
@RestController
@RequestMapping(value = "api/v1")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public ResponseEntity<User> getLoggedInUser(@AuthenticationPrincipal User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @RequestMapping(value = "/users", method = RequestMethod.POST)
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
//    }
}
