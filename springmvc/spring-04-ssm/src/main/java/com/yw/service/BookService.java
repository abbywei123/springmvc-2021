package com.yw.service;

import com.yw.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    int addBook(Books book);

    int deleteBookById(int bookID);

    int updateBook(Books book);

    Books queryBookById(int bookID);

    List<Books> queryAllBook();

    Books querBookByName(String bookName);
}
