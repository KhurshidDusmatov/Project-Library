package com.company.service;

import com.company.container.ComponentContainer;
import com.company.dto.Book;
import com.company.dto.Profile;
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
        for (Book book : bookList) {
            if (book.getVisible()){
                System.out.println(book);
            }
        }
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
        if (book.getPublishYear() > LocalDate.now().getYear() || 0 > book.getPublishYear()){
            System.out.println("Book's publish year invalid");
            return;
        }
        if (book.getAmount()<0){
            System.out.println("Book's amount invalid");
            return;
        }
        int n = bookRepository.addBook(book);
        if (n==1){
            System.out.println("Book successfully added ! ");
        }else {
            System.out.println("Book not added ( ");
        }
    }

    public void deleteBook(String id) {
        if(!id.matches("\\d+")){
            System.out.println("Id is invalid");
            return;
        }
        int n = bookRepository.deleteBook(id);
        if (n==1){
            System.out.println("Book successfully deleted");
        }else{
            System.out.println("Book not deleted");
        }
    }

    public void takeBook(String id) {
        if(!id.matches("\\d+")){
            System.out.println("Id is invalid");
            return;
        }
        Book book = bookRepository.getBookById(id);
        if (!book.getVisible() || book.getAmount()<=0){
            System.out.println("Book not found");
            return;
        }
        Profile profile = ComponentContainer.currentProfile;
        int n = bookRepository.takeBook(profile, book);
        if (n==1){
            System.out.println("Have a nice read ");
        }else {
            System.out.println("Error ( ");
        }
    }
}
