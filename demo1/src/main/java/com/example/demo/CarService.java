package com.example.demo;
// в этом классе хранится бизнес-логика
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; // для связи зависимостей из всех классов
import org.springframework.stereotype.Service; // аннотация для обнаружения всех зависимостей, указывает, что класс StudentService принадлежит серверу SpringBoot
@Service
public class CarService {
    @Autowired
    private CarRepository repo;
    public List<Car> listAll(String keyword) { // коллекция и метод, отвечающий за поиск и фильтр в нашей системе
        if (keyword!=null) { // если keyword
            return repo.search(keyword); // выводим все результаты поиска,  передача всех объектов из нашего репозитория
        }
        return repo.findAll(); // ничего не выведется
    }
    public void save(Car car) {
        repo.save(car);
    }
    public Car get(Long id) {
        return repo.findById(id).get();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
