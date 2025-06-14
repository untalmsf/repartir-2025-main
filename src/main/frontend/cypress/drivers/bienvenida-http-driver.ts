import { BienvenidaDriver } from "../../../../jsAdvancedAcceptanceTest/src/test-drivers/bienvenida-driver";

export class BienvenidaCypressHttpDriver implements BienvenidaDriver {

    private inicio: any = undefined;
    private pedido: any = undefined;
  
    acceder = (): void => {
      cy.request("/api/grupos").then(respuesta => this.inicio = respuesta);
    };
  
    iniciar = (): void => {
      cy.request("/api/usuarios/julian").then(respuesta => this.pedido = respuesta);
    };
  
    validarMensajeDeBienvenida =  (): void => {
      expect(this.inicio.status).to.be.equal(200);
    };
  
    validarQueSePuedeUsar =  (): void => {
      expect(this.pedido.status).to.be.equal(200);
    };
  }