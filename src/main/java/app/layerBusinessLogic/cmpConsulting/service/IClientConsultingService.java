package app.layerBusinessLogic.cmpConsulting.service;

import app.layerBusinessLogic.cmpConsulting.entity.Appointment;

import java.util.List;

/**
 * Alle Methoden die wir von dem Rest-Service nutzen wollen
 * @author Christian G.
 * @created 27.10.2017
 */
public interface IClientConsultingService {

    Appointment getAppointment(int id);

    List<Appointment> getAppointments();


}
