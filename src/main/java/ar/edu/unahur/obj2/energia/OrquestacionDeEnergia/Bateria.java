package ar.edu.unahur.obj2.energia.OrquestacionDeEnergia;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.energia.NotificacionesAutomaticas.ObservadorBateria;
import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Excepciones.LimiteReservaException;

public class Bateria {
    private final Integer idBateria;
    private Double energiaActual;
    private List<ObservadorBateria> suscriptores = new ArrayList<>();

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
        notificarCambio();
    }

    public void consumirEnergia(Double cargaConsumida) throws LimiteReservaException{
        double nivelTrasElConsumo = this.energiaActual - cargaConsumida;
        if(nivelTrasElConsumo < -5000){
            throw new LimiteReservaException("Se ha alcanzado el limite de uso de la bateria.");
        }
        this.energiaActual -= cargaConsumida;
        notificarCambio();
    }

    public void agregarObservador(ObservadorBateria observador) {
        this.suscriptores.add(observador);
    }

    public void quitarObservador(ObservadorBateria observador) {
        this.suscriptores.remove(observador);
    }

    private void notificarCambio() {
        for (ObservadorBateria obs : suscriptores) {
            obs.actualizar(this); 
        }
    }
}
