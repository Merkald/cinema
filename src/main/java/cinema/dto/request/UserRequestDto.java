package cinema.dto.request;

import cinema.anotation.EmailConstraint;
import cinema.anotation.PasswordsValueMatch;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestDto {
    private String firstName;
    private String lastName;
    private int age;
    @NotNull
    private String login;
    @NotNull
    @PasswordsValueMatch
    private String password;
    @NotNull
    @PasswordsValueMatch
    private String repeatPassword;
    @Size(min = 4)
    @EmailConstraint
    private String email;
    private Integer phone;

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatpassword) {
        this.repeatPassword = repeatpassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
