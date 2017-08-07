package ee.strukov.books.api.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

import static ee.strukov.books.api.BookApiConstants.BOOK_API_URL;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(BOOK_API_URL)
@RestController
public @interface BookApi {
    @AliasFor(annotation = RequestMapping.class, attribute = "request")
    String[] request() default {};
}
