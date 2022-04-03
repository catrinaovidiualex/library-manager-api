package ro.mycode.librarmanagerapi.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.librarmanagerapi.model.Book;
import ro.mycode.librarmanagerapi.repository.BookRepository;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/books")
public class BookController {


    private BookRepository bookRepository;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //endpoint pentru afisarea tuturor cartilor
    @GetMapping
    public ResponseEntity<List<Book>> getAll(){

        return  new ResponseEntity<>(bookRepository.findAll(), HttpStatus.ACCEPTED);
    }

    //endpoint care ne ajuta sa apelam functia yearBooks
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

    //endpoint pentru adaugare carte noua
    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        this.bookRepository.save(book);
        return new ResponseEntity<>("taREEEE",HttpStatus.ACCEPTED);
    }

    //endpoint pentru afisare carte dupa id;
    @GetMapping("/{id}")
    public  ResponseEntity<Book>getBook(@PathVariable Long id){
        Book book=bookRepository.findById(id).get();
        return  new ResponseEntity<>(book,HttpStatus.OK);
    }

    //endpoint pentru update carti
    @PutMapping("/update")
    public ResponseEntity<String> updateBooks(@RequestBody Book bk){

         Book book=this.bookRepository.findById(bk.getId()).get(); //cautam cartea in functie de id
         //setam atributele cartii cu valorile din bd;
         book.setTitle(bk.getTitle());
         book.setGenre(bk.getGenre());
         book.setAuthor(bk.getAuthor());
         book.setYear(bk.getYear());
         this.bookRepository.save(book);

         return  new ResponseEntity<>("cartea a fost modificata",HttpStatus.ACCEPTED);

        }

        // endpoint pentru delete carti
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooks(@PathVariable Long id){
        this.bookRepository.deleteById(id);

        return new ResponseEntity<>("s-a sters",HttpStatus.ACCEPTED);
        }

        //endpoint pentru sortare carti in fct de an
     @GetMapping("/sortBooks")
    public ResponseEntity<List<Book>> sortBooks(){

        List <Book> myBooksList= this.bookRepository.findAll();
         Collections.sort(myBooksList);

         return new ResponseEntity<>(myBooksList, HttpStatus.ACCEPTED);

     }

     //endpoint pentru filtrare carti dupa titlu
     @GetMapping("/filterBooksByTitle/{titleBook}")
    public ResponseEntity<List<Book>> filterBooksByTitle(@PathVariable String titleBook){
        return new ResponseEntity<>(bookRepository.filterByTitle(titleBook),HttpStatus.ACCEPTED);

     }

     //endpoint pentru cea mai noua carte
    @GetMapping("/newestBook")
    public ResponseEntity<Book> showNewestBook(){


        Book book=this.bookRepository.findAll().stream().max((a,b)->a.compareTo(b)).get();

        return new ResponseEntity<>(book,HttpStatus.ACCEPTED);
    }



}
