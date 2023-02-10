package com.eshop.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class BookDTO {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String publisher;

    @NotBlank
    private String publicationDate;

    @NotBlank
    private String language;

    @NotBlank
    private String genreName;

    @NotNull
    private Integer numberOfPages;

    @NotBlank
    private String format;

    @NotNull
    private Integer isbn;

    private Double shippingWeight;
    private Double listPrice;
    private Double ourPrice;
    private boolean active;
    private String description;

    @NotNull
    private Integer inStockNumber;

    //slika
}
