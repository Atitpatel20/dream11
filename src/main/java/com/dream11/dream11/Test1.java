package com.dream11.dream11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        List<Employee> names = Arrays.asList(
                new Employee("prithvi","prithvi@gmail.com",9585256314L),
                new Employee("prithvi","prithvi@gmail.com",9585256945L),
                new Employee("prithvi","prithvi@gmail.com",9587916314L)
        );
        List<EmployeeDto> dtos = names.stream().map(employee -> mapToDto(employee)).collect(Collectors.toList());
        System.out.println(dtos);
    }
    static EmployeeDto mapToDto(Employee employee){
        EmployeeDto dto= new EmployeeDto();
        dto.setName(employee.getName());
        dto.setName(employee.getEmail());
        dto.setMobile(employee.getMobile());
        return dto;
    }
}
