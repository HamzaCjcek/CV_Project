package project.cv.Database;

import jakarta.persistence.*;

@Entity
@Table(name = "project_image")
public class P_Image_DB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idimage" )
    private Long id;

    @Column(name = "image_name")
    private String imageName;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "project_aciklamasi")
    private String projectDescription;
    @Column(name = "project_url")
    private String projectUrl;

    // Getter ve Setter metodları


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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }
}
