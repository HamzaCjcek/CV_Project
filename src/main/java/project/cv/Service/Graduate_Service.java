package project.cv.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.cv.Database.Education_DB;
import project.cv.Database.Graduate_DB;
import project.cv.Repository.Graduate_RS;

import java.util.List;
@Service
public class Graduate_Service {
    @Autowired
    private Graduate_RS graduateRs;
    public List<Graduate_DB> getAllGraduate() {
        return graduateRs.findAll();
    }
    public Graduate_DB getGraduate(int id) {
        return graduateRs.findById(id).orElseThrow(() -> new RuntimeException("Skill not found"));
    }
    public void updateGraduate(Graduate_DB graduateDb) {
        graduateRs.save(graduateDb);
    }
}
