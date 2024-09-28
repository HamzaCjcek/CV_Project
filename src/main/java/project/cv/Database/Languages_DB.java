package project.cv.Database;

import jakarta.persistence.*;

@Entity
@Table(name = "languages")
public class Languages_DB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlanguages")
    private int ID;
    @Column(name = "name")
    private String NAME;
    @Column(name="level")
    private int LEVEL;
    // getters and setters

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

    public int getLEVEL() {
        return LEVEL;
    }

    public void setLEVEL(int LEVEL) {
        this.LEVEL = LEVEL;
    }
}
