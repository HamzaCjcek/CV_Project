package project.cv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cv.Database.Languages_DB;

public interface Languages_RS extends JpaRepository<Languages_DB,Integer> {}
