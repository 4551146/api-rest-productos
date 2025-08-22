package cl.kibernum.m6actividad2.apirestproductos.security.dto;

import jakarta.validation.constraints.NotBlank;

public class RegisterRequest {

    // Nombre de usuario a registrar. Obligatorio.
    @NotBlank
    private String username;

    // Contraseña en texto plano (se almacenará cifrada). Obligatoria.
    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    @NotBlank
    private String rut;

    @NotBlank
    private String email;

    // Getters y setters estándar requeridos para la deserialización JSON.
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Campos adicionales para el registro completo del usuario.
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

}
