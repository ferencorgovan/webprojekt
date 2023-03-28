package hu.nye.webprojekt.movies.controller;

import hu.nye.webprojekt.movies.dto.MovieDTO;
import hu.nye.webprojekt.movies.entity.MovieEntity;
import hu.nye.webprojekt.movies.repository.MovieRepository;
import hu.nye.webprojekt.movies.service.MovieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(path = "/movies", method = RequestMethod.GET)
    public List<MovieDTO> findAll() {
        return movieService.findAll();
    }
}
