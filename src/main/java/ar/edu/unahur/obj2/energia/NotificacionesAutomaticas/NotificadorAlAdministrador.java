package ar.edu.unahur.obj2.energia.NotificacionesAutomaticas;

import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Bateria;

public class NotificadorAlAdministrador implements ObservadorBateria{
    @Override
    public void actualizar(Bateria bateria) {
        System.out.println("Se han cargado " + bateria.getEnergiaActual() + "kWh en la bateria");
    }
}
