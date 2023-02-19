package com.eshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.OneToMany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "GENRES")

//@NamedEntityGraph(
//        name = "Genre.book",
//        attributeNodes =  {
//                @NamedAttributeNode("book")
//        }
//)
public class Genre {


    public static final String WITH_BOOK_GRAPH = "Genre.book";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY) //za @OneToMany hibernate tretira kao LAZy, ne vraca ti tu kolekciju iz baze
    private Set<Book> book = new HashSet<>();

    private String name;
    private String description;


}
