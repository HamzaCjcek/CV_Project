package project.cv.Database;

import jakarta.persistence.*;

@Entity
@Table(name = "experience_table")
public class Experience_DB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idexperience")
    private int ID;
    @Column(name = "name", length = 255)
    private String NAME;
    @Column(name = "year", length = 255)
    private String YEAR;
    @Column(name = "city", length = 255)
    private String CITY;
    @Column(name ="explanation", length = 255)
    private String EXPLANATION;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR(String YEAR) {
        this.YEAR = YEAR;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getEXPLANATION() {
        return EXPLANATION;
    }

    public void setEXPLANATION(String EXPLANATION) {
        this.EXPLANATION = EXPLANATION;
    }
}
