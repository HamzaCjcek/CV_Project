package project.cv.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.cv.Database.Personal_DB;
import project.cv.Repository.Personal_RS;

import java.util.Optional;

@Service
public class Personal_Service {
    @Autowired
    private Personal_RS repositoryPersonal;
    public Personal_DB getFirstPersonel() {
        Optional<Personal_DB> optionalPersonel = repositoryPersonal.findById(1);
        return optionalPersonel.orElse(null);
    }
    public void delete(int id) {
        repositoryPersonal.deleteById(id);
    }
    public void create(Personal_DB personal) {
        repositoryPersonal.save(personal);
    }
    public Personal_DB getByID(int id) {
        return repositoryPersonal.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));
    }

    public void update(Personal_DB item) {
        // Mevcut kaydı bul
        Personal_DB existingItem = repositoryPersonal.findById(item.getID())
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));

        // Alanları güncelle
        existingItem.setNAME(item.getNAME());
        existingItem.setSURNAME(item.getSURNAME());
        existingItem.setAGE(item.getAGE());
        existingItem.setJOB(item.getJOB());
        existingItem.setABOUT(item.getABOUT());
        existingItem.setPHONE(item.getPHONE());
        existingItem.setEMAIL(item.getEMAIL());
        existingItem.setADDRESS(item.getADDRESS());

        // Güncellenmiş kaydı kaydet
        repositoryPersonal.save(existingItem);
    }
}
