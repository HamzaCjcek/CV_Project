package project.cv.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.cv.Database.S_Image_DB;
import project.cv.Repository.S_Image_RS;

import java.util.List;

@Service
public class S_Image_Service {
    @Autowired
    private S_Image_RS imageRepository;

    // Tüm Resimleri Getir
    public List<S_Image_DB> getAllImages() {
        return imageRepository.findAll();
    }

    public S_Image_DB findImageById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    public void save(S_Image_DB image) {
        imageRepository.save(image);
    }
}
