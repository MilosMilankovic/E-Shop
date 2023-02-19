package com.eshop.repositories;

import com.eshop.entities.Genre;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    Genre findByName(String name);
    void deleteById(Long id);

//    @Query("from Genre g join fetch g.book b")
    Optional<Genre> findById(Long id);


//    @EntityGraph(value = Genre.WITH_BOOK_GRAPH, type = EntityGraph.EntityGraphType.FETCH)
//    @Query("from Genre g join fetch g.book b")
    List<Genre> findAll();

}
