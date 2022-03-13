package ro.mycode.librarmanagerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mycode.librarmanagerapi.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {


}
