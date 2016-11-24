package ee.strukov.books.api.service;

import ee.strukov.books.api.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by strukov on 24.11.16.
 */
public interface UserService extends UserDetailsService {
    User register(User user);
}
