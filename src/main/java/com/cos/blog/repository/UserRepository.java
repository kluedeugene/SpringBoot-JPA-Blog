package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

//jsp 의 DAO 역할.  
//자동으로 bean 등록이 된다. 
//@Repository 어노테이션 생략 가능. 
public interface UserRepository extends JpaRepository<User, Integer> { //해당 jpaRepository는 User테이블을 관리한다. 그 테이블의 pk는 int다.
    
}