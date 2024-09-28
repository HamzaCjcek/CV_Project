package project.cv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cv.Database.References_DB;

public interface References_RS extends JpaRepository<References_DB,Integer> {
}
