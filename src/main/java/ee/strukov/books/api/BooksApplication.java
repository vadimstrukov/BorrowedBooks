package ee.strukov.books.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * Created by strukov on 20.11.16.
 */
@SpringBootApplication
public class BooksApplication  {
    public static void main(String[] args) {
        SpringApplication.run(BooksApplication.class, args);
    }
}
