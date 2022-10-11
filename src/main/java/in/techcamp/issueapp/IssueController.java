package in.techcamp.issueapp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class IssueController {
    private final IssueRepository issueRepository;

    //投稿機能
    @GetMapping("/issueForm")
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

    //詳細画面
    @GetMapping("/issues/{id}")
    public String issueDetail(@PathVariable long id, Model model){
        var issue = issueRepository.findById(id);
        model.addAttribute("issue", issue);
        return "detail";
    }

    //編集機能
    @PostMapping("/issues/{id}/update")
    public String updateIssue(@PathVariable long id, IssueForm issueForm){
        issueRepository.update(id, issueForm.getTitle(), issueForm.getContent(), issueForm.getPeriod(), issueForm.getImportance());
        return "redirect:/";
    }

    //削除機能
    @PostMapping("issues/{id}/delete")
    public String deleteIssue(@PathVariable Long id) {
        issueRepository.deleteById(id);
        return "redirect:/";
    }
}


