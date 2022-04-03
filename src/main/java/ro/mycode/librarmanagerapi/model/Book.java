package ro.mycode.librarmanagerapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="Book")
@Table(name="books")
public class Book implements Comparable<Book> {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    Long id;
    private String title;
    private String author;
    private String genre;
    private int year;

    @Override
    public int compareTo(Book o) {
        if(this.year>o.getYear()){
            return 1;
        }else if(this.year<o.getYear()){
            return -1;
        }
        return 0;
    }
}
