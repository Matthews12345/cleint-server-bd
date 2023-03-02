package com.example.demo;

import jakarta.persistence.Entity; // аннотация для указания, что класс является сущностью и относится к ORM JPA
import jakarta.persistence.GeneratedValue; // аннотация для работы со столбцами SQL
import jakarta.persistence.GenerationType; // класс, отвечающий за тип данных перечисления
import jakarta.persistence.Id; // аннотация, отвечающая за определение первичного ключа объекта

@Entity
public class Car {
    private Long id; //ID
    private String brand; // марка автомобиля
    private int year_made; // год выпуска
    private String date_registered; // дата поставки на учет в автопарке
    private String owner_name; // имя владельца

    protected Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear_made() {
        return year_made;
    }

    public void setYear_made(int year_made) {
        this.year_made = year_made;
    }

    public String getDate_registered() {
        return date_registered;
    }

    public void setDate_registered(String date_registered) {
        this.date_registered = date_registered;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }
    @Override
    public String toString() {
        return "car [id=" + id + ", brand=" + brand + ", year made=" + year_made + ", date registered=" + date_registered + ", owner name=" + owner_name + "]";
    }
}







