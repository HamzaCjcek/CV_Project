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
import project.cv.Database.P_Image_DB;
import project.cv.Database.S_Image_DB;
import project.cv.Repository.P_Image_RS;
import project.cv.Repository.S_Image_RS;
import project.cv.Service.P_Image_Service;
import project.cv.Service.S_Image_Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class Image_Controller {
    @Autowired
    private S_Image_RS sImageRs;
    @Autowired
    private S_Image_Service sImageService;
    @Autowired
    private P_Image_RS imageRepository;
    @Autowired
    private P_Image_Service imageService;
    // Project İmage Started
    @GetMapping("/admin/picture")
    public String showImages(Model model) {
        List<P_Image_DB> images = imageRepository.findAll();
        List<S_Image_DB> s_image_dbList= sImageRs.findAll();
        model.addAttribute("images", images);
        model.addAttribute("s_image_dbList",s_image_dbList);
        return "admin/pages/picture"; // Thymeleaf template name
    }
    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Dosya ismini al
                String fileName = file.getOriginalFilename();

                // Dosyayı belirli bir klasöre kaydet (örneğin: /uploads)
                Path uploadPath = Paths.get("src/main/resources/static/index/images/" + fileName);
                Files.write(uploadPath, file.getBytes());

                // Veritabanına sadece dosya ismini kaydet
                P_Image_DB image = new P_Image_DB();
                image.setImageName(fileName);
                imageRepository.save(image);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/admin/picture";  // Yükleme sonrası bir sayfaya yönlendirme
    }
    @PostMapping("/deleteImage/{id}")
    public String deleteImage(@PathVariable("id") Long id) {
        // Veritabanındaki resmi bul
        Optional<P_Image_DB> imageOpt = imageRepository.findById(id);
        if (imageOpt.isPresent()) {
            P_Image_DB image = imageOpt.get();

            // Sunucudaki dosyayı sil
            Path imagePath = Paths.get("src/main/resources/static/index/images/" + image.getImageName());
            try {
                Files.deleteIfExists(imagePath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Veritabanından kaydı sil
            imageRepository.delete(image);
        }

        return "redirect:/admin/picture";
    }
    @PostMapping("/resim-guncelle/{id}")
    public String updateImage(@PathVariable Long id, @RequestParam("image") MultipartFile file, Model model) throws IOException {
        // 1. Mevcut resmi bul
        P_Image_DB existingImage = imageService.findImageById(id);
        if (existingImage != null) {
            // 2. Mevcut resmi dosya sisteminden sil
            Path existingImagePath = Paths.get("src/main/resources/static/index/images/" + existingImage.getImageName());
            Files.deleteIfExists(existingImagePath);

            // 3. Yeni resmi yükle ve dosya sistemine kaydet
            String newFileName = file.getOriginalFilename();
            Path newImagePath = Paths.get("src/main/resources/static/index/images/" + newFileName);
            Files.copy(file.getInputStream(), newImagePath);

            // 4. Veritabanında güncelleme
            existingImage.setImageName(newFileName);
            imageService.save(existingImage); // Veritabanında güncellenmiş resmi kaydet
        }
        return "redirect:/admin/picture"; // Güncelleme sonrası resim listesini döndür
    }

    @PostMapping("/updateProject/{id}")
    public String updateProject(@PathVariable Long id,
                                @RequestParam("projectName") String projectName,
                                @RequestParam("projectDescription") String projectDescription,
                                @RequestParam("projectUrl") String projectUrl) {
        Optional<P_Image_DB> imageOpt = imageRepository.findById(id);
        if (imageOpt.isPresent()) {
            P_Image_DB image = imageOpt.get();
            image.setProjectName(projectName);
            image.setProjectDescription(projectDescription);
            image.setProjectUrl(projectUrl); // Update the project URL
            imageRepository.save(image); // Save updated project data
        }
        return "redirect:/admin/picture"; // Redirect after update
    }

    // Project İmage Ended

    // Sertifika İmage Started
    @PostMapping("/uploadImageSertifika")
    public String uploadImageSertifika(@RequestParam("imageFileSertifika") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Dosya ismini al
                String fileName = file.getOriginalFilename();

                // Dosyayı belirli bir klasöre kaydet (örneğin: /uploads)
                Path uploadPath = Paths.get("src/main/resources/static/index/images/" + fileName);
                Files.write(uploadPath, file.getBytes());

                // Veritabanına sadece dosya ismini kaydet
                S_Image_DB image = new S_Image_DB();
                image.setImageName(fileName);
                sImageRs.save(image);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/admin/picture";  // Yükleme sonrası bir sayfaya yönlendirme
    }
    @PostMapping("/deleteImageSertifika/{id}")
    public String deleteImageSertifika(@PathVariable("id") Long id) {
        // Veritabanındaki resmi bul
        Optional<S_Image_DB> imageOpt = sImageRs.findById(id);
        if (imageOpt.isPresent()) {
            S_Image_DB image = imageOpt.get();

            // Sunucudaki dosyayı sil
            Path imagePath = Paths.get("src/main/resources/static/index/images/" + image.getImageName());
            try {
                Files.deleteIfExists(imagePath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Veritabanından kaydı sil
            sImageRs.delete(image);
        }

        return "redirect:/admin/picture";
    }
    @PostMapping("/resim-guncelleSertifika/{id}")
    public String updateImageSertifika(@PathVariable Long id, @RequestParam("image") MultipartFile file, Model model) throws IOException {
        // 1. Mevcut resmi bul
        S_Image_DB existingImage = sImageService.findImageById(id);
        if (existingImage != null) {
            // 2. Mevcut resmi dosya sisteminden sil
            Path existingImagePath = Paths.get("src/main/resources/static/index/images/" + existingImage.getImageName());
            Files.deleteIfExists(existingImagePath);

            // 3. Yeni resmi yükle ve dosya sistemine kaydet
            String newFileName = file.getOriginalFilename();
            Path newImagePath = Paths.get("src/main/resources/static/index/images/" + newFileName);
            Files.copy(file.getInputStream(), newImagePath);

            // 4. Veritabanında güncelleme
            existingImage.setImageName(newFileName);
            sImageRs.save(existingImage); // Veritabanında güncellenmiş resmi kaydet
        }
        return "redirect:/admin/picture"; // Güncelleme sonrası resim listesini döndür
    }
    @PostMapping("/updateSertifika/{id}")
    public String updateSertifika(@PathVariable Long id,
                                @RequestParam("sertifikaName") String sertifikaName,
                                @RequestParam("sertifikaDescription") String sertifikaDescription,
                                @RequestParam("sertifikaUrl") String sertifikaUrl) {
        Optional<S_Image_DB> imageOpt = sImageRs.findById(id);
        if (imageOpt.isPresent()) {
            S_Image_DB image = imageOpt.get();
            image.setImageName(sertifikaName);
            image.setSertifikaDescription(sertifikaDescription);
            image.setSertifikaUrl(sertifikaUrl); // Update the project URL
            sImageRs.save(image); // Save updated project data
        }
        return "redirect:/admin/picture"; // Redirect after update
    }
    // Sertifika İmage Ended

}

