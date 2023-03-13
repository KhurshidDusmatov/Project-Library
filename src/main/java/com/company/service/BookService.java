package com.company.service;

import com.company.dto.Book;
import com.company.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void bookList(){
        List<Book> bookList = bookRepository.getBookList();
        if (bookList==null){
            System.out.println("Books not found");
            return;
        }
        bookList.forEach(System.out::println);
    }

    public void addBook(Book book){
        int length = book.getTitle().trim().length();
        if (length==0){
            System.out.println("Book's name invalid");
            return;
        }
        length = book.getAuthor().trim().length();
        if (length==0){
            System.out.println("Author's name invalid");
            return;
        }
        if (book.getPublishYear() > LocalDate.now().getYear() && 0 > book.getPublishYear()){
            System.out.println("Book's publish year invalid");
            return;
        }
        if (book.getAmount()<0){
            System.out.println("Book's amount invalid");
            return;
        }

        boolean isAdded = bookRepository.addBook(book);
        if (isAdded){
            System.out.println("Book successfully added ! ");
        }else {
            System.out.println("Book not added ( ");
        }


    }
}
