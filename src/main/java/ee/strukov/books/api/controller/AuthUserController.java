package ee.strukov.books.api.controller;

import ee.strukov.books.api.annotations.BookController;
import ee.strukov.books.api.annotations.BookApiRequest;
import ee.strukov.books.api.model.User;
import ee.strukov.books.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

import static ee.strukov.books.api.BookApiConstants.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by strukov on 20.11.16.
 */
@BookController(Api.USER)
public class AuthUserController {


    @Autowired
    private DefaultTokenServices defaultTokenServices;

    @Autowired
    private UserService userService;

    @BookApiRequest(path = "/register", method = POST)
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @BookApiRequest(path = "/me", method = GET)
    public User getLoggedInUser(@AuthenticationPrincipal User user) {
        return user;
    }

    @BookApiRequest(path = "/logout", method = GET)
    public String logout(HttpServletRequest request) throws InvalidClientException {
        defaultTokenServices.revokeToken(request.getHeader("Authorization").replace("Bearer", "").trim());
        return "Successfully logged out";
    }

}
