package ro.mycode.librarmanagerapi.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.librarmanagerapi.model.Book;
import ro.mycode.librarmanagerapi.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/books")
public class BookController {


    private BookRepository bookRepository;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping
    public ResponseEntity<List<Book>> getAll(){

        return  new ResponseEntity<>(bookRepository.findAll(), HttpStatus.ACCEPTED);
    }
    //acesta este un endpoint care ne ajuta sa apelam functia yearBooks
    @GetMapping("/year")
    public ResponseEntity<List<Book>> getBooksByYear() {

        List<Book> books = bookRepository.findAll();

        ArrayList<Book> filtrate = new ArrayList<>();


        for (Book b :books) {


             if(b.getYear()>=1003){
                 filtrate.add(b);
             }

        }

        return  new ResponseEntity<>(filtrate, HttpStatus.ACCEPTED);


    }
    //endpoint pentru afisare carti dupa ID-uri
    @GetMapping("/ids")
    public ResponseEntity<List<Book>> getBooksByIDs(){
        List<Book> bks= bookRepository.findAll();
        ArrayList<Book> booksByIDs = new ArrayList<>();

        for(Book bk: bks){
            if(bk.getId()>=45){
                booksByIDs.add(bk);
            }
        }

        return new ResponseEntity<>(booksByIDs,HttpStatus.ACCEPTED);

    }

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        this.bookRepository.save(book);
        return new ResponseEntity<>("taREEEE",HttpStatus.ACCEPTED);
    }

}
