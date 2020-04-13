## Servlet 生命周期

- `init()` 初始化
- `service() `处理客户端请求
- `destroy()` 终止方法
- `Servlet`最后由`JVM`垃圾回收器进行垃圾回收

### `init()` 方法

- 只在第一次创建 Servlet 时被调用，后续用户请求时不在调用

- 每调用一个 Servlet 就会创建一个 Servlet 实例

    ```java
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2初始化");
    }
    ```

### `service()` 方法

- 执行实际任务的主要方法

- `Servlet` 容器调用 `service() `方法处理客户端的请求，并把格式化的响应回给客户端

- 服务器每收到一个 `Servlet`请求，就会产生一个新线程并调用服务

- `service()` 方法检查 HTTP 请求类型（`GET、POST、PUT、DELETE` 等），并在适当的时候调用 `doGet`、`doPost`、`doPut`，`doDelete` 等方法。

    ```java
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {}
    ```

### `doGet()` 方法

- `GET` 请求来自于 `URL` 正常请求，或者来自一个未指定 `METHOD` 的 `HTML `表单，由 `doGet()` 方法处理

```java
public void doGet(){
    System.out.println("get 请求");
}
```

### `doPost()` 方法

- `POST` 方法来自于一个特定了 `METHOD`为`POST`的`HTML`表单，由`doPost()`方法处理

```java
public void doPost(){
    System.out.println("post 获取");
}
```

### `destroy() `方法

- 只会在Servlet 生命周期结束时被调用
- 该方法可以使Servlet关闭数据库连接、停止后台线程、把cookie列表或点击计数器写入磁盘，并执行其他类似的清理活动
- 该方法被调用后，servlet对象被标记为垃圾回收

```java
public void destroy() {
    System.out.println("4销毁");
}
```

### 架构图

<img src="C:\Users\HUANGYUE\Documents\GitHub\JavaWeb\Servlet\picture\Servlet-LifeCycle.jpg" style="zoom:80%;" />

- 第一个到达服务器的`HTTP`请求被派到`Servlet`容器
- `Servlet`容器在调用`service() `方法之前加载 `Servlet`
- 然后`Servle`t容器处理多个线程产生的多个请求，每一个线程执行一个单一的 `Servlet` 实例的 `service() `方法

















































































