package project.cv.Database;

import jakarta.persistence.*;

@Entity
@Table(name = "forum")
public class Forum_DB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idforum")
    private Long id;
    @Column(name = "forum_name")
    private String forumName;
    @Column(name = "forum_email")
    private String ForumEmail;
    @Column(name = "forum_chat")
    private String forumChat;
    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public String getForumEmail() {
        return ForumEmail;
    }

    public void setForumEmail(String forumEmail) {
        ForumEmail = forumEmail;
    }

    public String getForumChat() {
        return forumChat;
    }

    public void setForumChat(String forumChat) {
        this.forumChat = forumChat;
    }
}
