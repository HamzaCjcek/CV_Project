package project.cv.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.cv.Database.Languages_DB;
import project.cv.Database.Skill_DB;
import project.cv.Repository.Languages_RS;

import java.util.List;

@Service
public class Languages_Service {
    @Autowired
    private Languages_RS languagesRs;
    public List<Languages_DB> getAllLanguages() {
        return languagesRs.findAll();
    }
    public void deleteLanguages(int id) {
        languagesRs.deleteById(id);
    }
    public void updateLanguages(Languages_DB languages) {
        languagesRs.save(languages);
    }
    public Languages_DB getLanguagesId(int id) {
        return languagesRs.findById(id).orElseThrow(() -> new RuntimeException("Skill not found"));
    }
    public void createLanguages(Languages_DB languagesDb) {
        languagesRs.save(languagesDb);
    }


}
