package cinema.dto.response;

import java.util.Objects;

public class TicketResponseDto {
    private Long id;
    private Long movieSessionId;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieSessionId() {
        return movieSessionId;
    }

    public void setMovieSessionId(Long movieSessionId) {
        this.movieSessionId = movieSessionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TicketResponseDto ticketResponseDto = (TicketResponseDto) o;
        return Objects.equals(id, ticketResponseDto.id)
                && Objects.equals(movieSessionId, ticketResponseDto.movieSessionId)
                && Objects.equals(userId, ticketResponseDto.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieSessionId, userId);
    }

    @Override
    public String toString() {
        return "TicketDto{"
                + "id=" + id
                + ", movieSessionId=" + movieSessionId
                + ", userId=" + userId
                + '}';
    }
}
