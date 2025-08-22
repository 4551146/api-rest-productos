package cl.kibernum.m6actividad2.apirestproductos.security.domain;

public enum Role {
    ROLE_USER, // get /api/productos/** modo lectura
    ROLE_ADMIN // post, put, delete /api/productos/** modo escritura
}
