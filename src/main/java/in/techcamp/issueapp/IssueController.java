package in.techcamp.issueapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IssueController {
    //投稿機能
    @GetMapping("/issueForm")
    public String showIssueForm(@ModelAttribute("issueForm") IssueForm form){
        return "issueForm";
    }
}
