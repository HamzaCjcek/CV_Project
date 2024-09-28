package project.cv.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.cv.Database.Pdf_DB;
import project.cv.Database.Profil_Image_DB;
import project.cv.Repository.Pdf_RS;
import project.cv.Service.Pdf_Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
public class Pdf_Controller {
    @Autowired
    private Pdf_RS pdfRepository;

    @GetMapping("/downloadPdf/{id}")
    public ResponseEntity<Resource> downloadPdf(@PathVariable("id") int id) {
        Optional<Pdf_DB> pdfOptional = pdfRepository.findById(id);
        if (pdfOptional.isPresent()) {
            Pdf_DB pdf = pdfOptional.get();
            Path filePath = Paths.get("src/main/resources/static/index/pdf/" + pdf.getPdfName());

            try {
                // Dosyayı okuyun
                Resource resource = new UrlResource(filePath.toUri());
                if (resource.exists() || resource.isReadable()) {
                    // HTTP yanıtını döndürün
                    return ResponseEntity.ok()
                            .contentType(MediaType.APPLICATION_PDF)
                            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pdf.getPdfName() + "\"")
                            .body(resource);
                } else {
                    throw new RuntimeException("Dosya okunamaz");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Dosya bulunamadı");
            }
        } else {
            throw new RuntimeException("PDF bulunamadı");
        }
    }

    // PDF'leri göster
    @GetMapping("/admin/pdf")
    public String showPDFs(Model model) {
        List<Pdf_DB> pdfs = pdfRepository.findAll();
        model.addAttribute("pdfs", pdfs);
        return "admin/pages/pdf"; // PDF'ler için Thymeleaf şablon adı
    }


    @PostMapping("/updatePdf/{id}")
    public String updatePdf(@PathVariable("id") int id, @RequestParam("pdf") MultipartFile file) {
        Optional<Pdf_DB> pdfOptional = pdfRepository.findById(id);
        if (pdfOptional.isPresent()) {
            Pdf_DB pdf = pdfOptional.get();

            // Eski dosyayı sil
            Path oldFilePath = Paths.get("src/main/resources/static/index/pdf/" + pdf.getPdfName());
            try {
                Files.deleteIfExists(oldFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Yeni dosyayı kaydet
            String newFileName = file.getOriginalFilename();
            Path newFilePath = Paths.get("src/main/resources/static/index/pdf/" + newFileName);
            try {
                Files.copy(file.getInputStream(), newFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Veritabanındaki PDF'yi güncelle
            pdf.setPdfName(newFileName);
            pdfRepository.save(pdf);
        }
        return "redirect:/admin/pdf";
    }

}
