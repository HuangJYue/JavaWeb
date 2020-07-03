### 一、`Servlet`体系

`servlet`对象主要封装了对`HTTP`请求的处理，并且它的运行需要`servlet`容器的支持

`servlet`结构体系图：

<img src="/home/huangyue/JavaWeb/pic/04.png" alt="04" style="zoom: 80%;" />

1.  什么是`Servlet`

    `Servlet`是`JavaWeb`三大组件之一，属于**动态资源**。其作用是处理请求，服务器会把接收到的请求交给`Servlet`来处理，在`Servlet`中通常需要：

    -   接收请求数据
    -   处理请求
    -   完成响应

    <img src="/home/huangyue/JavaWeb/pic/05.png" alt="05" style="zoom:75%;" />

    一个`Servlet`容器可以同时运行多个`web`应用程序，每个应用程序内部都有多个`Servlet`

    <img src="/home/huangyue/JavaWeb/pic/07.png" alt="07" style="zoom:75%;" />

    `Servlet`应用程序的体系结构图

    <img src="/home/huangyue/JavaWeb/pic/06.png" alt="06" style="zoom:75%;" />

2.  特性：

    -   方便
    -   跨平台
    -   灵活性和可扩展性

### 二、`Servlet`生命周期

<img src="/home/huangyue/JavaWeb/pic/09.png" alt="09" style="zoom:75%;" />

`servlet`遵循一定的生命周期，`servlet`生命周期由`servlet`容器管理，包括一下步骤：

-   加载`servlet`，执行一次

-   创建`servlet`实例，执行一次

    加载`servlet`类时，`servlet`容器会创建一个`servlet`实例。通常只会创建一个`servlet`实例，并且在同一个`servlet`实例上执行对该`servlet`的并发请求

-   调用`servlet`的`init`方法，执行一次

    第一个`servlet`被创建时，会调用`init()`方法，该方法允许`servlet`在处理第一个请求之前初始化自己

-   调用`servlet service()`方法，`HTTP`每执行一次请求，就加载到`servlet`

    每一个收到的`servlet`请求，都会调用`servlet service()`方法；`HttpServlet`通常会调用`doGet()`和`doPost()`等方法

    ==只要`servlet`在`servlet`容器中处于活动状态，就可以调用`service()`方法==

-   调用`servlet`的`destory()`方法

    当一个`servlet`被`servlet`容器销毁时或者容器关闭、容器在运行时重新加载整个`web`应用程序，则`servlet`将会被销毁

<img src="/home/huangyue/JavaWeb/pic/08.png" style="zoom:80%;" />

### 三、`Servlet`处理用户请求的流程

<img src="/home/huangyue/JavaWeb/pic/010.png" alt="010"  />





### 四、`ServletConfig`和`ServletContext`

#### 1. `ServletConfig`接口

Tomcat初始化一个`servlet`时，会将该`Servlet`配置信息封装到`ServletConfig`对象中

方法：

|                  方法                  |                         说明                          |
| :------------------------------------: | :---------------------------------------------------: |
| `String getInitParameter(String name)` |       根据初始化参数名返回相对应的初始化参数值        |
| `Enumeration getInitParameterNames()`  | 返回一个`Enumeration`对象，其中包含所有初始化的参数名 |
|  `ServletContext getServletContext()`  |   返回一个代表当前`web`  应用的`ServletContext`对象   |
|       `String getServletName()`        |                  返回`Servlet`的名字                  |

#### 2.`ServletContext`接口

封装当前`web`应用的所有信息，可以利用该对象获取`web`应用程序的初始化信息、读取资源文件等

### 五、`HttpServletRequest`

`HttpServletRequest`方法主要作用是封装`HTTP`请求消息，该接口中定义了获取请求行、请求头和请求消息

#### 1. 获取请求参数

|                    方法                    |                             说明                             |
| :----------------------------------------: | :----------------------------------------------------------: |
|     `String getParameter(String name)`     | 获取某个指定名称的参数值；若请求消息中没有包含指定名称的参数，返回`null`；若未设置值，则返回空字符串；若有多个参数，返回第一个出现的参数 |
| `String[] getParameterValues(String naem)` | 请求信息中包含多个相同名称的参数，若要获得统一参数名所对应的所有参数值，使用该方法，返回一个`String `类型的数组 |
|     `Enumeration getParameterNames()`      | 返回一个包含请求信息中所有参数名的`Enumeration`对象；可以对请求消息中的所有参数进行遍历处理 |
|          `Map getParameterMap()`           |      将请求消息中所有参数名和值装入一个`Map`对象中返回       |

#### 2. `RequestDispatcher`实现请求转发

```jsp
RequestDispatcher getRequestDispatcher(String path)
```

-   返回封装了某条路径所指定资源的`RequestDisptcher`对象
-   `path`必须以`/`开头，表示当前`web`应用的根目录
-   传递的资源也可以是`WEB-INF`目录中的文件

获取`RequestDisptcher`对象后，要通知其他`web`资源处理当前的`Servlet`请求































































