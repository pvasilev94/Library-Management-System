package pvasilev.cit.oossp.library.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pvasilev.cit.oossp.library.domain.Member;

public class MemberRowMapper implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Member member = new Member();
		member.setMemberId(rs.getString("memberId"));
		member.setName(rs.getString("memberName"));
		member.setAdress(rs.getString("address"));
		member.setDOB(rs.getString("DOB"));
		member.setLimit(rs.getString("loanLimit"));
		member.setLoan_lenght(rs.getString("loanLenght"));
		member.setFines(rs.getString("fines"));
		
		return member;
	}

}
