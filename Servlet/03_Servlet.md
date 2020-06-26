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







































#### 1. `Servlet`接口

在开发中，任何一个`Servlet`对象都要直接或间接实现`javax.servlet.Servlet`接口

五个方法：

|                             方法                             |                             说明                             |
| :----------------------------------------------------------: | :----------------------------------------------------------: |
|           `publiv void init(ServletConfig config)`           | `Servlet`实例化后，`Servlet`容器调用该方法来完成初始化工作（出生之后，仅调用一次） |
| `public void service(ServletRequest request,ServletResponse response)` |             处理客户端请求，每次请求时都会被调用             |
|                   `public void destory()`                    | `Servelt`对象在`Servelt`容器内被移除时，容器调用该方法，以便释放资源（临死之前，仅调用一次） |
|          `public ServletConfig getServletConfig()`           |   用于获取`Servlet`对象的配置信息，返回`ServletConfig`对象   |
|               `public String getServletInfo()`               |        返回有关`Servlet`的信息，是纯文本格式的字符串         |

