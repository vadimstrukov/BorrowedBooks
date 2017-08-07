package ee.strukov.books.api.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.annotation.*;

import static ee.strukov.books.api.BookApiConstants.BOOK_API_URL;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(
        value = BOOK_API_URL,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
@ResponseStatus(HttpStatus.OK)
public @interface BookApiRequest {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path();
    @AliasFor(annotation = RequestMapping.class, attribute = "method")
    RequestMethod method();
}
