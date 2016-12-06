package ee.strukov.books.api.repository;

import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.book.Book;
import ee.strukov.books.api.model.book.OwnedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by strukov on 28.11.16.
 */
@Repository
public interface OwnedBookRepository extends JpaRepository<OwnedBook, Long> {
    List<OwnedBook> findByUser(User user);
    @Query("SELECT CASE WHEN COUNT(o) > 0 THEN true ELSE false END " +
            "FROM OwnedBook o WHERE o.book.id = :book_id AND o.user.id = :user_id")
    boolean existsByBookAndUserId(@Param("book_id") String book_id, @Param("user_id") Long user_id);
}
