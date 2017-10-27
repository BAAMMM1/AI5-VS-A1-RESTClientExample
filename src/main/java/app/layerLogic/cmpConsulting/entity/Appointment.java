package app.layerLogic.cmpConsulting.entity;

import app.layerLogic.cmpConsulting.dto.AppointmentDTO;
import app.layerLogic.cmpConsulting.util.DateUtil;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Date;

/**
 * Stellt die Entität Termin da
 */
public class Appointment {

    private String consultant;

    private Date appointmentDate;

    private String student;

    public Appointment() {
    }

    public Appointment(String consultant, Date appointmentDate) {
        this.consultant = consultant;
        this.appointmentDate = appointmentDate;
    }

    public Appointment(String consultant, Date appointmentDate, String student) {
        this.consultant = consultant;
        this.appointmentDate = appointmentDate;
        this.student = student;
    }


    public String getConsultant() {
        return consultant;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setConsultant(String consultant) {
        this.consultant = consultant;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        if (consultant != null ? !consultant.equals(that.consultant) : that.consultant != null) return false;
        if (appointmentDate != null ? !appointmentDate.equals(that.appointmentDate) : that.appointmentDate != null)
            return false;
        return student != null ? student.equals(that.student) : that.student == null;
    }

    @Override
    public int hashCode() {
        int result = consultant != null ? consultant.hashCode() : 0;
        result = 31 * result + (appointmentDate != null ? appointmentDate.hashCode() : 0);
        result = 31 * result + (student != null ? student.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "consultant='" + consultant + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", student=" + student +
                '}';
    }

    public AppointmentDTO toDTO(){
        return
                new AppointmentDTO(
                        this.getConsultant(),
                        this.getStudent(),
                        this.getAppointmentDate().toString()
                );
    }

    public static Appointment fromDTO(AppointmentDTO dto){
        checkNotNull(dto);
        return
                new Appointment(
                        dto.getUuidConsultant(),
                        DateUtil.getDate(dto.getDate()),
                        dto.getUuidStudent()
                );
    }
}
