package hu.nye.webprojekt.movies;

import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

public class MovieEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String tagline;

    private double voteAverage;

    private int voteCount;

    private Date releaseDate;

    private String posterPath;

    private String overview;

    private int budget;

    private int revenue;

    @ElementCollection
    private Set<@NotBlank String> genres;

    private Integer runtime;
}
