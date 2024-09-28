package project.cv.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.cv.Database.*;
import project.cv.Service.*;
import java.util.List;

@Controller
public class Index_Controller {
    protected final Skill_Service skillService;
    protected final Languages_Service languageService;
    protected final Personal_Service personalService;
    protected final References_Service referencesService;
    protected final Education_Service educationService;
    protected final Graduate_Service graduateService;
    protected final Experience_Service experienceService;
    protected final P_Image_Service imageService;
    protected final S_Image_Service sImageService;
    protected final Profil_Image_Service profilImageService;
    protected final Pdf_Service pdf_Service;
    protected final Forum_Service forumService;

    @Autowired
    // Constructor injection for Skill_Service object
    public Index_Controller(Skill_Service skillService, Languages_Service languageService, Personal_Service personalService, References_Service referencesService, Education_Service educationService, Graduate_Service graduateService, Experience_Service experienceService, P_Image_Service imageService, S_Image_Service sImageService, Profil_Image_Service profilImageService, Pdf_Service pdf_Service, Forum_Service forumService) {
        this.skillService = skillService;
        this.languageService = languageService;
        this.personalService = personalService;
        this.referencesService = referencesService;
        this.educationService = educationService;
        this.graduateService = graduateService;
        this.experienceService = experienceService;
        this.imageService = imageService;
        this.sImageService = sImageService;
        this.profilImageService = profilImageService;
        this.pdf_Service = pdf_Service;
        this.forumService = forumService;
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllSkills(Model model) {
        List<Skill_DB> skills = skillService.getAllSkills();
        List<Languages_DB> languages = languageService.getAllLanguages();
        List<References_DB> references = referencesService.getAllReferences();
        List<Education_DB> educations = educationService.getAllEducation();
        List<Graduate_DB> graduates = graduateService.getAllGraduate();
        List<Experience_DB> experiences = experienceService.getAllExperience();
        Personal_DB personal =personalService.getFirstPersonel();
        List<P_Image_DB> images = imageService.getAllImages();
        List<S_Image_DB> s_images = sImageService.getAllImages();
        Profil_Image_DB firstImage = profilImageService.getFirstImage();
        List<Pdf_DB> pdfDbs=pdf_Service.getAllPdf();
        model.addAttribute("forum", new Forum_DB());
        model.addAttribute("skills", skills);
        model.addAttribute("languages", languages);
        model.addAttribute("personal", personal);
        model.addAttribute("references", references);
        model.addAttribute("educations", educations);
        model.addAttribute("graduates", graduates);
        model.addAttribute("experiences", experiences);
        model.addAttribute("images", images);
        model.addAttribute("s_image_dbList", s_images);
        model.addAttribute("profile_images", firstImage);
        model.addAttribute("dosyalar",pdfDbs);
        return "index/index";
    }



}
