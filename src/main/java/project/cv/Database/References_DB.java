package project.cv.Database;

import jakarta.persistence.*;

@Entity
@Table(name = "references_table")
public class References_DB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreferences")
    private int ID;
    @Column(name = "name",length = 255)
    private String NAME;
    @Column(name = "job", length = 255)
    private String JOB;
    @Column(name = "explanation",length = 255)
    private String EXPLANATION;

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

    public String getJOB() {
        return JOB;
    }

    public void setJOB(String JOB) {
        this.JOB = JOB;
    }

    public String getEXPLANATION() {
        return EXPLANATION;
    }

    public void setEXPLANATION(String EXPLANATION) {
        this.EXPLANATION = EXPLANATION;
    }
}
