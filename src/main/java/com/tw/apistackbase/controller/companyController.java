package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/companies")
public class companyController {
    private static List<Company> companies = new ArrayList(){{
        add(new Company("001","zhengzhou"));
        add(new Company("002","xiaohong"));
    }};

    //获取获取公司列表
    @GetMapping()
    public ResponseEntity<List<Company>> queryEmployeelist() {

        return ResponseEntity.ok( companies);
    }

    //获取某个特定的公司
    @GetMapping(path = "/{id}")
    public ResponseEntity<Company> getEmployeeID(@PathVariable String id) {

        Company result = new Company();

        for(Company e:companies){
            if(id.equals(e.getId()) ){
                result = e;
            }
        }
        return ResponseEntity.ok(result);
    }
    //添加一个公司
    @PostMapping()
    public ResponseEntity<List<Company>> addEmployee(@RequestBody Company company) {
        companies.add(company);
        return ResponseEntity.ok( companies);
    }

    //更新一个公司的基本信息
    @PutMapping()
    public ResponseEntity<List<Company>> updateEmployee(@RequestBody Company employee) {

        for(Company e:companies) {
            if (employee.getId() == e.getId()) {
                e.setName(employee.getName());
            }
        }
        return ResponseEntity.ok(companies);
    }
    //删除某个特定的公司
    @DeleteMapping ("/{id}")
    public ResponseEntity<List<Company>> deleteEmployee(@PathVariable String id) {

        for(Company e:companies) {
            if (id.equals(e.getId())) {
                companies.remove(e);
            }
        }
        return ResponseEntity.ok(companies);
    }
}