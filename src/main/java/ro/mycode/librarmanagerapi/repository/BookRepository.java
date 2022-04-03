package ro.mycode.librarmanagerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.mycode.librarmanagerapi.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    //@ Query se folosetse atunci cand dorim sa afisam info speciale din bd
    @Query(value = "select * from books b where b.title like %:titleBk%",nativeQuery = true)
    List<Book> filterByTitle(@Param("titleBk") String titleBk);



}
