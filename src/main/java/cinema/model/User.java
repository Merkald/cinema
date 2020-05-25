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

    public User() {
    }

    public User(String firstName, String lastName,
                int age, String login, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String lastName,
                int age, String login, String email, String password, byte[] salt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.login = login;
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
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

    public Optional<Integer> getPhone() {
        return Optional.ofNullable(phone);
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User salt(byte[] salt) {
        this.salt = salt;
        return this;
    }

    public User userId(Long userId) {
        this.userId = userId;
        return this;
    }

    public User firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User age(int age) {
        this.age = age;
        return this;
    }

    public User login(String login) {
        this.login = login;
        return this;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public User phone(Integer phone) {
        this.phone = phone;
        return this;
    }

    public User password(String password) {
        this.password = password;
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
        return getAge() == user.getAge()
                && getUserId().equals(user.getUserId())
                && getFirstName().equals(user.getFirstName())
                && getLastName().equals(user.getLastName())
                && getLogin().equals(user.getLogin())
                && getEmail().equals(user.getEmail())
                && Objects.equals(getPhone(), user.getPhone())
                && getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFirstName(), getLastName(), getAge(),
                getLogin(), getEmail(), getPhone(), getPassword());
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
