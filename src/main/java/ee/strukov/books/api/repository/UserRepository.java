package ee.strukov.books.api.repository;

import ee.strukov.books.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by strukov on 20.11.16.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
