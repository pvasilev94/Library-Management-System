package pvasilev.cit.oossp.library.dao;

import pvasilev.cit.oossp.library.domain.Loan;

import java.util.List;

/**
 * Created by Pavel on 22/08/2016.
 */
public interface LoanDao {
    public void add(Loan loan);

    public List<Loan> findAll();

    public List<Loan> findAllNotReturned();

}
