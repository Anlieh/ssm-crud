package com.crud.controller;

import com.crud.bean.Msg;
import com.crud.bean.Student;
import com.crud.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/stu-list")
    public String pageHelperList(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            Model model) {
        // 引入PageHelper分页插件
        // 传入页码和每页展示的数量
        Page<Object> objects = PageHelper.startPage(pn, 10);
        List<Student> stuList = this.studentService.getAll();
        // 使用PageInfo包装查询结果，提交给页面
        PageInfo<Student> pageInfo = new PageInfo<>(stuList);
        model.addAttribute("pageInfo", pageInfo);
        return "stu-list";
    }

    @RequestMapping("/getJsonStudents")
    @ResponseBody
    public Msg getStuListWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        Page<Object> objects = PageHelper.startPage(pn, 10);
        List<Student> stuList = this.studentService.getAll();
        PageInfo<Student> pageInfo = new PageInfo<>(stuList, 10);
        return Msg.success().add("pageInfo", pageInfo);
    }


    @RequestMapping(value = "/stu", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveStudent(@Valid Student student, BindingResult result) {
        if (result.hasErrors()){
            // 在模态框中显示校验失败的信息
            Map<String ,Object> map = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.failure().add("fieldErrors", map);
        } else {
            studentService.insertStudent(student);
            return Msg.success();
        }

    }

    @RequestMapping("/checkStu")
    @ResponseBody
    public Msg checkStu(@RequestParam("stuName") String stuName) {
        // 判断用户名是否合法
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        if(!stuName.matches(regx)) {
            return Msg.failure().add("va_msg", "用户名不合法");
        }
        // 数据库用户名重复检验
        boolean exist = studentService.checkStudent(stuName);
        if (exist) {
            return Msg.success();
        } else {
            return Msg.failure().add("va_msg", "用户名已被注册！");
        }

    }

//    @RequestMapping(value = "/stu{id}", method = RequestMethod.PUT)
//    @ResponseBody
//    public Msg updateStudent(Student student){
//        int i = studentService.updateStudent(student);
//        return Msg.success();
//    }
//
//    @RequestMapping(value = "/stu/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public Msg deleteStudent(@PathVariable("id") Integer id) {
//        Student student = studentService.getStudent(id);
//        return Msg.success().add("student", student);
//    }



}
