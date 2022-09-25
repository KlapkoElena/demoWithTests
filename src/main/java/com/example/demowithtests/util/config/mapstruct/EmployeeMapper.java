package com.example.demowithtests.util.config.mapstruct;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.*;
//import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeRead1Dto employeeRead1Dto(Employee employee);
    Employee employeeRead1DtoEmployee(EmployeeRead1Dto employeeReadDto);

    EmployeeSave1Dto employeeSave1Dto(Employee employee);
    Employee employeeRead2Dto(EmployeeSave1Dto employeeCreateDto);

    EmployeeUpdate1Dto employeeUpdate1Dto(Employee employee);
    Employee employeeUpdate1DtoToEmployee(EmployeeUpdate1Dto employeeUpdateDto);

    EmployeeUpdate2Dto employeeUpdate2Dto(Employee updateById);
    Employee employeeUpdate2DtoToEmployee(EmployeeUpdate1Dto employeeUpdateDto);
}
