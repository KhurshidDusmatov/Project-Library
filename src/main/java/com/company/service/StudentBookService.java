package com.company.service;

import com.company.container.ComponentContainer;
import com.company.dto.Book;
import com.company.dto.Profile;
import com.company.dto.StudentBook;
import com.company.dto.TakenBook;
import com.company.repository.BookRepository;
import com.company.repository.StudentBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentBookService {

    @Autowired
    StudentBookRepository studentBookRepository;

    @Autowired
    BookRepository bookRepository;

    public void takenBooks() {
        Integer id = ComponentContainer.currentProfile.getId();
        List<TakenBook> takenBookList = studentBookRepository.getTakenBookList(id);
        for (TakenBook takenBook : takenBookList){
            if (takenBook.getStatus().equals("TAKEN")){
                System.out.println(takenBook);
            }
        }
    }

    public void returnBook(String id) {
        if(!id.matches("\\d+")){
            System.out.println("Id is invalid");
            return;
        }
        Integer studentId = ComponentContainer.currentProfile.getId();
        int n = studentBookRepository.returnBook(id, studentId);
        if (n==1){
            System.out.println("Thank you ");
        }else {
            System.out.println("Error ( ");
        }
    }

    public void getTakenBooks() {
        List<StudentBook> books = studentBookRepository.getAllStudentBooks();
        if (Objects.equals(books, null)) {
            System.out.println("History not found ");
            return;
        }
        for (StudentBook book : books) {
            if (book.getStatus().equals("TAKEN")) {
                System.out.println(book);
            }
        }
        for (StudentBook book : books) {
            if (book.getStatus().equals("TAKEN")) {
                System.out.println(book);
            }
        }
    }

    public void showHistory() {
        List<StudentBook> books = studentBookRepository.getAllStudentBooks();
        if (Objects.equals(books, null)) {
            System.out.println("History not found ");
            return;
        }
        books.forEach(System.out::println);
    }

    public void takeBook(String id) {
        Integer studentId = ComponentContainer.currentProfile.getId();
        int n = studentBookRepository.countStudentBook(studentId);
        if (n==5){
            System.out.println("You have not opportunity to take book");
            return;
        }
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
         n = bookRepository.takeBook(profile, book);
        if (n==1){
            System.out.println("Have a nice read ");
        }else {
            System.out.println("Error ( ");
        }
    }
}
