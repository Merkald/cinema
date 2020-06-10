package cinema.dto.classes;

import java.util.Objects;

public class UserDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private int age;
    private String login;
    private String email;
    private Integer phone;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDto userDto = (UserDto) o;
        return age == userDto.age
                && Objects.equals(userId, userDto.userId)
                && Objects.equals(firstName, userDto.firstName)
                && Objects.equals(lastName, userDto.lastName)
                && Objects.equals(login, userDto.login)
                && Objects.equals(email, userDto.email)
                && Objects.equals(phone, userDto.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, age, login, email, phone);
    }

    @Override
    public String toString() {
        return "UserDto{"
                + "userId=" + userId
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", age=" + age
                + ", login='" + login + '\''
                + ", email='" + email + '\''
                + ", phone=" + phone
                + '}';
    }
}
