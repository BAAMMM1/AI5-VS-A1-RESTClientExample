package app.layerBusinessLogic.cmpConsulting.dto;

/** DTO
 *  - Vergeben die Struktur von Objekten
 *  - Es wird nur übermittel was gebraucht und was sinnvoll ist
 *  - Erhöht die Leistung und Sicherheit
 * @author Christian G.
 * @created 27.10.2017
 */
public class AppointmentDTO {

    private String uuidConsultant;
    private String uuidStudent;
    private String date;

    public AppointmentDTO() {
    }

    public AppointmentDTO(String uuidConsultant, String uuidStudent, String date) {
        this.uuidConsultant = uuidConsultant;
        this.uuidStudent = uuidStudent;
        this.date = date;
    }

    public String getUuidConsultant() {
        return uuidConsultant;
    }

    public void setUuidConsultant(String uuidConsultant) {
        this.uuidConsultant = uuidConsultant;
    }

    public String getUuidStudent() {
        return uuidStudent;
    }

    public void setUuidStudent(String uuidStudent) {
        this.uuidStudent = uuidStudent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
