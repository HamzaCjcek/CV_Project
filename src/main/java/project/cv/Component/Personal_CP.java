package project.cv.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.cv.Database.Personal_DB;
import project.cv.Service.Personal_Service;

@Component
public class Personal_CP {
    private final Personal_Service servicePersonal;

    @Autowired
    public Personal_CP(Personal_Service servicePersonal) {
        this.servicePersonal = servicePersonal;
    }

    public Object Salih(String value) {
        Personal_DB personal = servicePersonal.getFirstPersonel();
        return switch (value) {
            case "Name" -> personal != null ? personal.getNAME() : "Default Name";
            case "Surname" -> personal != null ? personal.getSURNAME() : "Default Surname";
            case "Age" -> personal != null ? personal.getAGE() : "Default Age";
            case "Job" -> personal != null ? personal.getJOB() : "Default Job";
            case "About" -> personal != null ? personal.getABOUT() : "Default About";
            default -> "Default";
        };
    }
}
