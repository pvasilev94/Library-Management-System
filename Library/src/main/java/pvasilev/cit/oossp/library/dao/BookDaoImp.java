package pvasilev.cit.oossp.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pvasilev.cit.oossp.library.domain.Book;
import pvasilev.cit.oossp.library.rowmapper.BookRowMapper;

import java.util.List;

/**
 * Created by Pavel on 22/08/2016.
 */
@Repository
public class BookDaoImp implements BookDao {

    private JdbcTemplate template;

    @Autowired
    public BookDaoImp(JdbcTemplate template) { this.template = template;}


    @Override
    public List<Book> findAll() {
        String query = "SELECT * FROM books ";
        return template.query(query, new BookRowMapper());
    }

    @Override
    public List<Book> findByTitle(String title) {
        String query = "SELECT * FROM books WHERE title = ? ";
        List<Book> book = template.query(query,new Object[] {title}, new BookRowMapper());
        return book;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        String query = "SELECT * FROM books WHERE author = ? ";
        List<Book> book = template.query(query,new Object[] {author}, new BookRowMapper());
        return book;
    }

}
