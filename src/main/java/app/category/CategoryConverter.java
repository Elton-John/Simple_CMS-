package app.category;

import app.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class CategoryConverter implements Converter<String, Category> {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category convert(String s) {
        return categoryRepository.findById(Long.parseLong(s)).get();
    }
}
