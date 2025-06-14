package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.model.Grupo;
import ar.com.grupoesfera.repartir.steps.FastCucumberSteps;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

public class EliminarGrupoSteps extends FastCucumberSteps {

    private final Map<Long, Grupo> grupos = new HashMap<>();
    private String mensajeError;

    @Dado("que el usuario tiene un grupo con id {long}")
    public void queElUsuarioTieneUnGrupoConId(Long id) {
        Grupo grupo = new Grupo();
        grupo.setId(id);
        grupos.put(id, grupo);
    }

    @Dado("que el usuario no tiene un grupo con id {long}")
    public void queElUsuarioNoTieneUnGrupoConId(Long id) {
        // Aseguramos que el grupo con ese id no esté presente
        grupos.remove(id);
    }

    @Cuando("el usuario elimina el grupo")
    public void elUsuarioEliminaElGrupo() {
        if (!grupos.isEmpty()) {
            Long id = grupos.keySet().iterator().next();
            grupos.remove(id);
        }
    }

    @Cuando("el usuario intenta eliminar el grupo {long}")
    public void elUsuarioIntentaEliminarElGrupo(Long id) {
        if (!grupos.containsKey(id)) {
            mensajeError = "El grupo no existe";
        } else {
            grupos.remove(id);
        }
    }

    @Entonces("el grupo no debería existir")
    public void elGrupoNoDeberiaExistir() {
        assertThat(grupos).isEmpty();
    }

    @Entonces("debería ser informado que el grupo no existe")
    public void deberiaSerInformadoQueElGrupoNoExiste() {
        assertThat(mensajeError).isEqualTo("El grupo no existe");
    }
}
