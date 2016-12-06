package ee.strukov.books.api.repository;

import ee.strukov.books.api.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by strukov on 6.12.16.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
