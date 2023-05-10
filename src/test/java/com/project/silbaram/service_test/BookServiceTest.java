package com.project.silbaram.service_test;

import com.project.silbaram.dto.BookDTO;
import com.project.silbaram.service.BookServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Log4j2
public class BookServiceTest {

    @Autowired
    private BookServiceImpl bookService;

    @Test
    public void addBookTest() {
        BookDTO bookDTO = BookDTO.builder()
                .name("test")
                .writer("test...")
                .publisher("test")
                .price(1000)
                .synopsis("test~~")
                .pages(100)
                .isbnNum("100")
                .category(1L)
                .fileSize("30KB")
                .language(1)
                .voiceLength("korea")
                .bookUrl("123test")
                .build();
        log.info(bookDTO);
        bookService.insertBook(bookDTO);
    }

    @Test
    public void updateBookTest() {
        // given
        Long bookId = 2001L; // 기존에 등록되어 있는 책의 id
        String updatedName = "updated book name"; // 업데이트할 새로운 책 이름
        BookDTO bookDTO = BookDTO.builder()
                .bkid(bookId)
                .name(updatedName)
                .writer("test writer")
                .publisher("test publisher")
                .price(10000)
                .synopsis("test synopsis")
                .pages(200)
                .isbnNum("9788937434220")
                .category(1L)
                .fileSize("30MB")
                .language(1)
                .voiceLength("test length")
                .bookUrl("test url")
                .build();

        // when
        bookService.updateBook(bookDTO);
    }

    @Test
    public void testGetList() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setName("책 제목");
        bookDTO.setWriter("작가명");

        bookService.getBookList().forEach(log::info);

    }

    @Test
    public void testGetBookById() {
        // 존재하는 bkid로 BookDTO 가져오기
        Long bkid = 2004L;
        BookDTO bookDTO = bookService.getBookById(bkid);
        log.info(bookDTO);

        assertEquals(bkid, bookDTO.getBkid());
    }

    @Test
    public void testDeleteBook() {
        Long bookId = 2003L;
        bookService.deleteBookById(bookId);
    }
}
