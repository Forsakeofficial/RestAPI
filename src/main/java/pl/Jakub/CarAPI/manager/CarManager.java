package pl.Jakub.CarAPI.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.Jakub.CarAPI.data.CarRepo;
import pl.Jakub.CarAPI.data.entity.Car;

import java.util.Optional;

@Service
public class CarManager {
    private CarRepo carRepo;

    @Autowired
    public CarManager(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public Optional<Car> findById(Long id) {
        return carRepo.findById(id);
    }

    public Iterable<Car> findAll() {
        return carRepo.findAll();
    }

    public Car save(Car car) {
        return carRepo.save(car);
    }

    public void deleteById(Long id) {
        carRepo.deleteById(id);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Car(1L, "Volkswagen", "Golf", "150 KM", "1.4 TSI"));
        save(new Car(2L, "Opel", "Astra", "210 KM", "1.8"));
    }
}
