package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.model.Grupo;
import ar.com.grupoesfera.repartir.steps.FastCucumberSteps;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;

import java.util.HashMap;
import java.util.Map;
public class EliminarGrupoSteps {
    
    private final Map<Long, Grupo> grupos = new HashMap<>();

    @Dado("que el usuario tiene un grupo con id {long}")
    public void queElUsuarioTieneUnGrupoConId(Long id) {
        Grupo grupo = new Grupo();
        grupo.setId(id);
        grupos.put(id, grupo);
    }

    @Cuando("el usuario elimina el grupo")
    public void elUsuarioEliminaElGrupo() {
        if (!grupos.isEmpty()) {
            Long id = grupos.keySet().iterator().next();
            grupos.remove(id);
        }
    }
}
