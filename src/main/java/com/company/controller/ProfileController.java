package com.company.controller;

import com.company.service.BookService;
import com.company.service.ProfileService;
import com.company.utill.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProfileController {
    @Autowired
    ProfileService profileService;
    @Autowired
    BookService bookService;
    public void start() {
        boolean b = true;
        while (b) {
            menu();
            int operation = ScannerUtil.SCANNER_NUM.nextInt();
            switch (operation) {
                case 1:
                    getBookList();
                    break;
                case 2:
                    takeBook();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
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
        System.out.println("2. Take book  ");
        System.out.println("3. Taken book");
        System.out.println("4. Return book");
        System.out.println("5. History");
        System.out.println("5. Order book");
        System.out.println("0. Log out");
    }

    private void getBookList(){
      bookService.bookList();
    }
    private void takeBook(){
        System.out.print("Enter book's id to take : ");
        String id = ScannerUtil.SCANNER_STR.nextLine();
        bookService.takeBook(id);
    }

}
