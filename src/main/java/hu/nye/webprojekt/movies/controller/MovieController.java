package hu.nye.webprojekt.movies.controller;

import hu.nye.webprojekt.movies.dto.MovieDTO;
import hu.nye.webprojekt.movies.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<MovieDTO> findAll() {
        return movieService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
        Optional<MovieDTO> movieDTO = movieService.findById(id);

        ResponseEntity<MovieDTO> response;

        if (movieDTO.isPresent()) {
            response = ResponseEntity.ok(movieDTO.get());
            // response = ResponseEntity.status(200).body(movieDTO.get());
        } else {
            response = ResponseEntity.notFound().build();
            // response = ResponseEntity.status(404).build();
        }
        return response;
    }
}
