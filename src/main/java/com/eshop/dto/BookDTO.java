package com.eshop.dto;

import com.eshop.entities.Genre;
import lombok.Data;

@Data
public class BookDTO {

    private Long id;

    private String title;
    private String author;
    private String publisher;
    private String publicationDate;
    private String language;
    private String genreName;
    private int numberOfPages;
    private String format;
    private int isbn;
    private double shippingWeight;
    private double listPrice;
    private double ourPrice;
    private boolean active;
    private String description;
    private int inStockNumber;

    //slika
}
