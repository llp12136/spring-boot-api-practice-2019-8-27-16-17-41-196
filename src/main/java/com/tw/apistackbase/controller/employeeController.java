package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 28/08/2019 by llp
 */
@RestController
@RequestMapping("/employees")
public class employeeController {


    private static List<Employee> employees = new ArrayList(){{
        add(new Employee(0,"xiaoming",20,"Male"));
        add(new Employee(1,"xiaohong",19,"Female"));
        add(new Employee(2,"xiaozhi",15,"Male"));
        add(new Employee(3,"xiaogang",19,"Male"));
    }};
//获取员工名单
    @GetMapping()
    public ResponseEntity<List<Employee>> queryEmployeelist() {

        return ResponseEntity.ok( employees);
    }
    //查询所有男性员工
    @GetMapping()
    public ResponseEntity<Employee> queryEmployee(@RequestParam("gender") String gender) {
        Employee result = new Employee();
//      List<Employee> employeellist = new ArrayList<>();
//      Employee employee = new Employee();
//      employee.setId(1);
//      employee.setName("xiaoming");
//      employee.setAge(20);
//      employee.setGender("Male");
//        employeellist.add(employee);
        for(Employee e:employees) {
            if (gender.equals(e.getGender())) {
                result = e;
            }
        }
        return ResponseEntity.ok( result);
    }
    //获得某个特定员工
    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> getEmployeeID(@PathVariable int id) {

        Employee result = new Employee();

        for(Employee e:employees){
            if(id == e.getId()){
                result = e;
            }
        }
        return ResponseEntity.ok(result);
    }
//添加一名员工
    @PostMapping()
    public ResponseEntity<List<Employee>> addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return ResponseEntity.ok( employees);
    }

    //update一名员工
    @PutMapping()
    public ResponseEntity<List<Employee>> updateEmployee(@RequestBody Employee employee) {

        for(Employee e:employees) {
            if (employee.getId() == e.getId()) {
                e.setName(employee.getName());
                e.setAge(employee.getAge());
                e.setGender(employee.getGender());
            }
        }
            return ResponseEntity.ok(employees);
        }
    //delete一名员工
    @DeleteMapping ("/{id}")
    public ResponseEntity<List<Employee>> deleteEmployee(@PathVariable int id) {

        for(Employee e:employees) {
            if (id ==(e.getId())) {
                employees.remove(e);
            }
        }
        return ResponseEntity.ok(employees);
    }
}