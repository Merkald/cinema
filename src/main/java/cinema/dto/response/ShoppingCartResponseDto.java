package cinema.dto.response;

import java.util.List;
import java.util.Objects;

public class ShoppingCartResponseDto {
    private Long id;
    private List<TicketResponseDto> ticketResponseDtos;
    private UserResponseDto userResponseDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TicketResponseDto> getTicketResponseDtos() {
        return ticketResponseDtos;
    }

    public void setTicketResponseDtos(List<TicketResponseDto> ticketResponseDtos) {
        this.ticketResponseDtos = ticketResponseDtos;
    }

    public UserResponseDto getUserResponseDto() {
        return userResponseDto;
    }

    public void setUserResponseDto(UserResponseDto userResponseDto) {
        this.userResponseDto = userResponseDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShoppingCartResponseDto that = (ShoppingCartResponseDto) o;
        return Objects.equals(id, that.id)
                && Objects.equals(ticketResponseDtos, that.ticketResponseDtos)
                && Objects.equals(userResponseDto, that.userResponseDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketResponseDtos, userResponseDto);
    }

    @Override
    public String toString() {
        return "ShoppingCartResponseDto{"
                + "id=" + id
                + ", ticketResponseDtos=" + ticketResponseDtos
                + ", userResponseDto=" + userResponseDto
                + '}';
    }
}
