package com.example.demo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<Car, Long>{
    @Query("select p from Car p where concat(p.id, '', p.brand, '', p.year_made, '', p.date_registered, '', p.owner_name) like %?1%")
    List<Car> search(String keyword);
}
