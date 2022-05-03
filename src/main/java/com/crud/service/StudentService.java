package com.crud.service;

import com.crud.bean.Student;
import com.crud.bean.StudentExample;
import com.crud.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getAll() {
        return this.studentMapper.selectByExample(null);
    }

    public Integer insertStudent(Student student) {
        return this.studentMapper.insertSelective(student);
    }

    public boolean checkStudent(String stuName) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andStuNameEqualTo(stuName);
        long count = studentMapper.countByExample(example);
        return count == 0;
    }

//    public Student getStudent(Integer id) {
//        return studentMapper.selectByPrimaryKey(id);
//    }
//
//    public int updateStudent(Student student) {
//        return studentMapper.updateByPrimaryKeySelective(student);
//    }
}
