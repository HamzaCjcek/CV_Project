package project.cv.Controller.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project.cv.Database.Languages_DB;
import project.cv.Service.Languages_Service;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class LanguageController {

    private final Languages_Service languagesService;

    @Autowired
    public LanguageController(Languages_Service languagesService) {
        this.languagesService = languagesService;
    }
    //Billing SAYFASI
    @GetMapping("/admin/languages")
    public String getBillingPage(Model model) {
        List<Languages_DB> languages = languagesService.getAllLanguages();
        model.addAttribute("languagesAdmin",languages);
        return "admin/pages/languages";
    }

    //Create Sayfası
    @GetMapping("/createLanguage")
    public String showLanguages(Model model) {
        model.addAttribute("languages", new Languages_DB());
        return "admin/table_languages/CreateLanguages";
    }

    //Create Islemi
    @PostMapping("/createLanguage")
    public String createLanguages(@ModelAttribute("languages") Languages_DB languagesDb) {
        languagesService.createLanguages(languagesDb);
        return "redirect:/admin"; // Başarıyla oluşturulduktan sonra listeye yönlendirir
    }
    //Delete İşlemi
    @PostMapping("/deleteLanguages/{id}")
    public String deleteSkill(@PathVariable("id") int id) {
        languagesService.deleteLanguages(id);
        return "redirect:/admin";
    }
    //Update Sayfası
    @GetMapping("/updateLanguages/{id}")
    public String editItem(@PathVariable("id") int id, Model model) {
        Languages_DB item = languagesService.getLanguagesId(id);
        model.addAttribute("admin_languages", item);
        return "admin/table_languages/UpdateLanguage";
    }
    //Update Islemi
    @PostMapping("/updateLanguages")
    public String updateItem(Languages_DB item) {
        languagesService.updateLanguages(item);
        return "redirect:/admin";
    }
}
