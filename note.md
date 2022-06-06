## 1、springMvc中视图解析器的详细配置
    视图解析器

    springmvc中View Resolver负责将处理结果生成View视图，处理器执行完业务逻辑后将带有逻辑视图的ModelAndView返回给前端控制器，
    前端控制器再将ModelAndView发送给视图解析器，视图解析器（View Resolver）首先根据逻辑视图名解析成物理视图名即具体的页面地址，
    再生成View视图对象，最后对View进行渲染将处理结果通过页面展示给用户。
    
    视图解析器使用SpringMVC框架默认的InternalResourceViewResolver，这个视图解析器支持JSP视图解析
    
    在springmvc.xml配置文件中配置如下：
    
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    
    <!-- 配置逻辑视图的前缀 -->
    
    <property name="prefix" value="/WEB-INF/jsp/" />
    
    <!-- 配置逻辑视图的后缀 -->
    
    <property name="suffix" value=".jsp" />
    
    </bean>
    
    逻辑视图名需要在controller中返回的ModelAndView中指定，比如逻辑视图名为ItemList，则最终返回的jsp视图地址为:
    
    “WEB-INF/jsp/itemList.jsp”
    
    最终jsp物理地址：前缀+逻辑视图名+后缀
