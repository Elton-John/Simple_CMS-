package app.home;

import app.articles.ArticleRepository;
import app.model.Article;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/home")
public class HomePageController {
    private final ArticleRepository articleRepository;

    @GetMapping
    public String homePage(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "home";
    }
}
