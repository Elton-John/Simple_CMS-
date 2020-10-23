package app.articles;

import app.authors.AuthorRepository;
import app.category.CategoryRepository;
import app.model.Article;
import app.model.Author;
import app.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/article")
public class ArticleController {
       private ArticleRepository articleRepository;
       private AuthorRepository authorRepository;
       private CategoryRepository categoryRepository;

    @GetMapping("/list")
    public String showAllArticles(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "articles";
    }

    @GetMapping("/add")
    public String showAddArticleForm(Model model) {
        model.addAttribute("article", new Article());
        model.addAttribute("authors");
        model.addAttribute("categories");
        return "articleForm";
    }

    @PostMapping("/add")
    public String addArticle(@Valid Article article, BindingResult result) {
        if (result.hasErrors()){
            return "articleForm";
        }
        articleRepository.save(article);
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String editArticle(@PathVariable Long id, Model model) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        optionalArticle.ifPresent(article -> model.addAttribute("article", article));
        return "articleForm";
    }

    @GetMapping("/confirm/{id}")
    public String confirmDeletingArticle(@PathVariable Long id, Model model) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        optionalArticle.ifPresent(article -> model.addAttribute("name", article.getTitle()));
        model.addAttribute("id", id);
        return "articleConfirmDeleting";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        optionalArticle.ifPresent(article -> articleRepository.delete(article));
        return "redirect:/article/list";
    }
    @ModelAttribute("authors")
    public List<Author> authors(){
        return authorRepository.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryRepository.findAll();
    }
}
