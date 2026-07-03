package ar.edu.unahur.obj2.energia.OrquestacionDeEnergia;

import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Excepciones.LimiteReservaException;

public interface OperacionTransferencia {
    void execute() throws LimiteReservaException;
    void undo() throws LimiteReservaException;
}
