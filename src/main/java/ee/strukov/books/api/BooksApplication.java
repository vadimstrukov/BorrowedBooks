package ee.strukov.books.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by strukov on 20.11.16.
 */
@SpringBootApplication
public class BooksApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BooksApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BooksApplication.class, args);
    }
}
