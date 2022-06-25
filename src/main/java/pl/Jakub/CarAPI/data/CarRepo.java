package pl.Jakub.CarAPI.data;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.Jakub.CarAPI.data.entity.Car;

@Repository
public interface CarRepo extends CrudRepository<Car, Long> {
}
