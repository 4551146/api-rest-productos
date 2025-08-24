package cl.kibernum.m6actividad2.apirestproductos.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.kibernum.m6actividad2.apirestproductos.security.domain.User;

public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    Optional<User> findByEmailAndActiveTrue(String email);
}

