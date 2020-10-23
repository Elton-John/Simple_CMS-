package app.authors;

import app.model.Author;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/author")
public class AuthorController {
    private AuthorRepository authorRepository;

    @GetMapping("/list")
    public String showAllAuthors(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "authors";
    }

    @GetMapping("/add")
    public String showAddAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "authorForm";
    }

    @PostMapping("/add")
    public String addAuthor(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "authorForm";
        }
        authorRepository.save(author);
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String editAuthor(@PathVariable Long id, Model model) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        optionalAuthor.ifPresent(author -> model.addAttribute("author", author));
        return "authorForm";
    }

    @GetMapping("/confirm/{id}")
    public String confirmDeletingAuthor(@PathVariable Long id, Model model) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        optionalAuthor.ifPresent(author -> model.addAttribute("name", author.getLastName()));
        model.addAttribute("id", id);
        return "authorConfirmDeleting";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        optionalAuthor.ifPresent(author -> authorRepository.delete(author));
        return "redirect:/author/list";
    }


}
