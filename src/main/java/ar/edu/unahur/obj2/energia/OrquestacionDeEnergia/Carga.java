package ar.edu.unahur.obj2.energia.OrquestacionDeEnergia;

public class Carga implements OperacionTransferencia{
    private Bateria bateria;
    private Double cantidadEnergia;

    public Carga(Bateria bateria,Double cantidadEnergia){
        this.bateria = bateria;
        this.cantidadEnergia = cantidadEnergia;
    }

    @Override
    public void execute(){
        this.bateria.cargarEnergia(cantidadEnergia);
    }

    @Override
    public void undo(){
        this.bateria.consumirEnergia(cantidadEnergia);
    }
}
