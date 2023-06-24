package com.example.controller;

import com.example.anno.Log;
import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

// @Scope("prototype")
@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping("/depts")
    public Result list(){
        log.info("查询全部部门数据");

        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }


    @GetMapping("/depts/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询部门", id);
        Dept dept =  deptService.getById(id);
        return Result.success(dept);
    }

    @Log
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门", id);
        deptService.delete(id);
        return Result.success();
    }

    @Log
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        log.info("新增部门");
        deptService.add(dept);
        return Result.success();
    }
}
