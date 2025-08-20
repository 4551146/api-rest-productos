package cl.kibernum.m6actividad2.apirestproductos.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
    super(message);
  }
}
