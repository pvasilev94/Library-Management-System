package pvasilev.cit.oossp.library.dao;

import pvasilev.cit.oossp.library.domain.Book;

import java.util.List;

/**
 * Created by Pavel on 22/08/2016.
 */
public interface BookDao {

    public List<Book> findAll();

    public List<Book> findByTitle(String title);

    public List<Book> findByAuthor(String author);

}
