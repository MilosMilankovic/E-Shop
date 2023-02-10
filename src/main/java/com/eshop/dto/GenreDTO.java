package com.eshop.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GenreDTO {

    private Long id;

    @NotBlank
    private String name;
    private String description;

    //slika
}
