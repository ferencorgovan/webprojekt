package hu.nye.webprojekt.movies.controller;

import hu.nye.webprojekt.movies.entity.MovieEntity;
import hu.nye.webprojekt.movies.repository.MovieRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle("Star Wars");
        movieRepository.save(movieEntity);
    }

    @RequestMapping(path = "/movies", method = RequestMethod.GET)
    public List<MovieEntity> findAll() {

        return movieRepository.findAll();
    }
}
