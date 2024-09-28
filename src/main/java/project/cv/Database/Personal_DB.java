package project.cv.Database;

import jakarta.persistence.*;

@Entity
@Table(name = "personal")
public class Personal_DB {
    @Id
    @Column(name = "idpersonal")
    private int ID;
    @Column(name = "name", length = 255)
    private String NAME;
    @Column(name = "surname", length = 255)
    private String SURNAME;
    @Column(name = "age")
    private int AGE;
    @Column(name = "job", length = 255)
    private String JOB;
    @Column(name = "about", length = 255)
    private String ABOUT;
    @Column(name = "phone", length = 255)
    private String PHONE;
    @Column(name = "email", length = 255)
    private String EMAIL;
    @Column(name = "address", length = 255)
    private String ADDRESS;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setSURNAME(String SURNAME) {
        this.SURNAME = SURNAME;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public void setJOB(String JOB) {
        this.JOB = JOB;
    }

    public void setABOUT(String ABOUT) {
        this.ABOUT = ABOUT;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public int getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public int getAGE() {
        return AGE;
    }

    public String getJOB() {
        return JOB;
    }

    public String getABOUT() {
        return ABOUT;
    }

    public String getPHONE() {
        return PHONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getADDRESS() {
        return ADDRESS;
    }
}
