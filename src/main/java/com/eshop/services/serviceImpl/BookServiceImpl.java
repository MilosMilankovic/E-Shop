package com.eshop.services.serviceImpl;

import com.eshop.dto.BookDTO;
import com.eshop.entities.Book;
import com.eshop.entities.Genre;
import com.eshop.mappers.BookMapper;
import com.eshop.repositories.BookRepository;
import com.eshop.repositories.GenreRepository;
import com.eshop.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    GenreRepository genreRepository;

    @Override
    public BookDTO create(BookDTO bookDTO) {

        Genre genre = genreRepository.findByName(bookDTO.getGenreName());

        Book book = BookMapper.INSTANCE.dtoToEntity(bookDTO);
        book.setGenre(genre);

        Book savedBook = bookRepository.save(book);
        return BookMapper.INSTANCE.entityToDto(savedBook);
    }

    @Override
    public List<BookDTO> getAll() {
        List<Book> bookList = bookRepository.findAll();
        return BookMapper.INSTANCE.bookListToBookDtoList(bookList);
    }

    @Override
    public BookDTO getById(long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            return BookMapper.INSTANCE.entityToDto(bookOptional.get());
        }

        return null;
    }

    @Transactional
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }


}
