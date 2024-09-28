package project.cv.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.cv.Database.P_Image_DB;
import project.cv.Repository.P_Image_RS;
import java.util.List;

@Service
public class P_Image_Service {
    @Autowired
    private P_Image_RS imageRepository;

    // Tüm Resimleri Getir
    public List<P_Image_DB> getAllImages() {
        return imageRepository.findAll();
    }

    public P_Image_DB findImageById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    public void save(P_Image_DB image) {
        imageRepository.save(image);
    }
}
