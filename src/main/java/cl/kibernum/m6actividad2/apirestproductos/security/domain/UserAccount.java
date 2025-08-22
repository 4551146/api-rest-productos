package cl.kibernum.m6actividad2.apirestproductos.security.domain;

// Anotaciones JPA para mapear colecciones y tablas secundarias.
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

import cl.kibernum.m6actividad2.apirestproductos.entity.User;


@Entity
@Table(name = "user_account")
@PrimaryKeyJoinColumn(name = "user_id") // Relaciona con la PK de User
public class UserAccount extends User {

    // Elimina id, password, username, active, etc. (heredados de User)
    // Solo agrega los campos adicionales

    @Column(nullable = false)
    private boolean enabled = true;

    @Column(nullable = false)
    private int tokenVersion = 0;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 30)
    private Set<Role> roles = new HashSet<>();

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public int getTokenVersion() { return tokenVersion; }
    public void setTokenVersion(int tokenVersion) { this.tokenVersion = tokenVersion; }

    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }

    /**
      * Incrementa la versión de token para invalidar refresh tokens previamente emitidos.
      * Útil para forzar cierre de sesión global del usuario (p. ej., al cambiar contraseña).
     */
    public void incrementTokenVersion() {
        this.tokenVersion++;
    }
}
