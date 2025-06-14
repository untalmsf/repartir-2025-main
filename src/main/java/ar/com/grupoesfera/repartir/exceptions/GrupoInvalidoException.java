package ar.com.grupoesfera.repartir.exceptions;

public class GrupoInvalidoException extends RuntimeException {
    private final CodigoError codigoError;

    public GrupoInvalidoException(CodigoError codigoError) {
        super(codigoError.getMensaje());
        this.codigoError = codigoError;
    }

    public CodigoError getCodigoError() {
        return codigoError;
    }
    
    public enum CodigoError {
        MIEMBROS_INSUFICIENTES("El grupo debe estar formado por al menos 2 miembros"),
        NOMBRE_INCOMPLETO("El grupo debe tener un nombre");


        private final String mensaje;
        
        CodigoError(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getMensaje() {
            return mensaje;
        }
    }
}

