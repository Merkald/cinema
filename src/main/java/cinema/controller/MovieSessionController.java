package cinema.controller;

import cinema.model.MovieSession;
import cinema.model.dto.request.MovieSessionRequestDto;
import cinema.model.dto.response.MovieSessionResponseDto;
import cinema.service.MovieSessionService;
import cinema.util.DtoTransfer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moviesessions")
public class MovieSessionController {
    @Autowired
    private MovieSessionService movieSessionService;
    @Autowired
    private DtoTransfer dtoTransfer;

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAll(Long movieId, LocalDateTime date) {
        return movieSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(m -> dtoTransfer.transfer(m))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void create(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = dtoTransfer.transfer(movieSessionRequestDto);
        movieSessionService.add(movieSession);
    }
}
