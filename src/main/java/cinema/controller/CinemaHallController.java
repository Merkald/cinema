package cinema.controller;

import cinema.model.CinemaHall;
import cinema.model.dto.response.CinemaHallDto;
import cinema.service.CinemaHallService;
import cinema.util.DtoTransfer;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinemahalls")
public class CinemaHallController {
    @Autowired
    private CinemaHallService cinemaHallService;
    @Autowired
    private DtoTransfer dtoTransfer;

    @GetMapping
    public List<CinemaHallDto> getAll() {
        return cinemaHallService.getAll()
                .stream()
                .map(m -> dtoTransfer.transfer(m))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void create(@RequestBody CinemaHallDto cinemaHallDto) {
        CinemaHall cinemaHall = dtoTransfer.transfer(cinemaHallDto);
        cinemaHallService.add(cinemaHall);
    }
}
