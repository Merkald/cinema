package cinema.util;

import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.model.Order;
import cinema.model.ShoppingCart;
import cinema.model.Ticket;
import cinema.model.User;
import cinema.model.dto.request.MovieSessionRequestDto;
import cinema.model.dto.request.UserRequestDto;
import cinema.model.dto.response.CinemaHallDto;
import cinema.model.dto.response.MovieDto;
import cinema.model.dto.response.MovieSessionResponseDto;
import cinema.model.dto.response.OrderResponseDto;
import cinema.model.dto.response.ShoppingCartResponseDto;
import cinema.model.dto.response.TicketResponseDto;
import cinema.model.dto.response.UserResponseDto;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoTransfer {
    @Autowired
    private MovieService movieService;
    @Autowired
    private CinemaHallService cinemaHallService;

    public UserResponseDto transfer(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setAge(user.getAge());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setLogin(user.getLogin());
        userResponseDto.setPhone(user.getPhone());
        userResponseDto.setUserId(user.getUserId());
        return userResponseDto;
    }

    public User transfer(UserRequestDto userRequestDto) {
        User user = new User();
        user.setAge(userRequestDto.getAge());
        user.setEmail(userRequestDto.getEmail());
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setLogin(userRequestDto.getLogin());
        user.setPhone(userRequestDto.getPhone());
        user.setPassword(userRequestDto.getPassword());
        return user;
    }

    public CinemaHallDto transfer(CinemaHall cinemaHall) {
        CinemaHallDto cinemaHallDto = new CinemaHallDto();
        cinemaHallDto.setCapacity(cinemaHall.getCapacity());
        cinemaHallDto.setDescription(cinemaHall.getDescription());
        cinemaHallDto.setId(cinemaHall.getId());
        return cinemaHallDto;
    }

    public CinemaHall transfer(CinemaHallDto cinemaHallDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallDto.getCapacity());
        cinemaHall.setDescription(cinemaHallDto.getDescription());
        cinemaHall.setId(cinemaHallDto.getId());
        return cinemaHall;
    }

    public MovieDto transfer(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setTitle(movie.getTitle());
        movieDto.setDescription(movie.getDescription());
        return movieDto;
    }

    public Movie transfer(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setDescription(movieDto.getDescription());
        return movie;
    }

    public MovieSessionResponseDto transfer(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime());
        movieSessionResponseDto.setMovieDto(transfer(movieSession.getMovie()));
        movieSessionResponseDto.setCinemaHallDto(transfer(movieSession.getCinemaHall()));
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

    public TicketResponseDto transfer(Ticket ticket) {
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        ticketResponseDto.setId(ticket.getId());
        ticketResponseDto.setUserId(ticket.getUser().getUserId());
        ticketResponseDto.setMovieSessionId(ticket.getMovieSession().getId());
        return ticketResponseDto;
    }

    public ShoppingCartResponseDto transfer(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setId(shoppingCart.getId());
        shoppingCartResponseDto.setUserResponseDto(transfer(shoppingCart.getUser()));
        shoppingCartResponseDto.setTicketResponseDtos(shoppingCart
                .getTickets()
                .stream()
                .map(this::transfer)
                .collect(Collectors.toList()));
        return shoppingCartResponseDto;
    }

    public OrderResponseDto transfer(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderDate(order.getOrderDate());
        orderResponseDto.setUserResponseDto(transfer(order.getUser()));
        orderResponseDto.setTicketResponseDtos(order
                .getTickets()
                .stream()
                .map(this::transfer)
                .collect(Collectors.toList()));
        return orderResponseDto;
    }
}
