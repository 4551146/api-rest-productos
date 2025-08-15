package cl.kibernum.m6actividad2.apirestproductos.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;

import cl.kibernum.m6actividad2.apirestproductos.entity.User;
import cl.kibernum.m6actividad2.apirestproductos.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;


@Controller
public class UserController {

    private final IUserService service;

    public UserController(IUserService service){
        this.service = service;
    }
    
    @GetMapping({"/users", "/"})
    public String listarUsuarios(Model model) {
        model.addAttribute("users", service.listarAllUsers());
        return "users";
    }

    @GetMapping("/users/new")
    public String createUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create-user";
  }

  @GetMapping("/users/edit/{id}")
  public String showFormEditUser(@PathVariable Long id, Model model) {
    Optional<User> optionalUser = service.getUserById(id);
    if (!optionalUser.isPresent()) {
      throw new StudentNotFoundException("No se encontró un usuario con id: " + id);
    }
    User userExists = optionalUser.get();
    model.addAttribute("user", userExists);
    return "edit_user";
  }

  @PostMapping("/users/{id}")
  public String updatedUser(@PathVariable Long id, @ModelAttribute("user") User user, Model model ) {
    Optional<User> optionalUser = service.getUserById(id);
    System.out.println(optionalUser.isPresent());
    if (!optionalUser.isPresent()) {
      throw new StudentNotFoundException("No se encontró un usuario con id: " + id);
    }
    User userExists = optionalUser.get();
    
    userExists.setId(id);
    userExists.setName(user.getName());
    userExists.setLastname(user.getLastname());
    userExists.setRut(user.getRut());
    userExists.setEmail(user.getEmail());
    userExists.setPassword(user.getPassword());
    //userExists.setActive(user.getActive());

    service.updatedUser(userExists);
    return "redirect:/users";
  }

  @GetMapping("/users-delete/{id}")
  public String eliminarUsuario(@PathVariable Long id) {
    service.deleteUserById(id);
    return "redirect:/users";
  }


}

class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {
    super(message);
  }
}
