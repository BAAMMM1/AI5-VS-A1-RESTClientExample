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
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

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

    private RestTemplate restOperation;

    private Gson gson;

    @Autowired
    public RestConsumerConsultingCmp(RestTemplate restOperation) {
        this.restOperation = restOperation;
        this.restOperation.setErrorHandler(new MyErrorHandler());
        this.gson = new Gson();
    }

    /*
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


        } catch (HttpStatusCodeException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStatusCode());

        } catch (RestClientException e) {
            System.out.println(e.getMessage());

        }


        return participantJson;

        //return this.restOperation.getForObject(PATH_GET_APPOINTMENT_BY_ID, AppointmentDTO.class, id);

    }
    */

    public AppointmentDTO getAppointment(int id) {

        ResponseEntity<String> response = restOperation.getForEntity(PATH_GET_APPOINTMENT_BY_ID, String.class, id);

        if (response.getStatusCode() == HttpStatus.OK) {

            System.out.println(response.getStatusCode() + "\n" + response.getBody() + "\n" + response.getHeaders());

            return this.gson.fromJson(response.getBody(), AppointmentDTO.class);

        } else {
            return null;

        }

        //return this.restOperation.getForObject(PATH_GET_APPOINTMENT_BY_ID, AppointmentDTO.class, id);

    }


    public List<AppointmentDTO> getAppointments() {

        String jsonString = this.restOperation.getForObject(PATH_GET_APPOINTMENTS, String.class);

        return new ArrayList<>(Arrays.asList(this.gson.fromJson(jsonString, AppointmentDTO[].class)));
    }
}
