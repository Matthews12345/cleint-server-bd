package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; // аннотация
import org.springframework.data.repository.query.Param; // привязываем наши параметры к передаче данных из sql запроса
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // интерфейс, необходимый для взаимодействия контроллера и конфигуратора Model u Controller, а также для добавления всех элементов в веб-интерфейс
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView; // метод, позволяющий указывать названия html страниц, которые мы подвязываем контроллеру
@Controller
public class AppController {
    @Autowired
    private CarService service;

    @RequestMapping("/") // сразу открывается главная страница
    public String viewHomePage(Model model, @Param("keyword") String keyword) { // метод модели
        List<Car> listCars = service.listAll(keyword);
        model.addAttribute("listCars", listCars); // добавляем переменную, которую будем использовать в веб-интерфейсе
        model.addAttribute("keyword", keyword);
        return "index";
    }
    @RequestMapping("/new") // создаем контроллер по добавлению студента
    public String showNewCarForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "new_car";
    }
    @GetMapping("/god")
    public String showLogin(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "god";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute("car") Car car) { // метод сохранения студентов
        service.save(car);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}") // контроллер для редактирования студентов по ключу
    public ModelAndView showEditCarForm(@PathVariable(name="id") Long id) {
        ModelAndView mav = new ModelAndView("edit_car");
        Car car = service.get(id);
        mav.addObject("Car", car);
        return mav; // возвращаем страницу с данными о студентах по id
    }
    @RequestMapping("/delete/{id}")
    public String deleteCar(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}


