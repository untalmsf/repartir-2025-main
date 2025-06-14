package ar.com.grupoesfera.repartir.model;

public class Usuario {

    private String id;
    private String correo;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {

        return id;
    }

    public void setCorreo(String correo) {
        if (correo == null || !correo.contains("@") || !correo.contains(".")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.correo = correo;
    }

    public String getCorreo() {

        return correo;
    }
}
