package cinema.util.maper;

import cinema.dto.request.UserRequestDto;
import cinema.dto.response.UserResponseDto;
import cinema.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMaper {

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
}
