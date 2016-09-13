package pvasilev.cit.oossp.library.rowmapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pvasilev.cit.oossp.library.domain.Loan;
public class LoanRowMapper implements RowMapper<Loan> {

	@Override
	public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Loan loan = new Loan();

		loan.setBookId(rs.getString("bookId"));
		loan.setMemberId(rs.getString("memberId"));
		loan.setLoanDate(rs.getString("loanDate"));
		loan.setReturnDate(rs.getString("returnDate"));
		
		return loan;
	}

}
