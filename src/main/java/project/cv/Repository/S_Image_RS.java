package project.cv.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cv.Database.S_Image_DB;
@Repository
public interface S_Image_RS extends JpaRepository<S_Image_DB,Long> {
}
