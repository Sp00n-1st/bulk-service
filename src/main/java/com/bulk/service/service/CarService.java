package com.bulk.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.bulk.service.model.Car;
import com.bulk.service.repository.CarRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Async
    @Transactional
    public void saveCarBatch(List<Car> request) {
        try {
            log.info("Start Save Car Operation...");
            carRepository.saveAll(request);
            log.info("End Save Car Operation...");
        } catch (Exception ex) {
            log.error("Failed Save Car Batch");
            log.info(ex.getMessage());
        }
    }

    public void checkCarId(List<Car> request) {
        try {
            for (Car car : request) {
                if (car.getCarId() == 0 || car.getCarId() == null) {
                    throw new RuntimeException("Car Id Cannot Be Empty");
                }
            }
        } catch (Exception ex) {
            log.info(ex.getMessage());
            throw ex;
        }
    }

    @Async
    @Transactional
    public void updateCarBatch(List<Car> request) {
        try {
            log.info("Start Update Car Operation...");
            carRepository.saveAll(request);
            log.info("End Update Car Operation...");
        } catch (Exception ex) {
            log.error("Failed Update Car Batch");
            log.info(ex.getMessage());
        }
    }

    @Async
    @Transactional
    public void deleteBatch(List<Long> ids) {
        try {
            log.info("Start Delete Car Operation...");
            carRepository.deleteAllById(ids);
            log.info("End Delete Car Operation...");
        } catch (Exception ex) {
            log.error("Failed Delete Car Batch");
            log.info(ex.getMessage());
        }
    }
}
