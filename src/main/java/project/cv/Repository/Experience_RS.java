package project.cv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cv.Database.Experience_DB;

public interface Experience_RS extends JpaRepository<Experience_DB,Integer> {
}
