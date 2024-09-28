package project.cv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.cv.Database.Profil_Image_DB;
@Repository
public interface Profil_Image_RS extends JpaRepository<Profil_Image_DB,Long> {
    @Query(value = "SELECT p FROM Profil_Image_DB p ORDER BY p.id ASC")
    Profil_Image_DB findFirstByOrderByIdAsc();
}
