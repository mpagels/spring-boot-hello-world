package de.mpagels.springboothelloworld;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Car {
    private String id;
    private String brand;
    private String model;
}
