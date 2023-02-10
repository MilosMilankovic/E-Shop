package com.eshop.services;

import com.eshop.dto.GenreDTO;

import java.util.List;

public interface GenreService {

    GenreDTO create(GenreDTO genreDto);

    void delete(Long id);
    List<GenreDTO> getAll();
//
//    BookDTO getById(long id);

}
