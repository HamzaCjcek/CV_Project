package project.cv.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.cv.Database.Experience_DB;
import project.cv.Database.Skill_DB;
import project.cv.Repository.Experience_RS;

import java.util.List;

@Service
public class Experience_Service {
    @Autowired
    private Experience_RS experienceRs;
    public List<Experience_DB> getAllExperience() {
        return experienceRs.findAll();
    }
    public Experience_DB getExperienceId(int id) {
        return experienceRs.findById(id).orElseThrow(() -> new RuntimeException("Skill not found"));
    }
    public void updateExperience(Experience_DB experienceDb) {
        experienceRs.save(experienceDb);
    }


}
