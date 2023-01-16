package com.honda.service;

import com.honda.FactoryUtil;
import com.honda.entity.Category;
import com.honda.exception.CategoryException;
import com.honda.model.CategoryModel;
import com.honda.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private FactoryUtil factoryUtil;

    public List<CategoryModel> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(category ->
                factoryUtil.convertToCategoryModel(category)).collect(Collectors.toList());
    }

    public void delete(Integer cid) {
        Category category = findByID(cid);
        categoryRepository.delete(category);
    }

    public CategoryModel save(CategoryModel categoryModel) {
        Category savedCategory =  categoryRepository.save(factoryUtil.convertToCategory(categoryModel));
        return factoryUtil.convertToCategoryModel(savedCategory);
    }

    public CategoryModel update(Integer cid) {
        Category category = findByID(cid);
        categoryRepository.save(category);
        return factoryUtil.convertToCategoryModel(category);
    }

    public Category findByID(Integer cid) {
        Category category = categoryRepository.findById(cid).orElseThrow(
                () -> new CategoryException("category not available")
        );
        return  category;
    }
}
