package com.eshop.controllers;

import com.eshop.dto.GenreDTO;
import com.eshop.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    GenreService genreService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody GenreDTO genreDto) {
        GenreDTO genreDTO = genreService.create(genreDto);
        return new ResponseEntity<>(genreDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        genreService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or isAnonymous()")
    public ResponseEntity<?> getAll(){
        List<GenreDTO> genreDTOList = genreService.getAll();
        return new ResponseEntity<>(genreDTOList, HttpStatus.OK);
    }


//    @GetMapping("/getById")
//    public ResponseEntity<?> getById(@RequestParam long id) {
//        BookDTO bookDTO = bookService.getById(id);
//        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
//    }


}
