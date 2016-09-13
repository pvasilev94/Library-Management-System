package pvasilev.cit.oossp.library.service;
import java.util.List;

import pvasilev.cit.oossp.library.domain.Member;
import pvasilev.cit.oossp.library.domain.Book;
import pvasilev.cit.oossp.library.domain.Loan;
public interface MemberService {
	/*
	 * get a Member from id
	 */
	Member get(String memberId);
	/*
	 * get Member with fine from id
	 */
	Member getFines(String memberId);
	/*
	 * get limit of books on a member
	 */
	Member getLimit(String memberId, String limit);
	/*
	 * get all the members with fines
	 */
	List<Member> getAllFines(String fine);
	/*
	 * get all the members
	 */
	List<Member> getAll();
	/*
	 * requirements for loaning a book (fines,limit)
	 */
	Member loanBook(String bookId, String loanDate, String fines, String limit);
	/*
	 * returning a book if overdue pay fine
	 */
	Member returnBook(String bookId, String returnDate, String fines);
	/*
	 * pay fines
	 */
	Member payFines(String memberId, String money);
	/*
	 * Add fine to a member
	 */
	Member addFine(String memberId, String money);
	/*
	 * Overdue Loan
	 */
	List<Loan> overDue(String memberId);
	/*
	 * View all books
	 */
	List<Book> findAll();
	/*
	 * View books from title
	 */
	List<Book> findFromTitle(String title);
	/*
	 * View a book from bookId
	 * returns Book objects
	 */
	Book getBook(String bookId);
}
