package com.company.service;

import com.company.container.ComponentContainer;
import com.company.dto.Book;
import com.company.dto.StudentBook;
import com.company.dto.TakenBook;
import com.company.repository.StudentBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentBookService {

    @Autowired
    StudentBookRepository studentBookRepository;

    public void takenBooks() {
        Integer id = ComponentContainer.currentProfile.getId();
        List<TakenBook> takenBookList = studentBookRepository.getTakenBookList(id);
        int i = 1;
        for (TakenBook takenBook : takenBookList){
            System.out.println(i +") "+takenBook);
            i++;
        }
    }
}
