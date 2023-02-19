package com.eshop.services.serviceImpl;

import com.eshop.dto.GenreDTO;
import com.eshop.entities.Genre;
import com.eshop.mappers.GenreMapper;
import com.eshop.repositories.GenreRepository;
import com.eshop.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreRepository genreRepository;

    public GenreDTO create(GenreDTO genreDTO) {
        Genre genre = GenreMapper.INSTANCE.toEntity(genreDTO);
        Genre savedGenre = genreRepository.save(genre);
        return GenreMapper.INSTANCE.toDto(savedGenre);
    }

    public void delete(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public List<GenreDTO> getAll() {
        return GenreMapper.INSTANCE.toDtoList(genreRepository.findAll());
    }

    //    @Override
//    public List<BookDTO> getAll() {
//        List<Book> bookList = bookRepository.findAll();
//        return BookMapper.INSTANCE.bookListToBookDtoList(bookList);
//    }
//
//    @Override
//    public BookDTO getById(long id) {
//        Optional<Book> bookOptional = bookRepository.findById(id);
//        if (bookOptional.isPresent()) {
//            return BookMapper.INSTANCE.entityToDto(bookOptional.get());
//        }
//
//        return null;
//    }



}
