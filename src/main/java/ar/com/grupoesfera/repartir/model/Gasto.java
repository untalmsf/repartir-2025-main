package ar.com.grupoesfera.repartir.model;

import java.math.BigDecimal;

public class Gasto {

    private BigDecimal monto;

    public BigDecimal getMonto() {
        return  monto;
    }

    public void setMonto(BigDecimal monto) {
        if (monto.signum() < 0) {
            throw new IllegalArgumentException("El monto del gasto debe ser positivo");
        }
        if (monto.scale() > 2) {
            throw new IllegalArgumentException("Solo se permiten hasta 2 decimales");
        }
        this.monto = monto;
    }
}
