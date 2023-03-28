package hu.nye.webprojekt.movies;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @RequestMapping(path = "/movies", method = RequestMethod.GET)
    public List<String> findAll() {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle("Star Wars");
        movieRepository.save(movieEntity);

        return Arrays.asList("Star Wars", "Terminator");
    }
}
