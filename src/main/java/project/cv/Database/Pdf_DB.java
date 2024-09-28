package project.cv.Database;

import jakarta.persistence.*;

@Entity
@Table(name = "pdf")
public class Pdf_DB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpdf")
    private int id;

    @Column(name = "pdf_name")
    private String pdfName;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }
}
