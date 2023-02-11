package com.eshop.controllers;

import com.eshop.dto.BookDTO;
import com.eshop.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody BookDTO bookDTO) {
        BookDTO bookDto = bookService.create(bookDTO);
        return new ResponseEntity<>(bookDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or isAnonymous()")
    public ResponseEntity<?> getAll(){
        List<BookDTO> bookDTOList = bookService.getAll();
        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }

    @GetMapping("/getById")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or isAnonymous()")
    public ResponseEntity<?> getById(@RequestParam long id) {
        BookDTO bookDTO = bookService.getById(id);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }


}
