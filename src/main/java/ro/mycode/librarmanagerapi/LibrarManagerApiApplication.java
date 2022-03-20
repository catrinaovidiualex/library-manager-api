package ro.mycode.librarmanagerapi;


import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.librarmanagerapi.model.Book;
import ro.mycode.librarmanagerapi.repository.BookRepository;

@SpringBootApplication
public class LibrarManagerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrarManagerApiApplication.class, args);
    }



    @Bean
    CommandLineRunner commandLineRunner (BookRepository bookRepository){
        return arg ->{
//            Faker faker = new Faker();
//
//            for(int i=1;i<=100;i++){
//                Book b= new Book();
//
//                b.setTitle(faker.book().title());
//                b.setAuthor(faker.book().author());
//                b.setGenre(faker.book().genre());
//                b.setYear(1232);
//
//               bookRepository.save(b);
//           }
        };
    }





}
