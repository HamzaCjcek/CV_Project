package project.cv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cv.Database.P_Image_DB;
@Repository
public interface P_Image_RS extends JpaRepository<P_Image_DB,Long> {
}
