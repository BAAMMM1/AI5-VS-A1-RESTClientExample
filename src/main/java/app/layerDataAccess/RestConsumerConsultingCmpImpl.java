package app.layerDataAccess;

import app.layerBusinessLogic.cmpConsulting.dto.AppointmentDTO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Christian G. on 27.10.2017
 */
@Controller
public class RestConsumerConsultingCmpImpl implements IRestConsumerConsultingCmp {

    @Value("${appoints.service.url}")
    private String PATH_GET_APPOINTMENT_BY_ID;

    private final String PATH_GET_APPOINTMENTS = "http://localhost:8080/appoints/";

    @Autowired
    private RestTemplate restOperation;

    private Gson gson;

    public RestConsumerConsultingCmpImpl() {
        this.gson = new Gson();
    }


    public AppointmentDTO getAppointment(int id) {

        ResponseEntity<String> response = restOperation.getForEntity(PATH_GET_APPOINTMENT_BY_ID, String.class, id);

        if (response.getStatusCode() == HttpStatus.OK) {

            System.out.println(response.getStatusCode() + "\n" + response.getBody() + "\n" + response.getHeaders());

            return this.gson.fromJson(response.getBody(), AppointmentDTO.class);

        } else {
            return null;

        }

    }


    public List<AppointmentDTO> getAppointments() {

        String jsonString = this.restOperation.getForObject(PATH_GET_APPOINTMENTS, String.class);

        return new ArrayList<>(Arrays.asList(this.gson.fromJson(jsonString, AppointmentDTO[].class)));
    }
}
