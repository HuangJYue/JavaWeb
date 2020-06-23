### 一、指令标识

-   设定整个`jsp`页面范围内都有效的相关信息
-   被服务器解释并执行
-   指令标识对于客户端浏览器是不可见的

语法格式

```jsp
<%@ 指令名 属性 1 = “属性值1” ......%>
```

-   指令名：用于特定的指令名称，在`jsp`中包含`page、include、taglib`三条指令
-   属性：用于指定属性名称，不同指令包含不同属性;一个指令可以设置多个属性
-   属性值：用于制定属性值

具体指令

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
```



******

#### 1. page指令

-   `language`属性：设置`jsp`页面使用的语言

    ```jsp
    <%@ page language="java"%>
    ```

-   `extends`属性：设置`jsp`页面继承的`java`类，不常用，可能会影响服务器性能的优化

-   `import`属性：设置`jsp`导入的类包

    ```jsp
    <%@ page import="java.util.*"%>
    ```

-   `pageEccoding`属性：指定文件的编码格式

    ```jsp
    <%@ page pageEccoding="GB18030"%>
    ```

-   `contextType`属性：设置`jsp`页面的`MIME`类型和字符编码，浏览器据此显示网页内容

    ```jsp
    <%@ page contextType="text/html;charset=UTF-8"%>
    ```

-   `session`属性：指定`jsp`页面是否使用`HTTP`的`session`会话对象，属性值是`boolean`，默认是`true`

    ```jsp
    <%@ page session="false"%>
    ```

-   `buffer`属性：设置`jsp`的`out`输出对象使用的缓冲区大小，默认`8KB`，使用8的倍数设置

    ```jsp
    <%@ page buffer="128kb"%>
    ```

-    `autoFlush`属性：设置`jsp`页面缓存满时，是否刷新，默认`true`

     ```jsp
     <%@ page autoFlush="false"%>
     ```

-   `isErrorPage`属性：将当前`jsp`页面设置成错误处理页面来处理另一个`jsp`页面的错误，意味着当前`jsp`页面业务处理的改变

    ```jsp
    <%@ page isErrorPage="true"%>
    ```

-   `errorPage`属性：指定处理当前`jsp`页面一场错误的另一个`jsp`页面，其属性的属性值是一个`url字符串`;指定的`jsp`错误处理页面必须设置`isErrorPage`属性为`true`

    ```jsp
    <%@ page errorPage="error/loginErrorPage.jsp"%>
    ```

    **==如果设置该属性，则`web.xml`文件中定义的任何错误页面都将被忽略，优先使用该属性定义的错误处理页面==**

******

#### 2. include指令（文件包含指令）

-   ```jsp
    <>%@ include file="path"%>
    ```

-   ==路径可以是相对路径也可以是绝对路径==

-   该指令可以在一个`jsp`页面中包含另一个`jsp`页面

-   该指令是静态包含，即被包含文件中所有内容都会被原样包含到该`jsp`页面中

-   若被包含文件中有`jsp`代码，在包含中也不会被执行

-   使用该指令，最终生成一个文件，因此，==**在被包含和包含的文件中，不能有重名的变量**==

    

<img src="/home/huangyue/桌面/JavaWeb/pic/01.png" alt="04" style="zoom:80%;" />

#### 3. taglib 指令

-   生命该页面中所使用的标签库，同时引用标签库，并指定标签的前缀

-   通过前缀来引用标签库中的标签

    ```jsp
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    ```

******

******

### 二、脚本标识

#### 1. JSP 表达式

`jsp`表达式用于向页面中输出信息，语法：

```jsp
<%= 表达式%>
```

表达式：可以是java语言的表达式，==该表达式的最终运算结果将被转换为字符串==

#### 2. 声明标识

-   用于在`jsp`页面中定义全局的变量或方法

-   生命标识定义的变量和方法可以被整个`jsp`页面访问，因此通常使用该标识定义整个`jsp`页面需要引用的变量或方法

-   **==服务其执行`jsp`页面时，会将`jsp`页面转换为`Servlet`类，在该类中会把使用的`jsp`生命标识定义的变量和方法转换为类的成员变量和方法==**

-   生命周期从创建开始到服务器关闭结束

-   语法格式：

    ```jsp
    <%!
    	声明变量或方法的代码    
    %>
    ```

#### 3. 代码片段

-   在`jsp`页面中嵌入`java`代码或者脚本代码
-   代码片段将在页面请求的处理期间被执行，只在当前`jsp`页面中有效
-   生命周期实在页面关闭后就会被销毁
-   脚本代码可以应用`jsp`的内置对象在页面输出内容、处理请求和响应、访问`session`绘画等
-   语法格式：

```jsp
<% java代码或是脚本代码 %>
```

******

******

### 三、JSP注释

#### 1. 带有`jsp`表达式的注释

-   单行注释

    ```jsp
    // 注释
    ```

-   多行注释

    ```jsp
    /*
    	注释内容
    	......
    */
    ```

-   提示文档注释

    ```jsp
    /**
    	提示信息
    	......
    */
    ```

#### 2. `HTML`注释

```jsp
// 注释文本
```

==**在查看网页源代码会发现注释信息**==

#### 3. 隐藏注释

```jsp
<%-- 注释内容 --%>
```

#### 4. 动态注释

```html
<!-- <%= 注释 %> -->
```

******

******

### 四、动作标识

#### 1. 包含文件标识`<jsp:include>`

-   用于向当前页面中包含其他的文件，可以是动态的也可以是静态的

-   过程：

    <img src="/home/huangyue/桌面/JavaWeb/pic/02.png" alt="02" style="zoom:75%;" />

-   语法格式

    ```jsp
    <jsp:include page="url" flush="false"/>
    ```

    ```jsp
    <jsp:include page="url" flush="false">
        子动作标识<jsp:param>
        </jsp:param>
    </jsp:include>
    ```

    -   page：指定被包含文件的相对路径
    -   flush：可选属性，默认false

#### 3. 请求转发标识`<jsp:forward>`

-   通过`<jsp:forward>`动作标识可以将请求转发到其他的`web`资源

-   执行请求转发后，当前页面不再被执行，而是去执行该标识指定的目标页面

-   基本流程：

    <img src="/home/huangyue/桌面/JavaWeb/pic/03.png" alt="03" style="zoom:75%;" />

-   语法：

    ```jsp
    <jsp:forward page="url"/>
    ```

    ```jsp
    <jsp:forward page="url">
        <jsp:param>
    </jsp:forward>
    ```

    -   page：指定请求转发的目标页面。属性值可以是一个制定文件路径的字符串，也可以是表示文件路径的`jsp`表达式，==请求被转向的目标文件必须是内部的资源==

#### 4. 传递参数标识`<jsp:param>`

-   作为其他标识的子标识，用于为其他标识传递参数

-   语法：

    ```jsp
    <jsp:param name="name" value="value"/>
    ```

    -   name：指定参数名称
    -   value：设置对应的参数值

-   通过该表示指定的参数，将以 “参数名=值” 的形式加入请求中，其功能与在文件名后面直接加 “？参数名 = 参数值” 是相同的