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

## 2、配置dcbp数据库连接池
   ```xml
   <bean id="dataSource"
      class="org.apache.commons.dbcp.BasicDataSource"
      destroy-method="close">
    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://192.168.0.109:3306/test?useUnicode=true&characterEncoding=UTF-8"/>
    <property name="username" value="root"/>
    <property name="password" value="root"/>
    <!--maxActive: 最大连接数量--> 
    <property name="maxActive" value="150"/>
    <!--minIdle: 最小空闲连接--> 
    <property name="minIdle" value="5"/>
    <!--maxIdle: 最大空闲连接--> 
    <property name="maxIdle" value="20"/>
    <!--initialSize: 初始化连接--> 
    <property name="initialSize" value="30"/>
    <!-- 连接被丢弃时是否打印 -->
    <property name="logAbandoned" value="true"/>
    <!--removeAbandoned: 是否自动回收超时连接--> 
    <property name="removeAbandoned"  value="true"/>
    <!--removeAbandonedTimeout: 超时时间(以秒数为单位)--> 
    <property name="removeAbandonedTimeout" value="10"/>
    <!--maxWait: 超时等待时间以毫秒为单位 1000等于1秒-->
    <property name="maxWait" value="1000"/>
    <!-- 在空闲连接回收器线程运行期间休眠的时间值,以毫秒为单位. -->
    <property name="timeBetweenEvictionRunsMillis" value="10000"/>
    <!--  在每次空闲连接回收器线程(如果有)运行时检查的连接数量 -->
    <property name="numTestsPerEvictionRun" value="10"/>
    <!-- 1000 * 60 * 30  连接在池中保持空闲而不被空闲连接回收器线程-->
    <property name="minEvictableIdleTimeMillis" value="10000"/>
    <property name="validationQuery" value="SELECT 1"/>
    </bean>
   ```
