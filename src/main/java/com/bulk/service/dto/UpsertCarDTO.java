package com.bulk.service.dto;

import java.util.List;

import com.bulk.service.model.Car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpsertCarDTO {
    private List<Car> car;
}
