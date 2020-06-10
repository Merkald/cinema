package cinema.controller;

import cinema.model.Movie;
import cinema.model.dto.response.MovieDto;
import cinema.service.MovieService;
import cinema.util.DtoTransfer;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private DtoTransfer dtoTransfer;

    @GetMapping
    public List<MovieDto> getAll() {
        return movieService.getAll()
                .stream()
                .map(m -> dtoTransfer.transfer(m))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void create(@RequestBody MovieDto movieDto) {
        Movie movie = dtoTransfer.transfer(movieDto);
        movieService.add(movie);
    }
}
