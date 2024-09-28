package project.cv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cv.Database.Forum_DB;

@Repository
public interface Forum_RS extends JpaRepository<Forum_DB,Long> {
}
