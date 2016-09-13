package pvasilev.cit.oossp.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pvasilev.cit.oossp.library.domain.Loan;
import pvasilev.cit.oossp.library.rowmapper.LoanRowMapper;

import java.util.List;

/**
 * Created by Pavel on 31/08/2016.
 */
@Repository
public class LoanDaoImp implements LoanDao {

    JdbcTemplate template;

    @Autowired
    public LoanDaoImp(JdbcTemplate template) { this.template = template;}

    @Override
    public void add(Loan loan) {
        String query = "insert into loan (bookId,memberId, loanDate) values (?, ?, ?)";
        template.update(query, new Object[] {loan.getBookId(), loan.getMemberId(), loan.getLoanDate()});
        System.out.println("Loan has been added");
    }
    @Override
    public List<Loan> findAll() {
        String query = "SELECT * FROM loan";
        List<Loan> loan = template.query(query, new LoanRowMapper());
        return loan;
    }
    @Override
    public List<Loan> findAllNotReturned() {
        String query = "SELECT * FROM loan WHERE returnDate IS NULL ";
        List<Loan> loan = template.query(query, new LoanRowMapper());
        return loan;
    }
}
