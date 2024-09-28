package project.cv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.cv.Database.Pdf_DB;

@Repository
public interface Pdf_RS extends JpaRepository<Pdf_DB,Integer> {

}
