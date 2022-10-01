package in.techcamp.issueapp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class IssueController {
    private final IssueRepository issueRepository;

    //投稿機能
    @GetMapping("/issueForm")
    //IssueForm()メソッド
    public String showIssueForm(@ModelAttribute("issueForm") IssueForm form){

        return "issueForm";
    }
    @PostMapping("/issues")
    public String createIssue(IssueForm form){
        issueRepository.insert(form.getTitle(), form.getContent(), form.getPeriod(), form.getImportance());
        return "redirect:/";
    }

    //一覧機能
    @GetMapping
    public String showIssueList(Model model){
        var issueList = issueRepository.findAll();
        model.addAttribute("issueList", issueList);
        return "index";
    }
}

