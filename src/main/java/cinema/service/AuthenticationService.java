package cinema.service;

import cinema.exeptions.AuthenticationExeption;
import cinema.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationExeption;

    User register(String email, String password);
}
