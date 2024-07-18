package com.bulk.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bulk.service.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
