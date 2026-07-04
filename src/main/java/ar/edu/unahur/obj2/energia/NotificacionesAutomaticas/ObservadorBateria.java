package ar.edu.unahur.obj2.energia.NotificacionesAutomaticas;

import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Bateria;

public interface ObservadorBateria {
    void actualizar(Bateria bateria);
}