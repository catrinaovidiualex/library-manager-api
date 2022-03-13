package ro.mycode.librarmanagerapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="Book")
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    Long id;
    private String title;
    private String author;
    private String genre;
    private int year;

}
