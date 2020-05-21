package cinema;

import cinema.lib.Injector;
import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import cinema.service.MovieSessionService;
import java.time.LocalDateTime;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("cinema");

    public static void main(String[] args) {
        MovieService movieService = (MovieService) INJECTOR.getInstance(MovieService.class);
        MovieSessionService movieSessionService = (MovieSessionService) INJECTOR
                .getInstance(MovieSessionService.class);
        CinemaHallService cinemaHallService = (CinemaHallService) INJECTOR
                .getInstance(CinemaHallService.class);
        int n = 4;
        for (int i = 1; i < n; i++) {
            int k = i;
            Movie movie = new Movie();
            movie.setTitle("Title" + k);
            movie = movieService.add(movie);
            CinemaHall cinemaHall = new CinemaHall();
            cinemaHall.setCapacity(100 * (k));
            cinemaHallService.add(cinemaHall);
            MovieSession movieSession = new MovieSession();
            movieSession.setCinemaHall(cinemaHall);
            movieSession.setMovie(movie);
            LocalDateTime localDateTime = LocalDateTime.of(k, k, k, k, k);
            movieSession.setShowTime(localDateTime);
            movieSessionService.add(movieSession);
            k = 3;
            System.out.println(movieSessionService
                    .findAvailableSessions(movie.getId(), LocalDateTime.of(k, k, k, k, k)));
        }
    }

}
