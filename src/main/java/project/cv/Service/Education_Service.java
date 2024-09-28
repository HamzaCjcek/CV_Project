package project.cv.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.cv.Database.Education_DB;
import project.cv.Database.Experience_DB;
import project.cv.Repository.Education_RS;

import java.util.List;

@Service
public class Education_Service {
    @Autowired
    private Education_RS educationRs;
    public List<Education_DB> getAllEducation() {
        return educationRs.findAll();
    }
    public Education_DB getEducationId(int id) {
        return educationRs.findById(id).orElseThrow(() -> new RuntimeException("Skill not found"));
    }
    public void updateEducation(Education_DB education) {
        educationRs.save(education);
    }
}
