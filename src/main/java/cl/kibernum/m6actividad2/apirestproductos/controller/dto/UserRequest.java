package cl.kibernum.m6actividad2.apirestproductos.controller.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {
    @NotBlank
    @Size(max = 50)
    private String name;
    @NotBlank
    @Size(max = 50)
    private String lastname;
    @NotBlank
    @Size(max = 50)
    private String rut;
    @NotBlank
    @Email
    @Size(max = 50)
    private String email;
    @Size(max = 50)
    private String password;
    @NotBlank

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public String getRut() { return rut; }
    public void setRut(String rut) {this.rut = rut; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) {this.password = password; }
}
