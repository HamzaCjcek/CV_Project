package project.cv.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project.cv.Database.Personal_DB;
import project.cv.Service.Personal_Service;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class PersonalController {
    @Autowired
    private Personal_Service personal_service;

    @GetMapping("/admin/personal")
    public String getPersonalPage(Model model) {
        Personal_DB personal_db = personal_service.getFirstPersonel(); // Tek bir veri al
        model.addAttribute("personality", personal_db); // Modeli güncelle
        return "admin/pages/personal"; // Şablon adı
    }
    //Update Sayfası
    @GetMapping("/updatePersonal/{id}")
    public String editItem(@PathVariable("id") int id, Model model) {
        Personal_DB item = personal_service.getByID(id);
        model.addAttribute("updatePersonality", item);
        return "admin/table_personal/Update_Personal";
    }
    //Update Islemi
    @PostMapping("/updatePersonal")
    public String updateItem(@ModelAttribute("updatePersonality") Personal_DB item) {
        personal_service.update(item);
        return "redirect:/admin";
    }


}
