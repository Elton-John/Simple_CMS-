package app.category;

import app.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private CategoryRepository categoryRepository;

    @GetMapping("/list")
    public String showAllCategories(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/add")
    public String showCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "categoryForm";
    }

    @PostMapping("/add")
    public String addCategory(@Valid  Category category, BindingResult result) {
        if (result.hasErrors()){
            return "categoryForm";
        }
        categoryRepository.save(category);
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Category> category = categoryRepository.findById(id);
        model.addAttribute("category", category);
        return "categoryForm";
    }

    @GetMapping("/confirm/{id}")
    public String confirmDeleting(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        optionalCategory.ifPresent(category -> {
            model.addAttribute("name", category.getName());
        });
        return "categoryConfirmDeleting";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        optionalCategory.ifPresent(category -> categoryRepository.delete(category));
        return "redirect:/category/list";
    }


}
