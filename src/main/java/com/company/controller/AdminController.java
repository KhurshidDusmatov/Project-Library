package com.company.controller;

import com.company.dto.Book;
import com.company.service.BookService;
import com.company.utill.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    @Autowired
    private BookService bookService;
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

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

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
        System.out.println("9. Change Terminal Status");
        System.out.println("0. Log out");
    }
    private void bookList(){
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

}
