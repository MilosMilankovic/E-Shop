package com.eshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyGroup;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String author;
    private String publisher;
    private String publicationDate;
    private String language;
    private int numberOfPages;

    @Enumerated(EnumType.STRING)
    private Format format;
    private int isbn;
    private double shippingWeight;
    private double listPrice;
    private double ourPrice;
    private boolean active=true;
    private String description;
    private int inStockNumber;
    private int quantity;

    //slika

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @LazyGroup("genre")
    private Genre genre;


    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private List<BookToCartItem> bookToCartItems;

}
