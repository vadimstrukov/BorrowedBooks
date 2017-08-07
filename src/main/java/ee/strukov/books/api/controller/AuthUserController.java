package ee.strukov.books.api.controller;

import ee.strukov.books.api.annotations.BookApi;
import ee.strukov.books.api.annotations.BookApiRequest;
import ee.strukov.books.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by strukov on 20.11.16.
 */
@BookApi(request = "user")
public class AuthUserController {


    @Autowired
    private DefaultTokenServices defaultTokenServices;

    @BookApiRequest(path = "me", method = GET)
    public User getLoggedInUser(@AuthenticationPrincipal User user) {
        return user;
    }

    @BookApiRequest(path = "logout", method = GET)
    public String logout(HttpServletRequest request) throws InvalidClientException {
        defaultTokenServices.revokeToken(request.getHeader("Authorization").replace("Bearer", "").trim());
        return "Successfully logged out";
    }

}
