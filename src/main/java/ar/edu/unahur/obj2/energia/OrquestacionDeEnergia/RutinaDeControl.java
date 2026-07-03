package ar.edu.unahur.obj2.energia.OrquestacionDeEnergia;

import java.util.List;
import java.util.Stack;

import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Excepciones.LimiteReservaException;

public class RutinaDeControl implements OperacionTransferencia{
    private List<OperacionTransferencia> operaciones;

    public RutinaDeControl(List<OperacionTransferencia> operaciones){
        this.operaciones = operaciones;
    }

    public void agregarOperacion(OperacionTransferencia operacion) {
        this.operaciones.add(operacion);
    }

    @Override
    public void execute() throws LimiteReservaException{
        Stack<OperacionTransferencia> operacionesExitosas = new Stack<>();

        try{
            for(OperacionTransferencia operacion : operaciones){
            operacion.execute();
            operacionesExitosas.push(operacion);
        }
        }
        catch(LimiteReservaException e){
            OperacionTransferencia operacionFallida = operacionesExitosas.pop();
            operacionFallida.undo();
            throw e;
        }
    }

    @Override
    public void undo() throws LimiteReservaException{
        for(Integer i= operaciones.size() - 1; i>=0; i--){
            operaciones.get(i).undo();
        }
    }
}
