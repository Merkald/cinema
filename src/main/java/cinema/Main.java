package cinema;

import cinema.lib.Injector;
import cinema.model.Movie;
import cinema.service.MovieService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("cinema");

    public static void main(String[] args) {
        MovieService movieService = (MovieService) INJECTOR.getInstance(MovieService.class);
        //MovieService movieService = new MovieServiceImpl();
        movieService.getAll().forEach(System.out::println);

        Movie movie = new Movie();
        movie.setTitle("Title");
        movie = movieService.add(movie);
        movieService.getAll().forEach(System.out::println);
    }
}
