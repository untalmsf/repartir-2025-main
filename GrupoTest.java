package ar.com.grupoesfera.repartir.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class GrupoTest {

    @Test
    void crearSinParametros() {

        Grupo grupo = new Grupo();

        assertThat(grupo.getId()).isNull();
        assertThat(grupo.getNombre()).isNull();
        assertThat(grupo.getMiembros()).isNull();
        assertThat(grupo.getTotal()).isNull();
    }

    @Test
    void crearConId() {

        final Long ID = 153L;
        Grupo grupo = new Grupo(ID);

        assertThat(grupo.getId()).isEqualTo(ID);
        assertThat(grupo.getNombre()).isNull();
        assertThat(grupo.getMiembros()).isNull();
        assertThat(grupo.getTotal()).isNull();
    }

    @Test
    void noEstaFormadoCuandoTieneSoloUnMiembro() {

        Grupo grupo = new Grupo();
        grupo.setMiembros(Arrays.asList("martin"));

        boolean estaFormado = grupo.estaFormado();

        assertThat(estaFormado).isFalse();
    }

    @Test
    void estaFormadoCuandoTieneDosMiembros() {

        Grupo grupo = new Grupo();
        grupo.setMiembros(Arrays.asList("mtolosa", "sdiaz"));

        boolean estaFormado = grupo.estaFormado();

        assertThat(estaFormado).isTrue();
    }

    @Test
    void noPermiteMiembrosNulos() {
        Grupo grupo = new Grupo();

        assertThatThrownBy(() -> grupo.setMiembros(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("La lista de miembros no puede ser nula");
    }
    @Test
    void noPermiteNombresVacios() {
        Grupo grupo = new Grupo();

        assertThatThrownBy(() -> grupo.setMiembros(Arrays.asList("mtolosa", "  ")))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("El nombre no puede estar vacío");
    }
}
