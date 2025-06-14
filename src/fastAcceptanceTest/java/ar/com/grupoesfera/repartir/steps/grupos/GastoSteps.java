package ar.com.grupoesfera.repartir.steps.grupos;


import io.cucumber.java.es.*;
import java.math.BigDecimal;

import ar.com.grupoesfera.repartir.model.Gasto;

import static org.assertj.core.api.Assertions.*;

public class GastoSteps {
    
    private Gasto gasto;
    private Exception error;

    @Dado("que existe un usuario registrado con id {string} y correo {string}")
    public void existeUsuarioRegistrado(String id, String correo) {
        // Suponemos que el usuario existe para el propósito del test.
    }

    @Cuando("el usuario con id {string} intenta registrar un gasto de {double}")
    public void usuarioIntentaRegistrarGastoConDecimales(String id, Double monto) {
        gasto = new Gasto();
        try {
            BigDecimal montoDecimal = new BigDecimal(String.valueOf(monto));
            gasto.setMonto(montoDecimal);
            error = null;
        } catch (Exception e) {
            error = e;
        }
    }
}
