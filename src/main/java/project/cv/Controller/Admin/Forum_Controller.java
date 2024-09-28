package project.cv.Controller.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.cv.Database.Forum_DB;
import project.cv.Database.Pdf_DB;
import project.cv.Repository.Forum_RS;
import project.cv.Service.Forum_Service;

import java.util.List;


@Controller
public class Forum_Controller {
    @Autowired
    private Forum_Service forumService;
    @Autowired
    private Forum_RS forumRs;

    @GetMapping("/admin/forum")
    public String showForum(@RequestParam(defaultValue = "0") int page, Model model) {
        int size = 5; // Number of items per page
        Page<Forum_DB> forumPage = forumRs.findAll(PageRequest.of(page, size));

        model.addAttribute("forums", forumPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", forumPage.getTotalPages());

        return "admin/pages/forum"; // Thymeleaf template name
    }
    @PostMapping("/admin/forum/delete/{id}")
    public String deleteForum(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, RedirectAttributes redirectAttributes) {
        forumRs.deleteById(id); // Call the service method to delete the forum
        redirectAttributes.addFlashAttribute("successMessage", "Forum deleted successfully.");
        return "redirect:/admin/forum?page=" + page; // Redirect back to the forum list
    }

    // Create Forum
    @PostMapping("/forum")
    public ResponseEntity<Void> createForum(@ModelAttribute("forum") Forum_DB forum) {
        forumService.ForumChat(forum);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // No content response
    }

}
