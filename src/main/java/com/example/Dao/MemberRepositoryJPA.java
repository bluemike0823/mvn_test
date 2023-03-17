package com.example.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.Model.MemberAccountJPA;

public interface MemberRepositoryJPA extends JpaRepository<MemberAccountJPA, Long>{
    
    List<MemberAccountJPA> findAll();

    List<MemberAccountJPA> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO member.memberaccountjpa VALUES (:id, :email, :password, :address, :cellphone, 'JPA');", nativeQuery = true)
    public int addMemberProcess(
        int id, String email, String password, String address, String cellphone
        // @Param("email") String email,
        // @Param("password") String password,
        // @Param("address") String address,
        // @Param("cellphone") String cellphone
    );

}