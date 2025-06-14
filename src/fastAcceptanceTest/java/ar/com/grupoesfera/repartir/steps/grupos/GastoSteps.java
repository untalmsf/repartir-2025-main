package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.model.Gasto;
import io.cucumber.java.es.*;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.*;

public class GastoSteps {

    private Gasto gasto;
    private Exception error;

    @Dado("que existe un usuario registrado con id {string} y correo {string}")
    public void existeUsuarioRegistrado(String id, String correo) {
        // Suponemos que el usuario existe para el propósito del test.
    }

    @Dado("que existe un usuario habilitado con id {string} y correo {string}")
    public void existeUsuarioHabilitado(String id, String correo) {
        // Suponemos que el usuario está habilitado, no necesitamos guardar nada por ahora.
    }

    @Cuando("el usuario con id {string} registra un gasto de {double}")
    public void el_usuario_con_id_registra_un_gasto_de(String id, Double monto) {
        // Reutilizo la lógica que ya tenés para validar y setear gasto
        usuarioIntentaRegistrarGastoConDecimales(id, monto);
    }

    @Cuando("el usuario con id {string} intenta registrar un gasto de {double}")
    public void usuarioIntentaRegistrarGastoConDecimales(String id, Double monto) {
        gasto = new Gasto();
        try {
            BigDecimal montoDecimal = new BigDecimal(String.valueOf(monto));
            validarMonto(montoDecimal);  // si tenés lógica de validación
            gasto.setMonto(montoDecimal);
            error = null;
        } catch (Exception e) {
            error = e;
        }
    }

    @Cuando("el usuario con id {string} intenta registrar un gasto de {string}")
    public void registraGastoInvalido(String id, String montoStr) {
        gasto = new Gasto();
        try {
            BigDecimal monto = new BigDecimal(montoStr);
            validarMonto(monto);
            gasto.setMonto(monto);
            error = null;
        } catch (NumberFormatException e) {
            error = new IllegalArgumentException("El monto ingresado debe ser un número positivo");
        } catch (Exception e) {
            error = e;
        }
    }

    private void validarMonto(BigDecimal monto) {
        if (monto.scale() > 2) {
            throw new IllegalArgumentException("Solo se permiten hasta 2 decimales");
        }
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto del gasto debe ser positivo");
        }
    }

    @Entonces("el gasto registrado debe ser {double}")
    public void gastoCorrecto(Double expected) {
        assertThat(error).isNull();
        assertThat(gasto.getMonto().doubleValue()).isEqualTo(expected);
    }

    @Entonces("debería mostrarse el error {string}")
    public void mensajeError(String msg) {
        assertThat(error)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(msg);
    }
}