package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data       //getter setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity     //orm class다 
public class Board {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private int id;

    @Column(nullable = false,length = 100)
    private String title;

    @Lob //대용량 데이터
    private String content; //섬머노트 라이브러리 사용 <html>태그가 섞여서 디자인이되어 용량이커짐.
    
    private int count; //조회수

    // Many= board, One = user  -> 한명의 유저가 여러개의 게시물을 작성할 수 있다.
    @ManyToOne(fetch = FetchType.EAGER)     //fetch = eager -> 즉시 로딩 (ManyToOne 기본전략)
    @JoinColumn(name="userId")
    private User user; //Db는 오브젝트를 저장할수 없다. FK, 자바는 오브젝트를 저장할수있다.


    //mappedby 연관관계의 주인이 아니다. (FK가 아니다.) DB에 칼럼을 만들지마세요(조인컬럼 x)
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)  // OneToMany  기본= LAZY전략. (필요할때 로딩) 여기선 즉시 로딩을 사용할거기때문에 EAGER.
    @JsonIgnoreProperties({"board"})        //무한참조 방지
    @OrderBy("id desc")
    private List<Reply> replys;      //board= 필드이름

    @CreationTimestamp
    private Timestamp createDate;
}
