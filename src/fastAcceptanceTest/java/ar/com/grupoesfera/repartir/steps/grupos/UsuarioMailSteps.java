package ar.com.grupoesfera.repartir.steps.grupos;


import ar.com.grupoesfera.repartir.model.Usuario;
import io.cucumber.java.es.*;
import static org.assertj.core.api.Assertions.*;

public class UsuarioMailSteps {
    private Usuario usuario;
    private Exception error;

    @Dado("que existe un usuario con id {string} y correo {string}")
    public void existeUsuario(String id, String correo) {
        usuario = new Usuario();
        usuario.setId(id);
        try {
            usuario.setCorreo(correo);
        } catch (Exception e) {
            error = e;
        }
    }

    @Cuando("consulto ese usuario")
    public void consultoUsuario() {
        // No hace nada: la validación ocurre en el setter
    }
   
    @Entonces("no debería haber error")
    public void sinError() {
        assertThat(error).isNull();
    }

    @Entonces("debería fallar con mensaje {string}")
    public void errorConMensaje(String msg) {
        assertThat(error)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(msg);
    }
}
