package pvasilev.cit.oossp.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pvasilev.cit.oossp.library.domain.Member;
import pvasilev.cit.oossp.library.rowmapper.MemberRowMapper;

import java.util.List;

/**
 * Created by Pavel on 29/08/2016.
 */
@Repository
public class MemberDaoImp implements MemberDao {
    JdbcTemplate template;
    @Autowired
    public MemberDaoImp(JdbcTemplate template) { this.template = template;}

    @Override
    public List<Member> findAll() {
        String query = "SELECT * " + "FROM member ";
        List<Member> member = template.query(query, new MemberRowMapper());
        return member;
    }

    @Override
    public Member findById(String memberId) {
        String query = "SELECT * FROM member WHERE memberId = ? ";
        Member member = template.queryForObject(query, new Object[] {memberId}, new MemberRowMapper());
        return member;
    }

    @Override
    public List<Member> findAllwithFines() {
        String query = "SELECT * FROM member WHERE fines <> 0";
        List<Member> member = template.query(query, new MemberRowMapper());
        return member;
    }

    @Override
    public void update(Member member) {
        String query = "update member set fines = ?";
        template.update(query,new Object[]{member.getFines()});
    }

}
