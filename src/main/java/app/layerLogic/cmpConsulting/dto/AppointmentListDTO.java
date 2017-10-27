package app.layerLogic.cmpConsulting.dto;

import java.util.List;

/**
 * @author Christian G. on 27.10.2017
 */
public class AppointmentListDTO {

    List<AppointmentDTO> appointmentDTOList;

    public AppointmentListDTO(List<AppointmentDTO> appointmentDTOList) {
        this.appointmentDTOList = appointmentDTOList;
    }
}
