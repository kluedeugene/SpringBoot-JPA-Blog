package com.cos.blog.service;

import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    @Autowired // DI
    private BoardRepository boardRepository;

    @Transactional
    public void 글쓰기(Board board, User user) {  //title, content
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Board> 글목록(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board 글상세보기(int id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("글상세보기 실패: 글아이디를 찾을수 없습니다.");
                });
    }

    @Transactional
    public void 글삭제하기(int id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public void 글수정하기(int id, Board requestBoard) {
        Board  board = boardRepository.findById(id)        // 영속화
                .orElseThrow(() -> {
                    return new IllegalArgumentException("글 수정 실패: 글아이디를 찾을수 없습니다.");
                });
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        //해당 함수로 종료시 (Service가 종료될때) 트랜잭션이 종료된다.이때 더티체킹이 발생한다.
        // 왜냐하면 영속화가 되어있는 BOard의 데이터가 달라졌기 때문에 자동 업데이트.(Db 로Flush)(commit)
    }
}
