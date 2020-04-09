## tomcat的安装
### 1. tomcat的使用
- 下载后压缩至指定的文件夹
- 环境变量配置
- tomcat的启动
  - tomcat目录下 bin 文件夹中的 startup.bat
  - 或者配置完环境变量后直接在命令行中输入 startup 启动
  - 浏览器中输入 localhost:8080 ,出现小猫图案证明启动成功
- 修改 tomcat 端口号
  -tomcat 目录下的 conf 目录，打开 server.xml 配置文件
  -找到Connector标签，修改port属性为所需要的端口号，端口号范围为1~65536
  -修改端口号之后移动要重启 tomcat 服务器
- 部署 web 工程到 tomcat 中
  - 1).把 web 工程的目录拷贝到 tomcat 目录下的 webapps 目录中
  - 2).tomcat 目录中 conf\Catalina\localhost\ 中创建一个例如 test.xml 的配置文件。内容如下：
  ```xml
  <!--Context 表示一个工程的上下文
        path 表示工程的访问路径
        docBase 表示你的工程目录在哪里
  -->
  <Context path = "/test" docBase = "D:\tomcat\conf\...">
  ```
  ******
### 2. IDEA 整合 tomcat 服务器
1. 操作菜单顺序File | Settings | Build, Execution, Deployment | Application Servers
2. 配置 tomcat 安装目录

### 3. IDEA 创建　web 工程
1. 创建动态 web 工程
   - 创建新模块
   - 创建时最好选择 Java Enterprise 中的 Web Application
   - 选择下面的 Create web.xml
   - 选择好 tomcat 版本
2. 添加额外的 jar 包
3. 在 IDEA中部署工程到　tomcat　上
