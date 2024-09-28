package project.cv.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import project.cv.Database.Profil_Image_DB;
import project.cv.Repository.Profil_Image_RS;
import project.cv.Service.Profil_Image_Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class Profile_Controller {

    @Autowired
    private Profil_Image_Service imageService;
    @Autowired
    private Profil_Image_RS profilImageRs;
    @GetMapping("/admin/profile")
    public String showFirstImage(Model model) {
        Profil_Image_DB firstImage = imageService.getFirstImage();
        model.addAttribute("firstImage", firstImage);
        return "admin/pages/profile"; // Thymeleaf veya başka bir şablon adı
    }
    @PostMapping("/admin/profile/{id}")
    public String updateImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            imageService.updateImage(id, file);
        } catch (IOException e) {
            e.printStackTrace();
            // Hata yönetimi ekleyebilirsiniz
        }
        return "redirect:/admin/profile"; // Güncellemeden sonra yönlendirme
    }

}
