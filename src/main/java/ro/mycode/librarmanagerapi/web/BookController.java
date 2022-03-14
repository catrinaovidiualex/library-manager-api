package ro.mycode.librarmanagerapi.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.mycode.librarmanagerapi.model.Book;
import ro.mycode.librarmanagerapi.repository.BookRepository;

import java.util.List;

@RestController
@CrossOrigin
public class BookController {


    private BookRepository bookRepository;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping("/alex")
    public ResponseEntity<List<Book>> getAll(){

        return  new ResponseEntity<>(bookRepository.findAll(), HttpStatus.ACCEPTED);
    }

}
