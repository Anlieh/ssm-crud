package com.crud.controller;

import com.crud.bean.Department;
import com.crud.bean.Msg;
import com.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/getAllDepts")
    @ResponseBody
    public Msg getAll() {
        List<Department> deptList = this.departmentService.getAll();
        return Msg.success().add("deptList", deptList);
    }

}
