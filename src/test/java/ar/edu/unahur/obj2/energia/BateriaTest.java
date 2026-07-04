package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Bateria;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Excepciones.LimiteReservaException;

public class BateriaTest {
    private Bateria bateria;

    @BeforeEach
    void setUp() {
        bateria = new Bateria(001, 1000.0);
    }

    @Test
    void testCargaExitosa() {
        bateria.cargarEnergia(500.00);
        assertEquals(1500, bateria.getEnergiaActual());
    }

    @Test
    void testConsumoExitoso() throws LimiteReservaException {
        bateria.consumirEnergia(500.00);
        assertEquals(500, bateria.getEnergiaActual());
    }

    @Test
    void testConsumoLlegaAlLimiteExacto() throws LimiteReservaException {
        // 1000 - 6000 = -5000 (Límite permitido)
        bateria.consumirEnergia(6000.00);
        assertEquals(-5000, bateria.getEnergiaActual());
    }

    @Test
    void testConsumoSuperaLimiteLanzaExcepcion() {
        
        assertThrows(LimiteReservaException.class, 
            () -> {
            bateria.consumirEnergia(6001.00);
        });
    }
}
