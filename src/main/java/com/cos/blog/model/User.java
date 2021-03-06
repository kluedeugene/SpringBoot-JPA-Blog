package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data       //getter setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//ORM -> JAVA(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity //User 클래스가 변수들을 읽어서 mysql에 테이블이 생성된다. 
//@DynamicInsert  //insert 시에 null인 필드를 제외시켜준다
public class User {
    
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identitiy-프로젝트에서 연결된 db의 넘버링 전략을 따라간다.(오라클-시퀀스, mysql-auto_increment)
    private int id; //시퀀스, auto_incement 

    @Column(nullable = false, length= 30, unique= true)
    private String username; //아이디

    @Column(nullable = false, length = 100)// 123456-> 해쉬암호화하면 길어질수있기때문에 넉넉히
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

   // @ColumnDefault("'user'")
   //private String role; //정확히는 String이아니라 enum을 쓰는게 좋다.(admin, user, manager...)권한
   
   //DB는 RoleType이란게 없기때문에 string 명시
   @Enumerated(EnumType.STRING)
     private RoleType role; 

    @CreationTimestamp //시간이 자동입력
    private Timestamp createDate;
}
