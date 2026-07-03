package ar.edu.unahur.obj2.energia.OrquestacionDeEnergia;

import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Excepciones.LimiteReservaException;

public class Bateria {
    private final Integer idBateria;
    private Double energiaActual;

    public Bateria(Integer idBateria,Double energiaActual){
        this.idBateria = idBateria;
        this.energiaActual = energiaActual;
    }

    public Integer getIdBateria(){
        return this.idBateria;
    }

    public Double getEnergiaActual(){
        return this.energiaActual;
    }

    public void cargarEnergia(Double cargaExtra){
        this.energiaActual += cargaExtra;
    }

    public void consumirEnergia(Double cargaConsumida) throws LimiteReservaException{
        if(cargaConsumida < -5000){
            throw new LimiteReservaException("Se ha alcanzado el limite de uso de la bateria.");
        }
        this.energiaActual -= cargaConsumida;
    }
}
