package com.honda.service;

import com.honda.FactoryUtil;
import com.honda.entity.Bike;
import com.honda.exception.BikeException;
import com.honda.model.BikeModel;
import com.honda.repo.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private FactoryUtil factoryUtil;

    public List<BikeModel> getAllBikes(Integer id) {
        List<Bike> bikes = new ArrayList<>();
        if(id != null){
            Bike bike = getByBikeId(id);
            bikes.add(bike);
            return bikes.stream().map(b ->
                    factoryUtil.convertToBikeModel(b)).collect(Collectors.toList());
        }
        bikes = bikeRepository.findAll();
        return bikes.stream().map(bike ->
                factoryUtil.convertToBikeModel(bike)).collect(Collectors.toList());
    }

    public BikeModel addBike(BikeModel bikeModel) {
        Bike bike = factoryUtil.convertToBike(bikeModel);
        bikeRepository.save(bike);
        return bikeModel;
    }

    public void deleteBike(Integer id) {
        Bike bike = getByBikeId(id);
         bikeRepository.delete(bike);
    }

    public BikeModel updateBike(Integer id) {
        Bike bike = getByBikeId(id);
        Bike updatedBike = bikeRepository.save(bike);
        return factoryUtil.convertToBikeModel(updatedBike);
    }

    public Bike getByBikeId(Integer id) {
        return bikeRepository.findById(id).orElseThrow(
                () -> new BikeException("Bike Not Available")
        );
    }
}
