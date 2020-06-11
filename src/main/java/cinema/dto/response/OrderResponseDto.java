package cinema.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class OrderResponseDto {
    private Long id;
    private List<TicketResponseDto> ticketResponseDtos;
    private LocalDateTime orderDate;
    private UserResponseDto userResponseDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
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
        OrderResponseDto that = (OrderResponseDto) o;
        return Objects.equals(id, that.id)
                && Objects.equals(ticketResponseDtos, that.ticketResponseDtos)
                && Objects.equals(orderDate, that.orderDate)
                && Objects.equals(userResponseDto, that.userResponseDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketResponseDtos, orderDate, userResponseDto);
    }

    @Override
    public String toString() {
        return "OrderResponseDto{"
                + "id=" + id
                + ", ticketResponseDtos=" + ticketResponseDtos
                + ", orderDate=" + orderDate
                + ", userResponseDto=" + userResponseDto
                + '}';
    }
}
