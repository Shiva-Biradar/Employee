package com.jav8.emp.Controller;

import com.jav8.emp.Model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

@RestController
public class EmpController {

    @GetMapping("getEmp")
    public void getEmp() {
        List<Employee> emp = Arrays.asList(
                new Employee("Shiva", "IT", 35, "Male", 120000),
                new Employee("Sanchu", "HR", 34, "Male", 190000),
                new Employee("Sinchu", "IT", 28, "Female", 200000),
                new Employee("Sinchu", "Admin", 38, "Female", 210000)

        );



  Map<String,Optional<Employee>> salary=emp.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

  salary.forEach((dept,emp1)->{

      //System.out.println(dept);
      System.out.println(emp1.get().getSalary());

          });

        //System.out.print(salary);

    }
}
