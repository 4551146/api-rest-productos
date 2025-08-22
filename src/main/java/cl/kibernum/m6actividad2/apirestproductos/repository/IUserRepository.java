package cl.kibernum.m6actividad2.apirestproductos.repository;

import org.springframework.data.repository.CrudRepository;
import cl.kibernum.m6actividad2.apirestproductos.entity.User;

public interface IUserRepository extends CrudRepository<User, Long> {
    User findByEmailAndActiveTrue(String email);
}
