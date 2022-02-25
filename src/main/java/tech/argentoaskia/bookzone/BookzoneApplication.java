package tech.argentoaskia.bookzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.util.ClassUtils;

@SpringBootApplication
@ServletComponentScan
public class BookzoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookzoneApplication.class, args);
    }

}
