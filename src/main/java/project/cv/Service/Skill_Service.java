package project.cv.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.cv.Database.Skill_DB;
import project.cv.Repository.Skill_RS;

import java.util.List;

@Service
public class Skill_Service {
    @Autowired
    private Skill_RS skillRepository;
    public List<Skill_DB> getAllSkills() {
        return skillRepository.findAll();
    }
    public void deleteSkill(int id) {
        skillRepository.deleteById(id);
    }
    public void updateSkill(Skill_DB skill) {
        skillRepository.save(skill);
    }
    public void createSkill(Skill_DB skill) {
        skillRepository.save(skill);
    }
    public Skill_DB getSkillById(int id) {
        return skillRepository.findById(id).orElseThrow(() -> new RuntimeException("Skill not found"));
    }
}
