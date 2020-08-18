## HandlerInterceptor
https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/HandlerInterceptor.html

处理器拦截器，对handler进行拦截处理

<hr>

### 三个方法
preHandle
    在HandlerAdapter调用handler方法之前执行
postHandle
    在HandlerAdapter调用handler方法之后执行
    注意：这里视图未完成渲染，可以对产生的modelView对象进行后置处理
afterCompletion
    Callback after completion of request processing, that is, after rendering the view.
    在完成request请求之后回调，注意：这里是在视图渲染完成之后
    
    

处理过程：org.springframework.web.servlet.DispatcherServlet.doDispatch


##子接口 
org.springframework.web.servlet.AsyncHandlerInterceptor
新增方法：afterConcurrentHandlingStarted
针对于异步请求：{@code postHandle} and {@code afterCompletion}方法将不会生效
该方法将会被回调

##子类
HandlerInterceptorAdapter
AsyncHandlerInterceptor的子类，提供一个通用模板

