package ee.strukov.books.api.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping
@RestController
public @interface BookController {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String value() default "";
}