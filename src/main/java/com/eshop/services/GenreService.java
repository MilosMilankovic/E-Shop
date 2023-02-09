package com.eshop.services;

import com.eshop.dto.GenreDTO;

import java.util.List;

public interface GenreService {

    void create(GenreDTO genreDto);

    void delete(Long id);
//    List<BookDTO> getAll();
//
//    BookDTO getById(long id);

}
