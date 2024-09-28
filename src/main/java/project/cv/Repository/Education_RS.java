package project.cv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cv.Database.Education_DB;

public interface Education_RS extends JpaRepository<Education_DB,Integer> {
}
