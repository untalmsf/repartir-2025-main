package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.model.Grupo;
import ar.com.grupoesfera.repartir.steps.FastCucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CompuestosPorAlMenosDosMiembrosSteps extends FastCucumberSteps {

    private Grupo grupo;

    @Cuando("el usuario intenta crear un grupo indicando un único miembro")
    public void elUsuarioIntentaCrearUnGrupoIndicandoUnUnicoMiembro() {

        List<String> miembros = new LinkedList<String>();
        miembros.add( "Oscar" );

        grupo = new Grupo();

        grupo.setMiembros( miembros );
    }

    @Entonces("no debería crear el grupo con un único miembro")
    public void noDeberiaCrearElGrupoConUnUnicoMiembro() {

        assertThat( this.grupo.estaFormado() ).isFalse();
    }
    @Cuando("el usuario intenta crear un grupo indicando los miembros {string} y {string}")
    public void elUsuarioIntentaCrearUnGrupoIndicandoLosMiembrosY(String miembro1, String miembro2) {
        List<String> miembros = new LinkedList<>();
        miembros.add(miembro1);
        miembros.add(miembro2);

        grupo = new Grupo();
        grupo.setMiembros(miembros);
    }

    @Entonces("debería crear el grupo con dos o más miembros")
    public void deberiaCrearElGrupoConDosOMasMiembros() {
        assertThat(this.grupo.estaFormado()).isTrue();
    }
}
