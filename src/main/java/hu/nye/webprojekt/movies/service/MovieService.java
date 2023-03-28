package hu.nye.webprojekt.movies.service;

import hu.nye.webprojekt.movies.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    List<MovieDTO> findAll();
}
