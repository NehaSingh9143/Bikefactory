package com.honda;

import com.honda.entity.Bike;
import com.honda.entity.Category;
import com.honda.model.BikeModel;
import com.honda.model.CategoryModel;
import org.springframework.stereotype.Component;

@Component
public class FactoryUtil {

    public Category convertToCategory(CategoryModel categoryModel){
        Category category = new Category();
        if(null != categoryModel){
            category.setName(categoryModel.getName());
        }
        return category;
    }

    public CategoryModel convertToCategoryModel(Category category){
        CategoryModel categoryModel = new CategoryModel();
        if(null != category){
            categoryModel.setName(category.getName());
        }
        return categoryModel;
    }

    public Bike convertToBike(BikeModel bikeModel){
        Bike bike = new Bike();
        if(null != bikeModel){
           bike.setName(bikeModel.getName());
           bike.setEngineCC(bikeModel.getEngineCC());
           bike.setMilege(bikeModel.getMilege());
           bike.setPrice(bikeModel.getPrice());
        }
        return bike;
    }

    public BikeModel convertToBikeModel(Bike bike){
        BikeModel bikeModel = new BikeModel();
        if(null != bike){
            bikeModel.setName(bike.getName());
            bikeModel.setEngineCC(bike.getEngineCC());
            bikeModel.setMilege(bike.getMilege());
            bikeModel.setPrice(bike.getPrice());
        }
        return bikeModel;
    }
}
