package cinema.model;

import java.util.Objects;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private int age;
    @Column(unique = true)
    private String login;
    @Column(unique = true)
    private String email;
    private Integer phone;
    private String password;
    private byte[] salt;

    public byte[] getSalt() {
        return salt;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public Optional<Integer> getPhone() {
        return Optional.ofNullable(phone);
    }

    public String getPassword() {
        return password;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User salt(byte[] salt) {
        this.salt = salt;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return age == user.getAge()
                && userId.equals(user.getUserId())
                && firstName.equals(user.getFirstName())
                && lastName.equals(user.getLastName())
                && login.equals(user.getLogin())
                && email.equals(user.getEmail())
                && Objects.equals(phone, user.getPhone())
                && password.equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, age,
                login, email, phone, password);
    }

    @Override
    public String toString() {
        return "User{"
                + "userId=" + userId
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", age=" + age
                + ", login='" + login + '\''
                + ", email='" + email + '\''
                + ", phone=" + phone
                + ", password='" + password + '\''
                + '}' + "\n";
    }
}
