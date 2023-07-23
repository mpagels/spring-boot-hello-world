package de.mpagels.springboothelloworld;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private List<Car> cars = new ArrayList<>();

    // Create
    @PostMapping
    public Car post(@RequestBody Car car) {
        cars.add(car);
        return car;
    }

    // Read
    @GetMapping
    public List<Car> get(@RequestParam(required = false) String brand) {
        // Search
        if (brand != null ) {
            List<Car> carsByBrand = new ArrayList<>();
            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getBrand().equals(brand)) {
                    carsByBrand.add(cars.get(i));
                }
            }
            return carsByBrand;
        }
        // Get all
        return cars;
    }

    // Update
    @PutMapping("/{id}")
    public Car put(@PathVariable String id, @RequestBody Car car) {

        for (int i = 0; i < cars.size(); i++ ) {
            if (cars.get(i).getId().equals((id))) {
                cars.set(i, car);
                return car;
            }
        }

        return null;
    }

    // Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        int index = -1;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        cars.remove(index);
    }
}
