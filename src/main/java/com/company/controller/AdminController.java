package com.company.controller;

import com.company.dto.Book;
import com.company.dto.Profile;
import com.company.dto.StudentBook;
import com.company.service.BookService;
import com.company.service.ProfileService;
import com.company.service.StudentBookService;
import com.company.utill.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private StudentBookService studentBookService;

    public void start() {
        boolean b = true;
        while (b) {
            menu();
            int operation = ScannerUtil.SCANNER_NUM.nextInt();
            switch (operation) {
                case 1:
                    bookList();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    profileList();
                    break;
                case 5:
                    addProfile();
                    break;
                case 6:
                    deleteProfile();
                    break;
                case 7:
                    getTakenBooks();
                    break;
                case 8:
                    showHistory();
                    break;
                case 0:
                    b = false;
                    break;
                default:
                    b = false;
                    System.out.println("Wrong operation number");
            }
        }
    }

    public void menu() {
        System.out.println("1. Book List");
        System.out.println("2. Add Book ");
        System.out.println("3. Delete book");
        System.out.println("4. Student List");
        System.out.println("5. Add Student");
        System.out.println("6. Delete Student");
        System.out.println("7. Student Taken Book");
        System.out.println("8. Book Taken History");
        System.out.println("0. Log out");
    }
    private void bookList() {
        bookService.bookList();
    }
    private void addBook() {
        System.out.print("Enter book's title : ");
        String title = ScannerUtil.SCANNER_STR.nextLine();
        System.out.print("Enter book's author : ");
        String author = ScannerUtil.SCANNER_STR.nextLine();
        System.out.print("Enter book's published year : ");
        Integer year = ScannerUtil.SCANNER_NUM.nextInt();
        System.out.print("Enter book's amount : ");
        Integer amount = ScannerUtil.SCANNER_NUM.nextInt();

        Book book = new Book(title, author, year, amount, true);
        bookService.addBook(book);
    }
    private void deleteBook() {
        System.out.print("Enter book's id to delete : ");
        String id = ScannerUtil.SCANNER_STR.nextLine();
        bookService.deleteBook(id);
    }
    //Student
    private void profileList() {
        profileService.getProfileList();
    }
    private void addProfile() {
        System.out.print("Enter student name : ");
        String name = ScannerUtil.SCANNER_STR.nextLine();
        System.out.print("Enter student surname : ");
        String surname = ScannerUtil.SCANNER_STR.nextLine();
        System.out.print("Enter student's phone number : ");
        String phone = ScannerUtil.SCANNER_STR.nextLine();

        Profile profile = new Profile(name, surname, phone);
        profileService.addProfile(profile);
    }
    private void deleteProfile(){
        System.out.print("Enter book's id to delete : ");
        String id = ScannerUtil.SCANNER_STR.nextLine();
        profileService.deleteProfile(id);
    }
    private void getTakenBooks() {
        studentBookService.getTakenBooks();
    }
    private void showHistory() {
       studentBookService.showHistory();
    }
}
