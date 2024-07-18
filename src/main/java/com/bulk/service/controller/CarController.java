package com.bulk.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bulk.service.dto.SuccessResponse;
import com.bulk.service.dto.UpsertCarDTO;
import com.bulk.service.service.CarService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarController {
    private final CarService carService;

    @GetMapping
    public Object getCars() {
        return carService.getAll();
    }

    @PostMapping("/save-batch")
    public Object saveCarBatch(@RequestBody UpsertCarDTO request) {
        carService.saveCarBatch(request.getCar());
        return SuccessResponse.builder()
                .message("Succesfully Save Car Data On Background")
                .build();
    }

    @PutMapping("/update-batch")
    public Object updateCarBatch(@RequestBody UpsertCarDTO request) {
        carService.checkCarId(request.getCar());
        carService.updateCarBatch(request.getCar());
        return SuccessResponse.builder()
                .message("Succesfully Update Car Data On Background")
                .build();
    }

    @DeleteMapping("/delete-batch")
    public Object deleteCarBatch(@RequestBody List<Long> request) {
        carService.deleteBatch(request);
        return SuccessResponse.builder()
                .message("Succesfully Delete Car Data On Background")
                .build();
    }
}
