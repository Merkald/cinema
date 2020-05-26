package cinema;

import cinema.exeptions.AuthenticationExeption;
import cinema.lib.Injector;
import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import cinema.service.MovieSessionService;
import cinema.service.UserService;
import cinema.service.impl.AuthenticationServiceImpl;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    private static final Injector INJECTOR = Injector.getInstance("cinema");

    public static void main(String[] args) {
        UserService userService = (UserService) INJECTOR.getInstance(UserService.class);
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        String password = "password";
        String email = "email";
        int n = 3;
        for (int i = 0; i < n; i++) {
            User user = authenticationService.register(email + i, password + i);
            try {
                user = authenticationService.login(user.getEmail(), password + i);
                System.out.println(user);
            } catch (AuthenticationExeption e) {
                logger.warn("Cant login. Passwords are not equals", e);
            }
        }
        try {
            authenticationService.login(email + 1, password);
        } catch (AuthenticationExeption e) {
            logger.warn("Cant login. Passwords are not equals", e);
        }
    }

    public static void test() {
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
