package pvasilev.cit.oossp.library.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {
	@NotNull
	@Size(min = 2, max = 2)
	private String bookId;
	@NotNull
	private String title;
	@NotNull
	private String ISBN;

	private String author;
	@NotNull
	private String publisher;
	@NotNull
	private String edition;
	@NotNull
	private String yearRelease;
	private boolean status;
	
	public Book() {
		
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getYearRelease() {
		return yearRelease;
	}

	public void setYearRelease(String yearRelease) {
		this.yearRelease = yearRelease;
	}

	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
