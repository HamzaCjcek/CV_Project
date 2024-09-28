package project.cv.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.cv.Database.Education_DB;
import project.cv.Database.Languages_DB;
import project.cv.Database.References_DB;
import project.cv.Repository.Languages_RS;
import project.cv.Repository.References_RS;

import java.util.List;

@Service
public class References_Service {
    @Autowired
    private References_RS referencesRs;
    public List<References_DB> getAllReferences() {
        return referencesRs.findAll();
    }
    public References_DB getReferencesId(int id) {
        return referencesRs.findById(id).orElseThrow(() -> new RuntimeException("Skill not found"));
    }
    public void updateReferences(References_DB references) {
        referencesRs.save(references);
    }
}
