package com.yw.controller;

import com.yw.pojo.Books;
import com.yw.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller 调用 service 层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍并返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books=bookService.queryAllBook();

        model.addAttribute("list",books);
        return "allBook";

    }

    //toAddBook
    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";

    }

    //addBook
    @PostMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";

    }

    //toUpdateBook
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books books=bookService.queryBookById(id);
        model.addAttribute("books",books);
        return "updateBook";

    }

    //updateBook
    @PostMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";

    }

    //del
    @RequestMapping("/del/{bookID}")
    public String del(@PathVariable("bookID") int id, Model model){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";

    }

    @RequestMapping("/querBook")
    public String querBook(String queryBookName,Model model){
        List<Books> list=new ArrayList<>();

        Books books=bookService.querBookByName(queryBookName);
        System.err.println("querBook=>books:"+books);

        if (books ==null){
            list=bookService.queryAllBook();
            model.addAttribute("error","未查到结果");
            model.addAttribute("list",list);
            return "allBook";
        }


        list.add(books);
        System.err.println("querBook=>list:"+list);
        model.addAttribute("list",list);
        return "allBook";

    }
}
