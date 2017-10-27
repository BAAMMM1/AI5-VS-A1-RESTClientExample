package app.layerDataAccess;

import app.layerBusinessLogic.cmpConsulting.dto.AppointmentDTO;

import java.util.List;

/**
 * @author Christian G. on 27.10.2017
 */
public interface IRestConsumerConsultingCmp {

    AppointmentDTO getAppointment(int id);

    List<AppointmentDTO> getAppointments();
}
