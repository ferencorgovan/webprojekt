package hu.nye.webprojekt.movies.controller;

import hu.nye.webprojekt.movies.exception.MovieNotFoundException;
import hu.nye.webprojekt.movies.exception.MovieValidationException;
import hu.nye.webprojekt.movies.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = MovieController.class)
public class MovieControllerAdvice {

    @ExceptionHandler(value = MovieNotFoundException.class)
    public ResponseEntity<Void> handleMovieNotFoundException() {
        return ResponseEntity.status(404).build();
    }

    @ExceptionHandler(value = MovieValidationException.class)
    public ResponseEntity<ErrorResponse> handleMovieValidationException(MovieValidationException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorList());
        return ResponseEntity.status(400).body(errorResponse);
    }
}
