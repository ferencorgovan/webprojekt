package hu.nye.webprojekt.movies.repository;

import hu.nye.webprojekt.movies.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

}
