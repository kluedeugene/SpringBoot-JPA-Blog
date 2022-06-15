package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data       //getter setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity     
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private int id;
    
    @Column(nullable = false,length = 200)
    private String content;

    @ManyToOne  // Many= 댓글, One = Board  -> 하나의 게시글에 여러개의 댓글
    @JoinColumn(name="boardId")
    private Board board;

    @ManyToOne  // Many= 댓글, One = User  -> 하나의 유저가 여러개의 댓글
    @JoinColumn(name="userId")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;
}
