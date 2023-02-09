package com.eshop.mappers;

import com.eshop.dto.BookDTO;
import com.eshop.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    public Book dtoToEntity(BookDTO bookDTO);
    public BookDTO entityToDto(Book book);

    List<BookDTO> bookListToBookDtoList(List<Book> bookList);
}
