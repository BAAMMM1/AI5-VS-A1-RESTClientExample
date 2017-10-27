package app;

import app.layerLogic.cmpConsulting.entity.Appointment;
import app.layerLogic.cmpConsulting.service.IClientConsultingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Startet die Spring-Boot-app.Application
 *
 * @author Christian G.
 * @created 27.10.2017
 */
@SpringBootApplication
public class Application implements CommandLineRunner{

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private IClientConsultingService clientConsultingService;

    public static void main(String args[]){
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Appointment appointment = this.clientConsultingService.getAppointment(1);
        LOGGER.info("Respone:{}", appointment.toString());

        List<Appointment> appointments = this.clientConsultingService.getAppointments();
        LOGGER.info("Respone:{}", appointments.toString());

    }
}
