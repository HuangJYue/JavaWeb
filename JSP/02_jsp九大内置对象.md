### 一、`request`对象

-   封装了由客户端生成的`HTTP`请求的所有细节，主要包括`HTTP`头信息、系统信息、请求方式和请求参数等
-   通过`request`对象提供的相应方法可以处理客户端浏览器提交的`HTTP`请求中的各项参数

#### 1. 访问请求参数

-   通过超链接形式发送请求时，可以在超链接后面添加`？`来实现为该请求传递参数

```jsp
<a href="deal.jsp?id=1&user=">处理页</a>
```

-   当同时指定多个参数，各个参数之间要用`&`隔开

```jsp
http://localhost:8080/JavaWeb_war_exploded/deal.jsp?id=1&user=huang&pwd=123
```

-   通过使用`getParameter()`方法获取传递的参数值

```jsp
<%
    String id = request.getParameter("id");
    String user = request.getParameter("user");
    String pwd = request.getParameter("pwd");
%>
```
  -   若指定的参数不存在，将返回`null`
  -   若未指定参数值，返回空字符串“”

#### 2. 在作用域中管理属性

-   将一些数据传递到转发后的页面进行处理

-   语法格式：

    ```jsp
    request.setAttribute(String name, Object object);
    ```

-   参数说明：

    -   name：表示变量名，String类型，转发后的页面通过这个变量名获取数据
    -   object：用于指定需要在`request`范围内传递的数据，为`Object`类型

-   获取变量的值：

    ```jsp
    request.getAttribute(String name);
    ```
    -   name：变量名，该变量名在`request`范围内有效
    

#### 3. 获取`cookie`

-   使用`cookie`可以标识用户身份，记录用户名和密码，追踪重复用户等
-   浏览器将`cookie`以`key/value`的形式保存到客户机的某个指定目录中
-   方法：
    -   `getCookie()`：获取到所有`cookie`对象的集合
    -   `getNmae()`：获取指定名称的`cookie`
    -   `getValue()`：获取`cookie`对象的值
    -   `response`对象中的`addCookie()`方法：将一个`cookie`对象发送到客户端

#### 4. 解决中文乱码

将获取到的数据通过`String`的构造方法使用指定的编码类型重新构造一个`String `对象

```jsp
<%=new String(request.getParameter("name").getByte("ISO-8859-1"),"UTF-8")%>
```

#### 5. 获取客户端信息

|           方法            |                             说明                             |
| :-----------------------: | :----------------------------------------------------------: |
| `getHeader(String name)`  |                 获得HTTP协议定义的文件头信息                 |
| `getHeaders(String name)` | 返回指定名字的`request Header`的所有值，其结果是一个枚举型的实例 |
|   `getHeadersNames（）`   |   返回所有`request Header`的名字，其结果是一个枚举型的实例   |
|       `getMethod()`       |               获得客户端向服务器传送数据的方法               |
|      `getProtocol()`      |              获得客户端向服务器端传送数据的方法              |
|     `getRequestURI()`     |       获得发出请求字符串的客户端地址，不包括请求的参数       |
|     `getRequestURL()`     |       获得发出请求字符串的客户端地址，不包括请求的参数       |
|      `getRealPath()`      |                  返回当前请求文件的绝对路径                  |
|     `getRemoteAddr()`     |                     获取客户端的`ip`地址                     |
|     `getRemoteHost()`     |                      获取客户端的主机名                      |
|     `getServerName()`     |                       获取服务器的名字                       |
|    `getServletPath()`     |             获取客户端所请求的脚本文件的文件路径             |
|     `getServerPort()`     |                      获取客户端的端口号                      |

### 二、`response`对象

`response`对象用于响应客户请求

#### 1. 重定向

-   `sendRedirect()`方法将网页重定向到另一个页面
-   重定向可以将地址重定向到不同的主机上
-   客户端浏览器上将会得到跳转的地址，并重新发送请求链接
-   重定向操作后，会重新开始一个新的`request`对象

语法：

```jsp
response.sendRedirect(String path);
```

**==在`jsp`页面中使用重定向，不要在使用`jsp`脚本代码==**

#### 2. 处理`HTTP`文件头

1.  禁用缓存

    通过设置`HTTP`头的方法实现禁用缓存

    ```jsp
    <%
    	respomse.setHeader("Cache-Control","np-store");
    	response.setDataHeader("Expires", 0);
    %>
    ```

2.  设置页面自动刷新

    通过设置`HTTP`头方式实现

    ```jsp
    <%
    	response.setHeader("refresh","10"); //10秒刷新
    %>
    ```

3.  定时跳转网页

    ```jsp
    <%
    	response.setHeader("redresh","5;URL=login.jsp");	// 5秒后自动跳转至login.jsp 页面 
    %>
    ```

#### 3. 设置输出缓冲

通常情况下，服务器要输出到客户端的内容要先写到一个输出缓冲区

满足下列三个条件之一，就会把缓冲区内容写到客户端

-   `jsp`页面的输出信息已经全部写入缓冲区
-   缓冲区已满
-   `jsp`页面已经调用了`response`对象的`flushBuffer`方法或`out`对象的`flush方法`

|           方法            |                         说明                          |
| :-----------------------: | :---------------------------------------------------: |
|      `flushBuffer()`      |            强制将缓冲区的内容输出到客户端             |
|     `getBufferSize()`     | 获取响应所使用的缓冲区的实际大小，若无缓冲区，返回`0` |
| `setBufferSize(int size)` |         设置缓冲区大小，若设置为`0`，则不缓冲         |
|         `reset()`         |        消除缓冲区的内容，同时清除状态码和报头         |
|      `isCommitted()`      |         检测服务器端是否已经把数据写入客户端          |

### 三、`session`对象

-   `session`可以在页面间进行跳转时，保存用户状态，使整个用户会话一直存在，直至关闭浏览器
-   若在一个会话中，客户端长时间不向服务器发出请求，`session`对象就会消失

#### 1. 创建及获取客户的会话

-   `setAttribute()`方法

    ```jsp
    session.setAttribute(String name, Object obj);
    ```

    **==该方法用于将信息保存在`session`范围内==**

    -   name：用于指定作用域在`session`范围内的变量名
    -   obj：保存在`session`范围内的对象

    ```jsp
    session.setAttribute("name","huang");
    ```

    ==将用户名 `huang` 保存在 `session` 范围内的 `name` 变量中==

-   `getArrtribute()`方法

    该方法用于获取保存在`session`范围内的信息

    ```jsp
    getAttribute(String name)
    ```

    ==`name`：指定保存在 `session` 范围内的信息==

    ```jsp
    session.getAttribute("name");
    ```

    ==读取保存到`session`范围内的`name`变量的值==


#### 2. 从会话中移动指定的绑定对象

```jsp
<%
	session.removeAttribute("name");
%>
```

name：用于指定作用域在`session`范围内的变量名。==一定要保证变量在`session`范围内有效==，否则抛出异常

#### 3. 销毁`session`

对于某些实时统计在线人数的网站，需要手动销毁`session`

```jsp
session.invalidate();
```

**`session`在销毁后，将不可以在使用该`session`对象，否则抛出异常**

#### 4. 会话超时的管理

`session`的生命周期在`20～30分钟`，当用户首次访问就会产生一个新的对话，服务器就会记住这个对话状态，当绘画生命周期超时或者服务器端强制使会话失效，这个`session`就不能用了

`session`对象中提供的设置会话生命周期的方法：

-   `getLastAccessedTime()`：返回客户端最后一次与会话相关联的请求时间
-   `getMaxInactiveInterval()`：以秒为单位返回一个会话内两个请求最大时间间隔
-   `setMaxInactiveInterval()`：以秒为单位设置`session`的有效时间

### 四、`application`对象

-   `application`对象用于保存所有应用程序中的公有数据
-   `application`对象在整个应用区域中都有效
-   服务器启动时自动创建，停止时自动销毁
-   所有用户都可以共享`application`对象，类似于系统的“全局变量”

#### 1. 访问应用程序初始化参数

在`web.xml`文件中通过`<context-param>`标记配置应用程序初始化参数

```xml
<context-param>
        <param-name>namespace</param-name>
        <param-value></param-value>
</context-param>
```

-   `getInitParameter(String name)`方法

```jsp
application.getInitParameter();	返回已命名的参数值
// name： 用于指定参数名
```

-   获取`web.xml`文件中配置的`url`参数的值

    ```jsp
    application.getInitParameter("url");
    ```

-   `getAttributrNames()`：返回已定义的应用程序初始化参数名的枚举

    ```jsp
    application.getAttributeNames();
    ```

#### 2. 管理应用程序环境属性

-   `getAttributeNames()`：获得所有`application`对象使用的属性名
-   `getAttribute(String name)`：从`application`对象中获取指定对象名
-   `setAttribute(String key,Object obj)`：使用指定名称和指定对象在`application`对象中进行关联
-   `removeAttribute(String name)`：从`application`对象中去掉指定名称的属性

### 五、`out`对象

-   用于在`web`浏览器内输出信息，可以输出各种数据类型的数据
-   在输出非字符串类型的数据时，会自动转换为转换为字符串进行输出
-   管理应用服务器上的输出缓冲区
-   `out`对象输出数据时，可以对数据缓冲区进行操作，及时清除缓冲区中的残余数据
-   数据输出完毕之后，要及时关闭输出流

#### 1. 向客户端输出数据

-   `print()`方法

    该方法等同于使用`jsp`表达式输出信息

    ```jsp
    <%
    	out.print("out");
    %>
    <%="out"%>
    ```

-   `println()`方法

    输出内容后，在输出一个换行符

    ```jsp
    <%
    	out.println("out");
    %>
    ```

-   若想让`println`换行清晰显示，需要将输出的文本使用`HTML`的`<pre>`标记括起来

    ```jsp
    <pre>
    	<%
    		out.println("out");
    		out.println("out1");
    	%>
    </pre>
    ```

#### 2. 管理响应缓冲

管理缓冲区的方法

|       方法        |                             说明                             |
| :---------------: | :----------------------------------------------------------: |
|     `clear()`     |                      清除缓冲区中的内容                      |
|  `clearBuffer()`  | 清除当前缓冲区的内容； 即使内容已经提交给客户端，也可以访问该方法 |
|     `flush()`     |                            刷新流                            |
|  `isAutoFlush()`  |          检测当前缓冲区已满时是自动清空还是抛出异常          |
| `getBufferSize()` |                       获取缓冲区的大小                       |

### 六、其他内置对象

#### 1. `pageContext()`：获取会话范围（实际很少用）

-   获取页面上下文，可以在`jsp`页面直接使用`pageContext`对象
-   通过`pageContext`可以获取`jsp`页面的`request、response、session、application、exception`等对象

常用方法：

|                    方法                     |                             说明                             |
| :-----------------------------------------: | :----------------------------------------------------------: |
| `forward(java.lang.String relativeUtlpath)` |                    把页面跳转到另一个页面                    |
|         `getAttribute(String name)`         |                          获取参数值                          |
|    `getAttributeNamesInScope(int scope)`    | 获取某范围的参数名称的集合，返回值为`java.util.Enumeration`对象 |
|              `getException()`               |                     返回`Exception`对象                      |
|               `getRequest()`                |                      返回`request`对象                       |
|               `getResponse()`               |                     返回 `response`对象                      |
|               `getSession()`                |                      返回`session`对象                       |
|                 `getOut()`                  |                        返回`out`对象                         |
|             `getApplication()`              |                    返回`application`对象                     |
|              `setAttribute()`               |                 为指定范围内的属性设置属性值                 |
|             `removeAttribute()`             |                   删除指定范围内的指定属性                   |

#### 2. 读取`web.xml`配置信息中的`config`对象

-   `config`对象主要用于取得服务器的配置信息
-   通过`pageContext`对象中的`getServeltConfig()`方法可以获取一个`config`对象
    -   当一个`Servlet`对象初始化时，容器把某些信息通过`config`对象传递给这个`Servlet`

常用方法：

|           方法            |                             说明                             |
| :-----------------------: | :----------------------------------------------------------: |
|   `getServletContext()`   |                     获取`Servlet`上下文                      |
|    `getServletName()`     |                    获取`Servlet`服务器名                     |
|   `getInitParameter()`    | 获取服务器所有初始化参数名称，返回值为`java.util.Enumeration` |
| `getInitParameterNames()` |                 获取服务器中`name`参数的属性                 |

#### 3. 应答或请求的`page`对象

-   `page`对象代表`JSP`本身，只有在`JSP`页面内才是合法的
-   `page`对象本质上是包含当前`servelt`接口引用的变量，可以看作是`this`关键字的别名

使用方法：

|        方法        |              说明              |
| :----------------: | :----------------------------: |
|    `getClass()`    |      返回当前`Object`的类      |
|    `hashCode()`    |    返回该`Object`的哈希代码    |
|    `toString()`    |   把该`object`类转换成字符串   |
| `equals(Object o)` | 比较该对象和指定的对象是否相等 |

#### 4. 捕获异常的`exception`对象

-   `exception`对象处理`JSP`文件执行时发生的所有错误和异常
-   只有在`page`指令中设置为`isErrorPage`属性值为`true`的页面才可以被使用，
-   在一般的`JSP`页面中使用该对象将无法编译`JSP`文件

使用方法：

|          方法           |                说明                 |
| :---------------------: | :---------------------------------: |
|     `getMessage()`      | 返回`exception`对象的异常信息字符串 |
| `getLocalizedmessage()` |        返回本地化的异常错误         |
|      `toString()`       |   返回关于异常错误的简单信息描述    |
|   `fillStackTrace()`    |      重写异常错误的栈执行轨迹       |































