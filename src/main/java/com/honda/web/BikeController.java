package com.honda.web;

import com.honda.entity.Bike;
import com.honda.model.BikeModel;
import com.honda.model.CategoryModel;
import com.honda.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping
    public ResponseEntity<Object> getAllAvailableBikes(@RequestParam(required = false , name = "id") Integer id) {
        return new ResponseEntity<>(bikeService.getAllBikes(id), HttpStatus.OK);

    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addBike(@RequestBody BikeModel bikeModel) {
        bikeService.addBike(bikeModel);
        return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> updateBike(@RequestParam Integer id) {
        bikeService.updateBike(id);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteBike(@RequestParam Integer id) {
        bikeService.deleteBike(id);
        return new ResponseEntity<>("Bike with bike ID :" + id + " deleted successfully", HttpStatus.NO_CONTENT);
    }
}
