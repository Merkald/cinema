package cinema.dto.request;

import java.time.LocalDateTime;
import java.util.Objects;

public class MovieSessionRequestDto {
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MovieSessionRequestDto that = (MovieSessionRequestDto) o;
        return Objects.equals(id, that.id)
                && Objects.equals(movieId, that.movieId)
                && Objects.equals(cinemaHallId, that.cinemaHallId)
                && Objects.equals(showTime, that.showTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieId, cinemaHallId, showTime);
    }

    @Override
    public String toString() {
        return "MovieSessionRequestDto{"
                + "id=" + id
                + ", movieId=" + movieId
                + ", cinemaHallId=" + cinemaHallId
                + ", showTime=" + showTime
                + '}';
    }
}
