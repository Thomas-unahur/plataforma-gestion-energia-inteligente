package ar.edu.unahur.obj2.energia.OrquestacionDeEnergia;

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

    public void consumirEnergia(Double cargaConsumida){
        this.energiaActual -= cargaConsumida;
    }
}
