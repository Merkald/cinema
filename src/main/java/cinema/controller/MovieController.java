package cinema.controller;

import cinema.dto.response.MovieDto;
import cinema.model.Movie;
import cinema.service.MovieService;
import cinema.util.maper.MovieMaper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMaper movieMaper;

    public MovieController(MovieService movieService, MovieMaper movieMaper) {
        this.movieService = movieService;
        this.movieMaper = movieMaper;
    }

    @GetMapping
    public List<MovieDto> getAll() {
        return movieService.getAll()
                .stream()
                .map(m -> movieMaper.transfer(m))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void create(@RequestBody MovieDto movieDto) {
        Movie movie = movieMaper.transfer(movieDto);
        movieService.add(movie);
    }
}
