package app.layerLogic.cmpConsulting.service;

import app.layerLogic.cmpConsulting.dto.AppointmentDTO;
import app.layerLogic.cmpConsulting.entity.Appointment;

import java.util.List;

/**
 * @author Christian G.
 * @created 27.10.2017
 */
public interface IClientConsultingService {

    Appointment getAppointment(int id);

    List<Appointment> getAppointments();


}
