package app.layerGraphicPresentation;

import app.layerLogic.cmpConsulting.dto.AppointmentDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Christian G. on 27.10.2017
 */
@Controller
public class RestConsumerConsultingCmp {

    private final String PATH_GET_APPOINTMENT_BY_ID = "http://localhost:8080/appoints/{id}";
    private final String PATH_GET_APPOINTMENTS = "http://localhost:8080/appoints/";

    @Autowired
    private RestOperations restOperation;

    public AppointmentDTO getAppointment(int id) {
        ResponseEntity<String> response = null;
        AppointmentDTO participantJson = null;

        try {
            response = restOperation.getForEntity(PATH_GET_APPOINTMENT_BY_ID, String.class, id);

            HttpStatus status = response.getStatusCode();
            String restCall = response.getBody();

            System.out.println(response.getStatusCode());
            System.out.println(response.getStatusCodeValue());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());

            Gson gson = new Gson();
            participantJson = gson.fromJson(restCall, AppointmentDTO.class);


        } catch (RestClientException e){
            System.out.println(e.getMessage());
        }



        return participantJson;

        //return this.restOperation.getForObject(PATH_GET_APPOINTMENT_BY_ID, AppointmentDTO.class, id);

    }


    public List<AppointmentDTO> getAppointments() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = this.restOperation.getForObject(PATH_GET_APPOINTMENTS, String.class);

        List<AppointmentDTO> participantJsonList = null;

        Gson gson = new Gson();
        participantJsonList = gson.fromJson(jsonString, new TypeToken<List<AppointmentDTO>>(){}.getType());

        participantJsonList = new ArrayList<AppointmentDTO>(Arrays.asList(gson.fromJson(jsonString, AppointmentDTO[].class)));

        return participantJsonList;

    }
}
