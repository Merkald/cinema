package cinema.util.maper;

import cinema.dto.request.MovieSessionRequestDto;
import cinema.dto.response.MovieSessionResponseDto;
import cinema.model.MovieSession;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMaper {
    @Autowired
    private CinemaHallMaper cinemaHallMaper;
    @Autowired
    private MovieMaper movieMaper;
    @Autowired
    private MovieService movieService;
    @Autowired
    private CinemaHallService cinemaHallService;

    public MovieSessionResponseDto transfer(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        movieSessionResponseDto.setMovieDto(movieMaper.transfer(movieSession.getMovie()));
        movieSessionResponseDto.setCinemaHallDto(cinemaHallMaper
                .transfer(movieSession.getCinemaHall()));
        return movieSessionResponseDto;
    }

    public MovieSession transfer(MovieSessionRequestDto movieSessionRequestDtoDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setShowTime(movieSessionRequestDtoDto.getShowTime());
        movieSession.setMovie(movieService
                .get(movieSessionRequestDtoDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService
                .get(movieSessionRequestDtoDto.getCinemaHallId()));
        return movieSession;
    }
}
