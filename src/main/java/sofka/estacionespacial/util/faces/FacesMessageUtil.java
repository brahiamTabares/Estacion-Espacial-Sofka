package sofka.estacionespacial.util.faces;

import javax.faces.application.FacesMessage;

public class FacesMessageUtil {

    public static FacesMessage createUserMessage(String message) {
        return createUserMessage(FacesMessage.SEVERITY_INFO,message);
    }

    public static FacesMessage createUserMessage(FacesMessage.Severity severity, String message) {
        return new FacesMessage(severity,message,message);
    }
    public static FacesMessage createFromException(Exception e) {
        return createUserMessage(FacesMessage.SEVERITY_ERROR, e.getMessage());
    }
}
