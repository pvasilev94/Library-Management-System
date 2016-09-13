package pvasilev.cit.oossp.library.rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pvasilev.cit.oossp.library.domain.Book;
public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Book book = new Book();
		
		book.setBookId(rs.getString("bookId"));
		book.setTitle(rs.getString("title"));
		book.setISBN(rs.getString("ISBN"));
		book.setAuthor(rs.getString("author"));
		book.setPublisher(rs.getString("publisher"));
		book.setEdition(rs.getString("edition"));
		book.setYearRelease(rs.getString("yearRelease"));
		
		return book;
	}
		
}
