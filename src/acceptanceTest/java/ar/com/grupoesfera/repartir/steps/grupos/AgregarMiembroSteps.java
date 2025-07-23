package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.model.Grupo;
import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.ArrayList;

public class AgregarMiembroSteps {
   
    private Grupo grupo;
    private String mensajeError;

    @Dado("que el grupo {string} existe con tres miembros")
    public void que_el_grupo_existe_con_tres_miembros(String nombre) {
        grupo = new Grupo();
        grupo.setNombre(nombre);
        grupo.setMiembros(new ArrayList<>());
        grupo.getMiembros().add("Miembro1");
        grupo.getMiembros().add("Miembro2");
        grupo.getMiembros().add("Miembro3");
    }
    
    @Dado("que el grupo {string} existe con dos miembros")
    public void que_el_grupo_existe_con_dos_miembros(String nombre) {
        grupo = new Grupo();
        grupo.setNombre(nombre);
        grupo.setMiembros(new ArrayList<>());
        grupo.getMiembros().add("Miembro1");
        grupo.getMiembros().add("Miembro2");
    }

    @Cuando("el usuario agrega un nuevo miembro llamado {string}")
    public void el_usuario_agrega_un_nuevo_miembro_llamado(String nombre) {
        try {
            grupo.agregarMiembro(nombre);
            mensajeError = null;
        } catch (IllegalArgumentException e) {
            mensajeError = e.getMessage();
    }
    

    @Cuando("el usuario intenta agregar un miembro sin nombre")
    public void el_usuario_intenta_agregar_un_miembro_sin_nombre() {
        el_usuario_agrega_un_nuevo_miembro_llamado("");
    }
    
    @Entonces("el grupo {string} debería tener cuatro miembros")
    public void el_grupo_deberia_tener_cuatro_miembros(String nombre) {
        assertThat(grupo.getNombre()).isEqualTo(nombre);
        assertThat(grupo.getMiembros().size()).isEqualTo(4);
    }

     @Entonces("debería mostrarse un mensaje de error indicando que el nombre no puede estar vacío")
    public void deberia_mostrarse_un_mensaje_de_error_indicando_que_el_nombre_no_puede_estar_vacío() {
        assertThat(mensajeError).isEqualTo("El nombre no puede estar vacío");
    }
}
