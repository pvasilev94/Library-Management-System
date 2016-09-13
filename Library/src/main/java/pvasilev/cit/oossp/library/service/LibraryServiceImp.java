package pvasilev.cit.oossp.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import pvasilev.cit.oossp.library.dao.*;
import pvasilev.cit.oossp.library.domain.Book;
import pvasilev.cit.oossp.library.domain.Loan;
import pvasilev.cit.oossp.library.domain.Member;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibraryServiceImp implements LibraryService {

    BookDao bookDao;
    MemberDao memberDao;
    LoanDao loanDao;

    @Autowired
    public LibraryServiceImp(BookDao bookDao, MemberDao memberDao, LoanDao loanDao) {
        this.memberDao = memberDao;
        this.bookDao = bookDao;
        this.loanDao = loanDao;
    }
    @Override
    public Member getMember(String id) {
        return memberDao.findById(id);
    }

    @Override
    public List<Member> findAllMembers() {
        return memberDao.findAll();
    }

    @Override
    public List<Member> findAllMembersWithFine() {
        return memberDao.findAllwithFines();
    }

    @Override
    public List<Book> findAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookDao.findByAuthor(author);
    }

    @Override
    public List<Book> findByTitle(String title) {
        return bookDao.findByTitle(title);
    }

    @Override
    public List<Loan> findAllLoan() {
        return loanDao.findAll();
    }

    @Override
    public List<Loan> findAllLoanNotReturned() {
        return loanDao.findAllNotReturned();
    }

    @Override
    public void add(Loan loan) {
        loanDao.add(loan);
    }
}
