package pvasilev.cit.oossp.library.dao;

import pvasilev.cit.oossp.library.domain.Member;

import java.util.List;

/**
 * Created by Pavel on 22/08/2016.
 */
public interface MemberDao {
    public List<Member> findAll();

    public Member findById(String id);

    public List<Member> findAllwithFines();

    void update(Member member);
}
