package cinema;

import cinema.exeptions.AuthenticationExeption;
import cinema.lib.Injector;
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
import cinema.service.impl.AuthenticationServiceImpl;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    private static final Injector INJECTOR = Injector.getInstance("cinema");
    private static UserService userService = (UserService) INJECTOR
            .getInstance(UserService.class);
    private static MovieService movieService = (MovieService) INJECTOR
            .getInstance(MovieService.class);
    private static MovieSessionService movieSessionService = (MovieSessionService) INJECTOR
            .getInstance(MovieSessionService.class);
    private static CinemaHallService cinemaHallService = (CinemaHallService) INJECTOR
            .getInstance(CinemaHallService.class);
    private static ShoppingCartService shoppingCartService = (ShoppingCartService) INJECTOR
            .getInstance(ShoppingCartService.class);
    private static OrderService orderService = (OrderService) INJECTOR
            .getInstance(OrderService.class);

    public static void main(String[] args) {
        testUser();
        test();
    }

    public static void testUser() {
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        String password = "password";
        String email = "email";
        int n = 4;
        for (int i = 0; i < n; i++) {
            User user = authenticationService.register(email + i, password + i);
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
            shoppingCartService.registerNewShoppingCart(user);
            shoppingCartService.addSession(movieSession, user);
            System.out.println(shoppingCartService.getByUser(user));
            Order order = orderService
                    .completeOrder(shoppingCartService.getByUser(user).getTickets(),user);
            System.out.println("Orders" + orderService.getOrderHistory(user));
        }
    }
}
