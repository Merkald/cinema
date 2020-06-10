package cinema;

import cinema.config.AppConfig;
import cinema.exeptions.AuthenticationExeption;
import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.model.Order;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import cinema.service.MovieSessionService;
import cinema.service.OrderService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    private static AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);
    private static UserService userService = context.getBean(UserService.class);
    private static MovieService movieService = context.getBean(MovieService.class);
    private static MovieSessionService movieSessionService = context
            .getBean(MovieSessionService.class);
    private static CinemaHallService cinemaHallService = context.getBean(CinemaHallService.class);
    private static ShoppingCartService shoppingCartService = context
            .getBean(ShoppingCartService.class);
    private static OrderService orderService = context.getBean(OrderService.class);
    private static AuthenticationService authenticationService = context
            .getBean(AuthenticationService.class);

    public static void main(String[] args) {
        testUser();
        test();
    }

    public static void testUser() {
        String password = "password";
        String email = "email";
        int grdxhgcv = email.length();
        int n = 4;
        for (int i = 0; i < n; i++) {
            User user = new User();
            user.setPassword(password + i);
            user.setEmail(email + i);
            user = authenticationService.register(user);
            try {
                user = authenticationService.login(user.getEmail(), password + i);
                System.out.println(user);
            } catch (AuthenticationExeption e) {
                logger.warn("Cant login. Passwords are not equals", e);
            }
        }
    }

    public static void test() {
        int n = 4;
        String password = "password";
        String email = "email";
        for (int i = 1; i < n; i++) {
            int k = i;
            Movie movie = new Movie();
            movie.setTitle("Title" + k);
            movie.setDescription("desc" + k);
            movie = movieService.add(movie);
            CinemaHall cinemaHall = new CinemaHall();
            cinemaHall.setCapacity(100 * (k));
            cinemaHallService.add(cinemaHall);
            MovieSession movieSession = new MovieSession();
            movieSession.setCinemaHall(cinemaHall);
            movieSession.setMovie(movie);
            LocalDateTime localDateTime = LocalDateTime.of(k, k, k, k, k);
            movieSession.setShowTime(localDateTime);
            movieSession = movieSessionService.add(movieSession);
            System.out.println(movieSessionService
                    .findAvailableSessions(movie.getId(), LocalDateTime.of(k, k, k, k, k)));
            User user = userService.findByEmail(email + i);
            shoppingCartService.addSession(movieSession, user);
            System.out.println(shoppingCartService.getByUser(user));
            Order order = orderService
                    .completeOrder(user);
            System.out.println("Orders" + orderService.getOrderHistory(user));
        }
    }
}
