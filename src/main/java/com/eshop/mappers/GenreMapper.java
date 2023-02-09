package com.eshop.mappers;

import com.eshop.dto.GenreDTO;
import com.eshop.entities.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);
    public Genre toEntity(GenreDTO genreDTO);
    public GenreDTO toDto(Genre genre);

    List<GenreDTO> toDtoList(List<Genre> genres);
}
