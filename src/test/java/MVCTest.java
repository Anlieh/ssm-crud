import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springMVC.xml"})
public class MVCTest {

    // 传入SpringMVC的ioc容器
    @Autowired
    private WebApplicationContext context;

    // 虚拟mvc请求，获取处理结果
    private MockMvc mockMvc;

    @Before
    public void initMockMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testPage() throws Exception {
        // 模拟请求
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/getAll").param("pn", "1")).andReturn();

        // 从请求域中取出pageInfo
        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码: " + pageInfo.getPageNum());
        System.out.println("总页码: " + pageInfo.getPages());
        System.out.println("总记录数: " + pageInfo.getTotal());
    }

}
