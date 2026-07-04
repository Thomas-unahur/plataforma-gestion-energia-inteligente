package ar.edu.unahur.obj2.energia.NotificacionesAutomaticas;

import ar.edu.unahur.obj2.energia.OrquestacionDeEnergia.Bateria;

public class RegistroAuditoria implements ObservadorBateria{
    @Override
    public void actualizar(Bateria bateria) {
        System.out.println("Registro de auditoria para la bateria " + bateria.getIdBateria() + " guardado");
    }
}
