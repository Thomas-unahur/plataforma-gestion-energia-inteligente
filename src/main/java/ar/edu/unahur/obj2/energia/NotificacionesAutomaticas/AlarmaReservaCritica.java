package ar.edu.unahur.obj2.energia.NotificacionesAutomaticas;

import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Bateria;

public class AlarmaReservaCritica implements ObservadorBateria{
    @Override
    public void actualizar(Bateria bateria) {
        if(bateria.getEnergiaActual() < 0){
            System.out.println("Alerta: la bateria " + bateria.getIdBateria() + " esta por debajo de su nivel de tolerancia.");
        }
    }
}
