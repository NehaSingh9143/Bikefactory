package com.honda.web;

import com.honda.entity.Category;
import com.honda.model.CategoryModel;
import com.honda.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cat")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Object> getAllCategories() {

        return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> save(@RequestBody CategoryModel categoryModel) {
        categoryService.save(categoryModel);
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestParam Integer cid) {
        categoryService.update(cid);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam Integer cid) {
        categoryService.delete(cid);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.NO_CONTENT);
    }
}
