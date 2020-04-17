## HttpServlet 类详解

HttpServlet继承GenericServlet，主要是为了实现service方法的各种设计和细节

<img src="C:\Users\HUANGYUE\Documents\GitHub\JavaWeb\Servlet\picture\01.png" style="zoom:80%;" />

### 　service(ServletRequest req, ServletResponse res)方法

<img src="C:\Users\HUANGYUE\Documents\GitHub\JavaWeb\Servlet\picture\02.png" style="zoom:80%;" />

**该方法中只是将ServletRequest和ServletResponse两个对象强制转换为HttpServletRequest和HttpServletReponse对象    原因？**

<img src="C:\Users\HUANGYUE\Documents\GitHub\JavaWeb\Servlet\picture\03.png" style="zoom:80%;" />

<img src="C:\Users\HUANGYUE\Documents\GitHub\JavaWeb\Servlet\picture\04.png" style="zoom:80%;" />

- req的类型是org.apache.catalina.connector.RequestFacade

- 由图可知：req的继承结构
    - RequestFacade
    - HttpServletRequest
    - ServletRequest
- 由此可以把它看成HttpServletRequest或者ServletRequest
- 转换为httpServletRequest和HttpServletResponse对象之后，在调用service(HttpServletRequest req, HttpServletResponse resp)方法。