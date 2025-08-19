package cl.kibernum.m6actividad2.apirestproductos.controller.dto;

public class UserResponse {
    private Long id;
    private String name;
    private String lastname;
    private String rut;
    private String email;
    private String password;

    public UserResponse(Long id, String name, String lastname, String rut, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.rut = rut;
        this.email = email;
        this.password = password;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
