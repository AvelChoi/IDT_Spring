package com.example.springweb.member;

import java.util.List;

public interface MemberService {

    List<Member> findAll();

    Member findByUserId(String userId);

    List<Member> findByGender(boolean gender);

    void delete(String userId);

}
