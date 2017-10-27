package app.layerLogic.cmpConsulting.service;

import app.layerGraphicPresentation.RestConsumerConsultingCmp;
import app.layerLogic.cmpConsulting.dto.AppointmentDTO;
import app.layerLogic.cmpConsulting.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Alle Methoden die wir von dem Rest-Service nutzen wollen
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

        if(dto != null){
            return Appointment.fromDTO(dto);
        } else {
            return null;
        }

    }

    @Override
    public List<Appointment> getAppointments() {
        List<AppointmentDTO> appointmentDTOS = this.restConsumerConsultingCmp.getAppointments();

        if(appointmentDTOS != null){

            List<Appointment> appointments = new ArrayList<Appointment>();

            for (AppointmentDTO dto: appointmentDTOS) {
                appointments.add(Appointment.fromDTO(dto));
            }

            return appointments;

        } else {

            return null;
        }


    }
}
