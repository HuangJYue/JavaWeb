## JSP概述

### 1. 什么是JSP

JSP（Java Server Pages）是JavaWeb服务器端的动态资源，它与HTML页面的作用是相同的，显示数据或获取数据

### 2. JSP组成

JSP = HTML + Java脚本（代码片段） + JSP动态标签

  <img src="C:\Users\HUANGYUE\Documents\GitHub\JavaWeb\JSP\picture\1.png" style="zoom:80%;" />

### 3. JSP的运行

#### 1). 如何产生

**在tomcat中lib目录下的jasper.jar负责解释jsp文件 —> .java文件 —> .class文件（继承了HttpJsBase（HttpServlet的子类））**

#### 2). 编译后的文件

**解释和编译好的文件会放在tomcat的work\Catalina\localhost\项目名\org\apache\jsp目录下**

#### 3). JSP的生命周期

- **编译阶段：解释和编译JSP文件**
- **初始化阶段：调用编译后类的jspInit()方法**
- **执行阶段：调用 jspService(req,resp)方法**
- **销毁阶段：调用destroy()方法**

*****

### 4. JSP格式

#### 1). JSP脚本元素

- <%=表达式 %> JSP 表达式脚本：里面可以写Java代码
    - 用于向页面输出内容
    - 翻译到servlet程序的service方法中，以out.print()打印输出
        - out是jsp的一个内置对象，用于生成html代码
        - **表达式不要以分号结尾，否则报错**
    - 表达式脚本可以输出任意类型
- <% Java代码 %> JSP **代码脚本**：里面可写任何Java代码
    - 可以书写任意Java语句
    - 脚本内的内容都会被翻译到 service 方法中
    - 所以，service方法可以写的Java代码，都可以写到代码脚本中
- <%!  Java代码 %>JSP 声明脚本
    - 定义全局变量
    - 定义 static 静态代码块
    - 定义内部类
    - **几乎可以卸载类的内部写的代码，都可以通过生命脚本来实现**

#### 2). JSP 注释

**Java中的单行和多行注释可以在翻译后的Java原代码中看见**

<%– – jsp – –%>：JSP注释在翻译的时候会直接被忽略掉

*****

### 5. JSP九大内置对象

| **request**     | **请求对象，可以获取请求信息**                               |
| --------------- | ------------------------------------------------------------ |
| **response**    | **响应对象，可以设置响应信息**                               |
| **pageContext** | **当前页面上下文对象。可以在当前上下文保存属性信息**         |
| **session**     | **会话对象，可以获取会话信息**                               |
| **exception**   | **异常对象只有在jsp页面的page指令中设置 isErrorPage=“true”的时候才会存在** |
| **application** | **ServletContext对象实例，可以获取Servlet的配置信息**        |
| **config**      | **ServletConfig对象实例，可以获取Servlet的配置信息**         |
| **out**         | **输出流**                                                   |
| **page**        | **表示当前Servlet对象实例（不如使用 this 对象）**            |

**以上都可以在`代码脚本`或`表达式脚本`中直接使用的对象**

*****

### 6). 四大域对象

**经常用来保存数据信息**



| **pageContext**                 | **可以保存在同一个JSP页面中使用**                            |
| ------------------------------- | ------------------------------------------------------------ |
| **request**                     | **可以保存数据在同一个request对象中使用。经常用于在转发的时候传递数据** |
| **session**                     | **可以保存在一个会话中使用**                                 |
| **application(ServletContext)** | **就是ServletContext对象**                                   |

*****

### 7. JSP中的out输出流 和 reponse.getwriter()输出流

#### 1). out的类型是JspWriter

- reponse.getWriter(); 的返回的类型是PrintWriter;
- out和reponse.getWriter的类不一样
    - 前者是JspWriter
    - 后者是java.io.PrintWriter

#### 2). 获取方式不同

- JspWriter是JSP内置对象，直接使用即可，对象名out是保留字，也只能通过out来调用其相关方法
    - 还可以通过内置对象pageContext.getOut();获得
- PrintWriter在用时需要通过内置对象response.getEriter();获得

*****

### 8. JSP常用标签

#### 1). <%- - 静态包含 - -%>

```jsp
<%@ include file="" %>
```

**静态包含是把包含的页面内容原封不动的输出到包含的位置**

#### 2). <%- -  动态包含- - %>（不常用）

```jsp
<jsp:include page=""></jsp:include>
```

**动态包含把包含的jsp页面单独翻译成servlet文件，然后再执行的时候在调用翻译的servlet程序，并把计算的结果返回**

动态包含实在执行的时候才会加载，所以叫动态包含

#### 3). <%- - 转发 - - %>

```jsp
<jsp:forward page=""></jsp:forward>
```

























