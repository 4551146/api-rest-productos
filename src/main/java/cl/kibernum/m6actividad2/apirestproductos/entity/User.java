package cl.kibernum.m6actividad2.apirestproductos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED) // Herencia JPA
public class User  {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="name", nullable = false, length = 50)
  private String name;
  @Column(name="lastname", nullable = false, length = 50)
  private String lastname;
  @Column(name="rut", nullable = false, length = 50)
  private String rut;
  @Column(name="email", nullable = false, length = 50, unique = true)
  private String email;
  @Column(name="password", nullable = false, length = 60) // BCrypt puede ser más largo
  private String password;
  @Column(name = "active", nullable = false)
  private boolean active;
  @Column(name="username", nullable = false, length = 50, unique = true)
  private String username;
  public User(){
    
  }

  public User(String username, String name, String lastname, String rut, String email, String password) {
    this.username = username;
    this.name = name;
    this.lastname = lastname;
    this.rut = rut;
    this.email = email;
    this.password = password; 
    this.active = true;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getRut() {
     return rut;
  }

  public void setRut(String rut) {
     this.rut = rut;   
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
     return password;
}

 public void setPassword(String password) {
    this.password = password;
 }
  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String toString() {
    return "Usuario{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            ", rut='" + rut + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", active='" + active + '\'' +
            ", username='" + username + '\'' +
            '}';
  }
}
