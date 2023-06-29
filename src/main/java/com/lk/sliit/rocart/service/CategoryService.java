package com.lk.sliit.rocart.service;



import com.lk.sliit.rocart.model.Category;

import java.util.List;

public interface CategoryService {
    Category add(Category category);
    List<Category> getAll();
    List<Category> getByCategoryName(String categoryName);
}
