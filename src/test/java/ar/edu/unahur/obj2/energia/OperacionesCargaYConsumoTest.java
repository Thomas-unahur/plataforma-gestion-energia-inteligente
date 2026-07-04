package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Bateria;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Carga;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Consumo;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Excepciones.LimiteReservaException;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Excepciones.ValorInvalidoException;

public class OperacionesCargaYConsumoTest {

    private Bateria bateria;

    @BeforeEach
    void setUp() {
        bateria = new Bateria(001, 1000.00);
    }

    @Test
    void testOperacionCargaConValorInvalidoLanzaValorInvalido() {

        assertThrows(ValorInvalidoException.class, 
            () -> {
            new Carga(bateria, 0.00);
        });

        assertThrows(ValorInvalidoException.class, 
            () -> {
            new Carga(bateria, -100.00);
        });
    }

    @Test
    void testEjecutarYDeshacerCarga() throws LimiteReservaException {
        Carga carga = new Carga(bateria, 500.00);
        carga.execute();
        assertEquals(1500, bateria.getEnergiaActual());
        
        carga.undo();
        assertEquals(1000, bateria.getEnergiaActual());
    }

    @Test
    void testConsumoEjecutaYDeshace() throws LimiteReservaException {
        Consumo consumo = new Consumo(bateria, 400.0);
        
        consumo.execute();
        assertEquals(600.0, bateria.getEnergiaActual());
        
        consumo.undo();
        assertEquals(1000.0, bateria.getEnergiaActual());
    }
}
