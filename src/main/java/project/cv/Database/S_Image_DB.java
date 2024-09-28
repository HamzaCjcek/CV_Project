package project.cv.Database;

import jakarta.persistence.*;

@Entity
@Table(name = "sertifika_images")
public class S_Image_DB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idimages" )
    private Long id;

    @Column(name = "image_name")
    private String imageName;
    @Column(name = "sertifika_name")
    private String sertifikaName;
    @Column(name = "sertifika_aciklama")
    private String sertifikaDescription;
    @Column(name = "sertifika_url")
    private String sertifikaUrl;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getSertifikaName() {
        return sertifikaName;
    }

    public void setSertifikaName(String sertifikaName) {
        this.sertifikaName = sertifikaName;
    }

    public String getSertifikaDescription() {
        return sertifikaDescription;
    }

    public void setSertifikaDescription(String sertifikaDescription) {
        this.sertifikaDescription = sertifikaDescription;
    }

    public String getSertifikaUrl() {
        return sertifikaUrl;
    }

    public void setSertifikaUrl(String sertifikaUrl) {
        this.sertifikaUrl = sertifikaUrl;
    }
}
