package project.cv.Database;

import jakarta.persistence.*;

@Entity
@Table(name="skill")
public class Skill_DB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idskill")
    private int ID;
    @Column(name = "name", length = 255)
    private String NAME;
    @Column(name = "level")
    private int LEVEL;

    public Skill_DB(int ID, String NAME, int LEVEL) {
        this.ID = ID;
        this.NAME = NAME;
        this.LEVEL = LEVEL;
    }

    public Skill_DB() {
    }

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
