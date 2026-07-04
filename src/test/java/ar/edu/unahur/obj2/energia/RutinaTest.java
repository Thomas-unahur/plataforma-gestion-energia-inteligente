package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Bateria;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Carga;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Consumo;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.OperacionTransferencia;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.RutinaDeControl;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Excepciones.LimiteReservaException;

public class RutinaTest {
    @Test
    void testRutinaEjecutaVariasOperaciones() throws LimiteReservaException {
    List<OperacionTransferencia> operaciones = new ArrayList<>();
    Bateria bateria = new Bateria(001, 1000.0);
    operaciones.add(new Carga(bateria, 200.0));
    operaciones.add(new Consumo(bateria, 100.0));
    
    RutinaDeControl rutina = new RutinaDeControl(operaciones);
    rutina.execute();
    assertEquals(1100.0, bateria.getEnergiaActual());
}
}
