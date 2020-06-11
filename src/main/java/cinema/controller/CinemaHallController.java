package cinema.controller;

import cinema.dto.response.CinemaHallDto;
import cinema.model.CinemaHall;
import cinema.service.CinemaHallService;
import cinema.util.maper.CinemaHallMaper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    @Autowired
    private CinemaHallService cinemaHallService;
    @Autowired
    private CinemaHallMaper cinemaHallMaper;

    @GetMapping
    public List<CinemaHallDto> getAll() {
        return cinemaHallService.getAll()
                .stream()
                .map(m -> cinemaHallMaper.transfer(m))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void create(@RequestBody CinemaHallDto cinemaHallDto) {
        CinemaHall cinemaHall = cinemaHallMaper.transfer(cinemaHallDto);
        cinemaHallService.add(cinemaHall);
    }
}
