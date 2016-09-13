package pvasilev.cit.oossp.library.service;

import pvasilev.cit.oossp.library.domain.Book;
import pvasilev.cit.oossp.library.domain.Loan;
import pvasilev.cit.oossp.library.domain.Member;

import java.util.List;

/**
 * Created by Pavel on 30/08/2016.
 */
public interface LibraryService {
        Member getMember(String id);

        List<Member> findAllMembers();

        List<Member> findAllMembersWithFine();

        List<Book> findAllBooks();

        List<Book> findByAuthor(String author);

        List<Book> findByTitle(String title);

        List<Loan> findAllLoan();

        List<Loan> findAllLoanNotReturned();

        void add(Loan loan);
}
