package pl.Jakub.CarAPI.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.Jakub.CarAPI.data.entity.Car;
import pl.Jakub.CarAPI.manager.CarManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/cars")

public class CarAPI {

    private CarManager carManager;

    @Autowired
    public CarAPI(CarManager carManager) {
        this.carManager = carManager;
    }

    @GetMapping("/all")
    public Iterable<Car> getAll() {
        return carManager.findAll();
    }

    @GetMapping
    public Optional<Car> getById(@RequestParam Long index) { //REQUST PARAM pozwala do danego indexu
        return carManager.findById(index);
    }

    @PostMapping
    public Car save(@RequestBody Car car) { return carManager.save(car); }

    @PutMapping
    public Car updateCar(@RequestBody Car car) {
        return carManager.save(car);
    }

    @DeleteMapping
    public void deleteCar(@RequestParam Long index) {
        carManager.deleteById(index);
    }
}
