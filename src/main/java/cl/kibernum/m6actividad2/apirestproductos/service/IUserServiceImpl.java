package cl.kibernum.m6actividad2.apirestproductos.service;

import org.springframework.stereotype.Service;


import cl.kibernum.m6actividad2.apirestproductos.security.domain.User;
import  cl.kibernum.m6actividad2.apirestproductos.security.repository.IUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IUserServiceImpl implements IUserService{
    private final IUserRepository repository;
  
    public IUserServiceImpl(IUserRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public List<User> listAllUsers() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User updatedUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmailAndActiveTrue(String email) {
        return repository.findByEmailAndActiveTrue(email);
    }
}
