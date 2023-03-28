package hu.nye.webprojekt.movies.service;

import hu.nye.webprojekt.movies.dto.MovieDTO;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<MovieDTO> findAll();

    Optional<MovieDTO> findById(Long id);

    MovieDTO save(MovieDTO movieDTO);

    void delete(Long id);
}
