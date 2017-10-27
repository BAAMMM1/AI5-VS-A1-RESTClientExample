package app.layerLogic.cmpConsulting.service;

import app.layerGraphicPresentation.RestConsumerConsultingCmp;
import app.layerLogic.cmpConsulting.dto.AppointmentDTO;
import app.layerLogic.cmpConsulting.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Setzt die Usecases (Anwendungsfälle) des Consulting Client um.
 *
 * @author Christian G. on 27.10.2017
 */
@Component
public class ClientConsultingServiceImpl implements IClientConsultingService {

    @Autowired
    private RestConsumerConsultingCmp restConsumerConsultingCmp;


    @Override
    public Appointment getAppointment(int id) {

        AppointmentDTO dto = restConsumerConsultingCmp.getAppointment(id);

        return Appointment.fromDTO(dto);
    }

    @Override
    public List<Appointment> getAppointments() {
        List<AppointmentDTO> appointmentDTOS = this.restConsumerConsultingCmp.getAppointments();

        List<Appointment> appointments = new ArrayList<Appointment>();

        for (AppointmentDTO dto: appointmentDTOS) {
            appointments.add(Appointment.fromDTO(dto));
        }

        return appointments;
    }
}
