package project.cv.Controller.Admin;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import project.cv.Database.Skill_DB;
import project.cv.Service.Skill_Service;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class SkillController {
    protected final Skill_Service skillService;

    public SkillController(Skill_Service skillService) {
        this.skillService = skillService;
    }

    //Table SAYFASI
    @GetMapping("/admin/tables")
    public String getTablesPage(Model model) {
        List<Skill_DB> AdminSkills=skillService.getAllSkills();
        model.addAttribute("skillsAdmin", AdminSkills);
        return "admin/pages/tables"; // Thymeleaf şablonunun yolu
    }
    //Update Sayfası

    //Update Sayfası
    @GetMapping("/update/{id}")
    public String editItem(@PathVariable("id") int id, Model model) {
        Skill_DB item = skillService.getSkillById(id);
        model.addAttribute("adminSkill", item);
        return "admin/table_skill/UpdateSkill";
    }
    //Update Islemi
    @PostMapping("/update")
    public String updateItem(Skill_DB item) {
        skillService.updateSkill(item);
        return "redirect:/admin";
    }
    //Delete Skill Islemi
    @PostMapping("/deleteskill/{id}")
    public String deleteSkill(@PathVariable("id") int id) {
        skillService.deleteSkill(id);
        return "redirect:/admin";
    }

    //Create Sayfası
    @GetMapping("/create")
    public String showSkill(Model model) {
        model.addAttribute("skill", new Skill_DB());
        return "admin/table_skill/CreateSkill_Page";
    }
    //Create Islemi
    @PostMapping("/create")
    public String createSkill(@ModelAttribute("skill") Skill_DB skill) {
        skillService.createSkill(skill);
        return "redirect:/admin"; // Başarıyla oluşturulduktan sonra listeye yönlendirir
    }
}
