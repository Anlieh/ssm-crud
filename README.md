## SSM-CRUD
Spring + SpringMVC + MyBatis + MyBatis Generator
> 注：此项目前端含量极高！


### 功能点
- 分页展示
- 数据检验: jQuery前端检验 + JSR303后端检验
- Ajax
- Rest风格的URI


### 技术点
- 基础框架：SSM
- 数据库: MySQL
- 前端框架: BootStrap
- 依赖管理: Maven
- 分页: pageHelper
- 逆向工程: MyBatis Generator


### 基础环境搭建
- 创建maven工程
- 引入项目依赖的jar包
   spring
   springmvc
   mybatis
   数据库驱动、连接池
   jstl、Thymeleaf、servlet-api、junit等
- 导入bootstrap前端框架
- ssm配置文件
  web.xml、spring、springmvc、mybatis，使用mybatis逆向工程生成对应的bean以及mapper
- thymeleaf渲染页面


### 查询-springmvc
- 访问index.html页面
- 请求查询员工列表
- StudentController接收请求,查询数据
- 进入stus.html页面展示
- pageHelper分页插件完成分页查询功能


### 查询-Ajax
> - 返回json，实现客户端无关性
> - ajax以jQuery为前提
- 发送ajax请求查询数据
- 服务器以JSON格式返回数据
- 浏览器接收JSON数据，使用js通过dom渲染页面


### 添加-Ajax
- 查询部门列表，在对话框中显示
- 用户输入数据并保存到数据库中
> 数据校验:
> - jquery校验用户名、邮箱是否合法
> - ajax校验用户名是否可用
> - jsr303后端校验

- Rest风格的URI:
 /stu/{id}   GET    查询 
  /stu        POST   提交
  /stu/{id}   PUT    修改
  /stu/{id}   DELETE 删除


 ### 修改
- 点击编辑，弹出用户修改的模态框（显示用户信息）
- 点击更新完成用户修改

> 绑定事件的时机：
> 1) 在创建按钮时 绑定
> 2) 绑定点击 .live()，已被新版jquery废弃，改为on  


### 总结
UI: Bootstrap 

![image-20220503203618889](C:\Users\chaowen\AppData\Roaming\Typora\typora-user-images\image-20220503203618889.png)
![image](https://user-images.githubusercontent.com/80996151/166454494-8b731f31-5943-4a62-8666-6bfa31c513aa.png)


### 其他
1. web路径
- 不以"/"开始的相对路径：以当前资源的路径为基准
- 以"/"开始的相对路径：以服务器路径为标准,需要加上项目名
    http://localhost:8080/

2. Thymeleaf
- `[[]]`和`[()]`: 可以直接在HTML文本中使用标准表达式
     `[[]]`: 相当于`th:text`, 对含有 HTML 标签的内容自动进行字符转义。
     `[()]`: 相当于`th:utext`, 对含有 HTML 标签的内容不进行字符转义。
- `[[@{/}]]`: 可以算作thymeleaf的关键字，写在任何位置都会被解析为根路径

3. JSR303校验
- Hibernate-Validator包
