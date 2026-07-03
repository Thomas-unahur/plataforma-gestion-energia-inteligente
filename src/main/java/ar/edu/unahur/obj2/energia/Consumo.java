package ar.edu.unahur.obj2.energia;

import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Bateria;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.OperacionTransferencia;

public class Consumo implements OperacionTransferencia{
    private Bateria bateria;
    private Double consumoEnergia;

    public Consumo(Bateria bateria,Double consumoEnergia){
        this.bateria = bateria;
        this.consumoEnergia = consumoEnergia;
    }

    @Override
    public void execute(){
        this.bateria.consumirEnergia(this.consumoEnergia);
    }

    @Override
    public void undo(){
        this.bateria.cargarEnergia(this.consumoEnergia);
    }
}
