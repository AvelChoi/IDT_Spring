package com.example.springbook;

import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class BookServiceImpl implements BookService {

    public ArrayList<Book> books = new ArrayList<>();

    public BookServiceImpl() {
        {
            // 책 목록
            books.add(new Book(1, "spring", "장정우", "IT", 10000, "book1.jpg", "http://www.kyobobook.co.kr/product/detailViewKor.laf?barcode=9791158393083"));
            books.add(new Book(2, "java", "남궁성", "IT", 20000, "book2.jpg", "http://www.kyobobook.co.kr/product/detailViewKor.laf?barcode=9788994492032"));
            books.add(new Book(3, "python", "박응용", "IT", 20000, "book3.jpg", "http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791163030911&orderClick=LAG&Kc="));
        }
    }


    @Override
    public ArrayList<Book> selectAll() {
        return books;
    }

    @Override
    public ArrayList<Book> selectByCategory(String category) {
        ArrayList<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getCategory().equals(category)) {
                result.add(book);
            }
        }

        return result;
    }

    @Override
    public ArrayList<Book> selectByKeyword(String keyword) {
        // keyword가 title에 포함되어 있거나 author에 포함되어 있을 경우
        ArrayList<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().contains(keyword) || book.getAuthor().contains(keyword)) {
                result.add(book);
            }
        }

        return result;
    }

    @Override
    public Book selectOne(int bookId) {

        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }

        return null;
    }

    @Override
    public void delete(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                books.remove(book);
            }
        }

    }

    @Override
    public void addComment(int bookId, String comment) {
        Book book = selectOne(bookId);

        if (book.getComments() == null) {

        }

        book.getComments().add(comment);
    }


}
