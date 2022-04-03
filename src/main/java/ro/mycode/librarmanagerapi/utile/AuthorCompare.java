package ro.mycode.librarmanagerapi.utile;

import ro.mycode.librarmanagerapi.model.Book;

import java.util.Comparator;

public class AuthorCompare implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}
