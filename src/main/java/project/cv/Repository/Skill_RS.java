package project.cv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cv.Database.Skill_DB;

public interface Skill_RS extends JpaRepository<Skill_DB,Integer> {}
