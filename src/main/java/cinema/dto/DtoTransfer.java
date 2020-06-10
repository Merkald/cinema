package cinema.dto;

import cinema.dto.classes.UserDto;
import cinema.model.User;

public class DtoTransfer {
    public static UserDto transfer(User user) {
        UserDto userDto = new UserDto();
        userDto.setAge(user.getAge());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setLogin(user.getLogin());
        userDto.setPhone(user.getPhone());
        userDto.setUserId(user.getUserId());
        return userDto;
    }

    public static User transfer(UserDto userDto) {
        User user = new User();
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setLogin(userDto.getLogin());
        user.setPhone(userDto.getPhone());
        user.setUserId(userDto.getUserId());
        return user;
    }

}
