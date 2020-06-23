package cinema.controller;

import cinema.dto.request.MovieSessionRequestDto;
import cinema.dto.response.MovieSessionResponseDto;
import cinema.model.MovieSession;
import cinema.service.MovieSessionService;
import cinema.util.maper.MovieSessionMaper;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMaper movieSessionMaper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMaper movieSessionMaper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMaper = movieSessionMaper;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAll(
            @RequestParam(required = false) Long movieId,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return movieSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(m -> movieSessionMaper.transfer(m))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void create(@RequestBody @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd.MM.yyyy") MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = movieSessionMaper.transfer(movieSessionRequestDto);
        movieSessionService.add(movieSession);
    }
}
