package hu.nye.webprojekt.movies;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieController {

    @RequestMapping(path = "/movies", method = RequestMethod.GET)
    public List<String> findAll() {
        return Arrays.asList("Star Wars", "Terminator");
    }
}
