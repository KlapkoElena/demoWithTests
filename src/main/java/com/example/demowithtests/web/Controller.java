package com.example.demowithtests.web;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.*;
import com.example.demowithtests.service.Service;
import com.example.demowithtests.util.config.mapstruct.EmployeeMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "Employee", description = "Employee API")
public class Controller {

    private final Service service;
    private final EmployeeMapper mapper;

    //Операция сохранения юзера в базу данных
    @PostMapping("/users/save1")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody Employee employee) {

        return service.create(employee);
    }

    //save dto2
    @PostMapping("/users/save2")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeSave1Dto saveEmployee2(@RequestBody Employee employee) {
        return mapper.employeeSave1Dto(service.create(employee));
    }

    //Получение списка юзеров
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllUsers() {
        return service.getAll();
    }

    //Получения юзера по id
    @GetMapping("/users/dto1/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @GetMapping("/users/dto2/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeRead1Dto getEmployeeById2Dto(@PathVariable Integer id) {
        return mapper.employeeRead1Dto(service.getById(id));
    }

    //Получения юзеров по имени
    @GetMapping(value = "users", params = {"name"})
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getName(@RequestParam(value = "name") String name) {
        return service.getName(name);
    }

    //Получения юзеров по стране
    @GetMapping(value = "users", params = {"country"})
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getCountry(@RequestParam(value = "country") String country) {
        return service.getCountry(country);
    }

    //Обновление юзеров по стране
    @PutMapping("/users/{country}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateCountry(@PathVariable("country") String country, @RequestBody Employee employee) {
        return service.updateById(Integer.valueOf(country), employee);
    }

    // Получение имен всех юзеров
    @GetMapping(value = "/users", params = {"allname"})
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllName(@RequestParam(value = "name") String name) {
        return service.getAllName(name);
    }

    //Получения юзеров по номеру телефона
    @GetMapping(value = "/users", params = {"phone"})
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getNameByPhone(@RequestParam(value = "phone") Integer phone) {
        return service.getNameByPhone(phone);
    }

    //Обновление юзера
    @PatchMapping("/users/update1/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeUpdate1Dto refreshEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        return mapper.employeeUpdate1Dto(service.updateById(id, employee));
    }

    //Обновление юзерa по стране2
    @PutMapping("/users/update2/{country}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeUpdate2Dto updateCountry2(@PathVariable("country") String country, @RequestBody Employee employee) {
        return mapper.employeeUpdate2Dto(service.updateById(Integer.valueOf(country), employee));
    }

    //Удаление по id
    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployeeById(@PathVariable Integer id) {
        service.removeById(id);
    }

    //Удаление всех юзеров
    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllUsers() {
        service.removeAll();
    }
}