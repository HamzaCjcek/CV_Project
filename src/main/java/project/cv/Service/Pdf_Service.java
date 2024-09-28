package project.cv.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.cv.Database.Pdf_DB;
import project.cv.Repository.Pdf_RS;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class Pdf_Service {
    @Autowired
    private Pdf_RS pdfRp;


    // Tüm PDF'leri Getir
    public List<Pdf_DB> getAllPdf() {
        return pdfRp.findAll();
    }

    public Pdf_DB findPdfById(int id) {
        return pdfRp.findById(id).orElse(null);
    }

    public void save(Pdf_DB pdf) {
        pdfRp.save(pdf);
    }

    public void deleteById(int id) {
        pdfRp.deleteById(id);
    }


}
