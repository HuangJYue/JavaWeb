## 编写Servlet

### 一、编写 Servelt

1. 创建一个 ServletTest 类继承 HttpServlet ，重写 doGet 和 doPost 方法，根据请求方式

2. 在 web.xml 配置 ServletTest 

    原因：让浏览器发出的请求知道到达哪个 servelt，也就是让 tomcat 将封装好的 request 找到对应的 servlet 让其使用

    <img src="C:\Users\HUANGYUE\Documents\GitHub\JavaWeb\Servlet\picture\批注 2020-04-15 110107.png" style="zoom:80%;" />

3. 步骤：

    - 浏览器通过`http://localhost:8080/Servlet01_war_exploded/ServletTest`来找到`web.xml`中的`url-pattern`
    - 匹配到了`url-pattern`后，就会找到第二步`servlet`的名字`ServletTest`，知道了名字，就可以通过`servlet-name`找到第三步
    - 到了第三步，也就能够知道`servlet`的位置了。然后到其中找到对应的处理方式进行处理

    <img src="C:\Users\HUANGYUE\Documents\GitHub\JavaWeb\Servlet\picture\批注 2020-04-15 113025.png" style="zoom:80%;" />



