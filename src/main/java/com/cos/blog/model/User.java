package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;


@Entity //User 클래스가 변수들을 읽어서 mysql에 테이블이 생성된다. 
public class User {
    
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identitiy-프로젝트에서 연결된 db의 넘버링 전략을 따라간다.(오라클-시퀀스, mysql-auto_increment)
    private int id; //시퀀스, auto_incement 

    @Column(nullable = false, length= 30)
    private String username; //아이디

    @Column(nullable = false, length = 100)// 123456-> 해쉬암호화하면 길어질수있기때문에 넉넉히
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("'user'")
    private String role; //정확히는 String이아니라 enum을 쓰는게 좋다.(admin, user, manager...)권한

    @CreationTimestamp //시간이 자동입력
    private Timestamp createDate;
}
