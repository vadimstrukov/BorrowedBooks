package ee.strukov.books.api;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping("/api/v1/")
public @interface BookApi {
    @AliasFor(annotation = RequestMapping.class, attribute = "request")
    String request() default "";
}
