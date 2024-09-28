package project.cv.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.cv.Database.Forum_DB;
import project.cv.Repository.Forum_RS;

import java.util.List;

@Service
public class Forum_Service {
    @Autowired
    private Forum_RS forumRs;

    public void ForumChat(Forum_DB forum) {
        forumRs.save(forum);
    }
    public List<Forum_DB> getForum()
    {
        return forumRs.findAll();
    }
    public void deleteById(Long id) {
        forumRs.deleteById(id); // Delete the forum by ID
    }

}
