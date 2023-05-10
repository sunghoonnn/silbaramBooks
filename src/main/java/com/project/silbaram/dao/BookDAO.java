package com.project.silbaram.dao;

import com.project.silbaram.dto.BookDTO;
import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.vo.BookVO;

import java.util.List;

public interface BookDAO {
    void insertBook(BookVO bookVO);
    void updateBook(BookVO bookVO);
    int deleteBookById(Long bkid);
    List<BookVO> getBookList();
    BookVO getBookById(Long bkid);
}