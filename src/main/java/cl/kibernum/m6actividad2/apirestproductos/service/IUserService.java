package cl.kibernum.m6actividad2.apirestproductos.service;

import java.util.List;
import java.util.Optional;

import cl.kibernum.m6actividad2.apirestproductos.entity.User;

public interface IUserService {
    public List<User> listAllUsers();
    public User saveUser(User user);
    public Optional<User> getUserById(Long id);
    public User updatedUser(User user);
    public void deleteUserById(Long id);
}
