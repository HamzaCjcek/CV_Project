package project.cv.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import project.cv.Service.Languages_Service;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class Admin_Controller {
    protected final Languages_Service languagesService;
    @Autowired
    public Admin_Controller( Languages_Service languagesService) {
        this.languagesService = languagesService;
    }
    //ANA SAYFA
    @GetMapping("/admin")
    public String adminPage() {
        return "admin/admin";
    }

}
