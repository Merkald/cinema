package cinema.model;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
    @ManyToMany
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public Integer getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
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
                && firstName.equals(user.firstName)
                && lastName.equals(user.lastName)
                && login.equals(user.login)
                && email.equals(user.email)
                && Objects.equals(phone, user.phone)
                && password.equals(user.password);
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
