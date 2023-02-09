package com.eshop.controllers;

import com.eshop.dto.GenreDTO;
import com.eshop.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genre")
public class GenreController {

    @Autowired
    GenreService genreService;

    @PostMapping("/create")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or isAnonymous()")
    public ResponseEntity<?> create(@RequestBody GenreDTO genreDto) {
        genreService.create(genreDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or isAnonymous()")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        genreService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @GetMapping("/getAll")
//    public ResponseEntity<?> getAll(){
//        List<BookDTO> bookDTOList = bookService.getAll();
//        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
//    }
//
//    @GetMapping("/getById")
//    public ResponseEntity<?> getById(@RequestParam long id) {
//        BookDTO bookDTO = bookService.getById(id);
//        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
//    }


}
