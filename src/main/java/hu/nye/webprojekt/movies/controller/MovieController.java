package hu.nye.webprojekt.movies.controller;

import hu.nye.webprojekt.movies.dto.MovieDTO;
import hu.nye.webprojekt.movies.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movieDTO) {
        MovieDTO savedMovie = movieService.save(movieDTO);

        return ResponseEntity.status(201).body(savedMovie);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
