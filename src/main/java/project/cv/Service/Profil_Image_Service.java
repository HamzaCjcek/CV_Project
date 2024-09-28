package project.cv.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.cv.Database.Profil_Image_DB;
import project.cv.Repository.Profil_Image_RS;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;


@Service
public class Profil_Image_Service {
    @Autowired
    private Profil_Image_RS profileImageRepository;

    public List<Profil_Image_DB> getAllImages() {
        return profileImageRepository.findAll();
    }

    public Profil_Image_DB getFirstImage() {
        return profileImageRepository.findFirstByOrderByIdAsc();
    }


    private final String UPLOAD_DIR = "src/main/resources/static/index/profile_img/";

    public Profil_Image_DB updateImage(Long id, MultipartFile file) throws IOException {
        Profil_Image_DB existingImage = profileImageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));

        // Önceki dosyanın yolu
        String previousFileName = existingImage.getImageName();
        Path previousFilePath = Paths.get(UPLOAD_DIR + previousFileName);

        // Yeni dosyayı kaydet
        String newFileName = file.getOriginalFilename();
        Path newFilePath = Paths.get(UPLOAD_DIR + newFileName);
        Files.copy(file.getInputStream(), newFilePath, StandardCopyOption.REPLACE_EXISTING);

        // Önceki dosyayı sil
        if (Files.exists(previousFilePath)) {
            Files.delete(previousFilePath);
        }

        // Güncelle
        existingImage.setImageName(newFileName);
        return profileImageRepository.save(existingImage);
    }

}
