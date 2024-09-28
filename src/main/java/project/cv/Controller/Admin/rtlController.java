package project.cv.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project.cv.Database.*;
import project.cv.Service.Education_Service;
import project.cv.Service.Experience_Service;
import project.cv.Service.Graduate_Service;
import project.cv.Service.References_Service;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class rtlController {
    @Autowired
    private Experience_Service experienceService;
    @Autowired
    private Education_Service educationService;
    @Autowired
    private Graduate_Service graduateService;
    @Autowired
    private References_Service referencesService;

    @GetMapping("/admin/rtl")
    public String getTablesPage(Model model) {
        List<Experience_DB> experienceDbs=experienceService.getAllExperience();
        List<Education_DB> educationDbs=educationService.getAllEducation();
        List<Graduate_DB> graduateDbs=graduateService.getAllGraduate();
        List<References_DB> referencesDbs=referencesService.getAllReferences();
        model.addAttribute("experience", experienceDbs);
        model.addAttribute("education", educationDbs);
        model.addAttribute("graduate", graduateDbs);
        model.addAttribute("reference", referencesDbs);
        return "admin/pages/rtl"; // Thymeleaf şablonunun yolu
    }
    //Update Sayfası
    @GetMapping("/updateRtl/{id}")
    public String editItem(@PathVariable("id") int id, Model model) {
        Experience_DB experienceDb = experienceService.getExperienceId(id);
        model.addAttribute("updateExperience", experienceDb);
        return "admin/table_rtl/UpdateExperience";
    }
    @GetMapping("/updateRtl_Education/{id}")
    public String editItem_Education(@PathVariable("id") int id, Model model) {
        Education_DB educationDb = educationService.getEducationId(id);
        model.addAttribute("updateEducation", educationDb);
        return "admin/table_rtl/UpdateEducation";
    }
    @GetMapping("/updateRtl_Graduate/{id}")
    public String editItem_Graduate(@PathVariable("id") int id, Model model) {
        Graduate_DB graduateDb = graduateService.getGraduate(id);
        model.addAttribute("updateGraduate", graduateDb);
        return "admin/table_rtl/UpdateGraduate";
    }
    @GetMapping("/updateRtl_Reference/{id}")
    public String editItem_Reference(@PathVariable("id") int id, Model model) {
        References_DB referencesDb = referencesService.getReferencesId(id);
        model.addAttribute("updateReference", referencesDb);
        return "admin/table_rtl/UpdateReference";
    }
    //Update Islemi
    @PostMapping("/updateRtlExperience")
    public String updateItem_experience(Experience_DB experience) {
        experienceService.updateExperience(experience);
        return "redirect:/admin";
    }
    @PostMapping("/updateRtlEducation")
    public String updateItem_Education(Education_DB education) {
        educationService.updateEducation(education);
        return "redirect:/admin";
    }
    @PostMapping("/updateRtlGraduate")
    public String updateItem_Graduate(Graduate_DB graduate) {
        graduateService.updateGraduate(graduate);
        return "redirect:/admin";
    }
    @PostMapping("/updateRtlReference")
    public String updateItem_Graduate(References_DB reference) {
        referencesService.updateReferences(reference);
        return "redirect:/admin";
    }
}
