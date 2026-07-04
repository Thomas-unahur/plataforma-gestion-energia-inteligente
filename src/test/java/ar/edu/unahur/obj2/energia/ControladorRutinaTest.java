package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Bateria;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Carga;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Consumo;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.ControladorDeOperaciones;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Excepciones.LimiteReservaException;

public class ControladorRutinaTest {
    @Test
void testControladorEjecutaYVaciaPendientes() throws LimiteReservaException {
    ControladorDeOperaciones controlador = new ControladorDeOperaciones();
     Bateria bateria = new Bateria(001, 1000.0);
    controlador.registrarPendiente(new Carga(bateria, 500.0));
    controlador.registrarPendiente(new Consumo(bateria, 200.0));
    
    controlador.ejecutarOperacionesDeRutina();
    
    assertEquals(1300.0, bateria.getEnergiaActual());
    assertEquals(0, controlador.cantidadDeOperacionesRestantates());
}
}
