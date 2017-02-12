package ee.strukov.books.api.repository;

import ee.strukov.books.api.model.User;
import ee.strukov.books.api.model.book.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by strukov on 12.12.16.
 */
@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
    @Query("SELECT b  FROM BorrowedBook b WHERE b.ownedBook.user = :user")
    List<BorrowedBook> findByUser(@Param("user")User user);

    @Query("SELECT COUNT(b) FROM BorrowedBook b WHERE b.ownedBook.user = :user")
    Long countByUser(@Param("user")User user);
}
