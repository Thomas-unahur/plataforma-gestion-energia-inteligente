package ar.edu.unahur.obj2.energia.OrquestacionDeEnergia;

import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Excepciones.LimiteReservaException;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Excepciones.ValorInvalidoException;

public class Consumo implements OperacionTransferencia{
    private Bateria bateria;
    private Double cantidadEnergia;

    public Consumo(Bateria bateria,Double consumoEnergia){
        if (cantidadEnergia <=0){
            throw new ValorInvalidoException("El valor de energia no puede ser menor a cero.");
        }
        this.bateria = bateria;
        this.cantidadEnergia = consumoEnergia;
    }
    

    @Override
    public void execute() throws LimiteReservaException{
        this.bateria.consumirEnergia(this.cantidadEnergia);
    }

    @Override
    public void undo() throws LimiteReservaException{
        this.bateria.cargarEnergia(this.cantidadEnergia);
    }
}
