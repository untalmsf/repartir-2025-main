package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.model.Grupo;
import ar.com.grupoesfera.repartir.steps.FastCucumberSteps;
import io.cucumber.java.es.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RenombrarGrupoSteps extends FastCucumberSteps {

    private Grupo grupo;
    private String mensajeError;

    @Dado("que el usuario tiene un grupo con nombre {string}")
    public void queElUsuarioTieneUnGrupoConNombre(String nombre) {
        grupo = new Grupo();
        grupo.setNombre(nombre);
        mensajeError = null;
    }

    @Cuando("el usuario renombra el grupo a {string}")
    public void elUsuarioRenombraElGrupoA(String nuevoNombre) {
        mensajeError = null;

        if (nuevoNombre == null || nuevoNombre.trim().length() < 3) {
            mensajeError = "El nuevo nombre debe tener al menos 3 caracteres";
            return;
        }

        grupo.setNombre(nuevoNombre);
    }

    @Entonces("el grupo debería tener el nombre {string}")
    public void elGrupoDeberiaTenerElNombre(String esperado) {
        assertThat(grupo.getNombre()).isEqualTo(esperado);
    }

    @Entonces("debería ser informado que el nuevo nombre debe tener al menos 3 caracteres")
    public void deberiaSerInformadoQueElNuevoNombreDebeTenerAlMenos3Caracteres() {
        assertThat(mensajeError).isEqualTo("El nuevo nombre debe tener al menos 3 caracteres");
    }
}

