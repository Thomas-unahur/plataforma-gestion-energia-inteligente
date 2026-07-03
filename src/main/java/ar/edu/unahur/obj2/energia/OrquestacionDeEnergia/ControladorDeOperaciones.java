package ar.edu.unahur.obj2.energia.OrquestacionDeEnergia;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Excepciones.LimiteReservaException;

public class ControladorDeOperaciones {
    
    private List<OperacionTransferencia> operacionesPendientes = new ArrayList<>();
    private Stack<OperacionTransferencia> historial = new Stack<>();

    public void ejecucionInmediata(OperacionTransferencia operacion) throws LimiteReservaException {
        operacion.execute();
        historial.push(operacion);
    }

    public void registrarPendiente(OperacionTransferencia operacion) {
        this.operacionesPendientes.add(operacion);
    }

    public void ejecutarOperacionesDeRutina() throws LimiteReservaException{
        RutinaDeControl rutina = new RutinaDeControl(new ArrayList<>(this.operacionesPendientes));
        rutina.execute();
        historial.push(rutina);
        this.operacionesPendientes.clear();
    }

    public void deshacerUltimaRutina() throws LimiteReservaException {
        OperacionTransferencia ultimaRutina = historial.pop();
        ultimaRutina.undo();
    }
}