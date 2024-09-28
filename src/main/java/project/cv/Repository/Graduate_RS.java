package project.cv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cv.Database.Graduate_DB;

public interface Graduate_RS extends JpaRepository<Graduate_DB,Integer> {
}
