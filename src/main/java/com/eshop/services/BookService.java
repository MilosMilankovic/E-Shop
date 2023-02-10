package com.eshop.services;


import com.eshop.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO create(BookDTO bookDTO);
    List<BookDTO> getAll();

    BookDTO getById(long id);

    void delete(Long id);

}
