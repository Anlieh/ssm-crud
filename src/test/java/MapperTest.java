import com.crud.bean.Department;
import com.crud.bean.Student;
import com.crud.dao.DepartmentMapper;
import com.crud.dao.StudentMapper;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

/**
 * 测试dao层的工作
 * 推荐使用Spring的单元测试，可以自动注入组件:
 *   1) 导入SpringTest模块
 *   2) 指定Spring配置文件的位置
 */

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void testStudentMapper() {
        // 1) 创建SpringIOC容器
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2)
//        DepartmentMapper departmentMapper1 = context.getBean(DepartmentMapper.class);

//        departmentMapper.insertSelective(new Department(null, "纪检部"));
//
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
////        for (int i = 0;i < 10;i++) {
////            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
////            mapper.insert(new Student(null, uid, "M" , uid + "@163.com", i % 4));
////        }
//
//        Student student = mapper.selectByPrimaryKey(1);
//        System.out.println(student);

    }

    @Test
    public void testDepartmentMapper() {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departments = mapper.selectByExample(null);
        System.out.println("=================================================================");
        System.out.println(departments);
        System.out.println("=================================================================");
    }

}
