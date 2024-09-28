package project.cv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cv.Database.Personal_DB;

public interface Personal_RS extends JpaRepository<Personal_DB,Integer> {}
