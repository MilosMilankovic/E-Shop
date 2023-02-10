package com.eshop.controllers;

import com.eshop.dto.BookDTO;
import com.eshop.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/create")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or isAnonymous()")
    public ResponseEntity<?> create(@RequestBody BookDTO bookDTO) {
        bookService.create(bookDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or isAnonymous()")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAll")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or isAnonymous()")
    public ResponseEntity<?> getAll(){
        List<BookDTO> bookDTOList = bookService.getAll();
        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }

    @GetMapping("/getById")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or isAnonymous()")
    public ResponseEntity<?> getById(@RequestParam long id) {
        BookDTO bookDTO = bookService.getById(id);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }


}