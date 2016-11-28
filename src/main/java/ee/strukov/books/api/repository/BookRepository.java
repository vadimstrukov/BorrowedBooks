package ee.strukov.books.api.repository;

import ee.strukov.books.api.model.book.Book;
import ee.strukov.books.api.model.book.OwnedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by strukov on 28.11.16.
 */
@Repository
public interface BookRepository extends JpaRepository<OwnedBook, Long> {

}
