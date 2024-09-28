package project.cv.Database;

import jakarta.persistence.*;

@Entity
@Table(name = "profil_image")
public class Profil_Image_DB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprofil_image" )
    private Long id;
    @Column(name = "imagename")
    private String imageName;

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
}
