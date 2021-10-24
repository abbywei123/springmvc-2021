package com.yw.dao;

import com.yw.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int addBook(Books book);

    int deleteBookById(int bookID);

    int updateBook(Books book);

    Books queryBookById(int bookID);

    List<Books> queryAllBook();

    Books querBookByName(@Param("bookName") String bookName);
}
