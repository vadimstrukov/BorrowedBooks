package ee.strukov.books.api.controller;

import ee.strukov.books.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by strukov on 20.11.16.
 */
@RestController
@RequestMapping(value = "/v1/user")
public class AuthUserController {


    @Autowired
    private DefaultTokenServices defaultTokenServices;

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public ResponseEntity<User> getLoggedInUser(@AuthenticationPrincipal User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity<String> logout(HttpServletRequest request) throws InvalidClientException {
        defaultTokenServices.revokeToken(request.getHeader("Authorization").replace("Bearer", "").trim());
        return new ResponseEntity<>("Successfully logged out", HttpStatus.OK);
    }

}
