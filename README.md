## 1-项目框架：SSM

    JDK版本：1.8.0_152
    maven:3.8.5
    tomcat:9.0.63
    编译环境IDEA 2022
    MySQL server 8.0
    navicat150_premium_cs_x64

## 项目框架简单说明：
    
    1、pom.xml是maven的配置文件，我们需要什么jar包，都可以在里面添加依赖
        ，然后maven就会自己帮我们下到本地仓库里面
    2、接下来就需要构思项目所需的文件结构：
        main下新建一个java,用来放java文件，
        src下新建一个test，用来放测试文件
        main下新建一个resources文件，
    3、src->main->java下新建package com，再新建xlh ，这两个对应我们刚开始的groupid
    4、xlh下新建四个包：controller用来存放前台url映射地址，
                     dao用来存放与数据库的接口文件
                     entity用来存放实体类文件
                     service用来存放自己定义的接口
    5、配置文件:
        applicationContext.xml:是spring配置文件
        sqlmap文件里存放实体与数据库的映射文件
        generatorConfig.xml和generator.properties是mybatis的配置文件
        jdbc.properties是数据库相关信息
        log4j.properties是日志配置文件
        webapp下新建css、images、js等文件，用来存放前端资源
        web-inf下新建views文件夹，jsp文件就放在这里面

## 注意事项
     
    1、maven项目管理工具，如果我们不告诉他我们的代码要使用什么样的jdk版本编译的话，他就会用
       maven-compiler-plugin默认的jdk版本来进行处理，这样就容易出现版本不匹配，以至于导致编译不通过的问题
    2、maven在我电脑上默认使用的jdk为1.7，但是我使用的jdk版本为1.8
    3、由于是maven没指定编译版本引起的先在pom.xml指定编译版本，添加如下指定编译版本（一般情况下和所有jdk版本保持一致，如我这里是1.8）
   
   ```xml
     <properties>
     <maven.compiler.source>1.8</maven.compiler.source>
     <maven.compiler.target>1.8</maven.compiler.target>
     </properties>
   ```

## 依赖包的选择
    1、由于注入spring核心依赖较多，所以通过如下代码，统一spring依赖的版本

  ```xml
      <!-- spring版本号 -->
      <spring.version>5.2.22.RELEASE</spring.version>
      <!-- mybatis 版本号-->
  ```

    2、还需注意的是spring的.RELEASW为稳定版，所以一般选择该版本，并不是越新越好

## spring项目中每个jar包的作用
        
    1、commons-logging.jar
        记录程序运行时的活动日志记录
    2、spring-aop.jar
        在程序使用spring的AOP特性时需要的类，比如声明式事务管理
    3、spring-core.jar
        包含spring框架基本的核心工具类，spring的其他组件都需要使用这个包里的类
    4、spring-context.jar
        为spring核心提供大量的扩展，可以找到在使用spring applicationcontext特性时用到的所有的类
    5、spring-beans.jar
        访问配置文件，创建和管理bean以及进行控制反转依赖注入操作相关的类
    6、spring-experssion.jar
        spring表达式语言
    7、spring-web.jar
        这个jar文件包含web应用开发时，用到spring框架时所需要的核心类，包括自动载入
        webapplicationcontext 特性类，steuts与jsf集成类，文件上传的支持类，filter类和大量的工具辅助类
    8、spring-tx.jar
        为jdbc,hibernate,jdo,jpa等提供的一致的声明式和编程式事务管理
    9、aopalliance.jar
        包含了针对面向切面的一些接口
    10、aspectjrt.jar
        提供对sqpectj的支持，以便可以方便的将面向方面的功能集成进ide中
    11、spring-dao.jar
        这个jar文件包含Spring DAO,Spring Transcation进行数据访问的所有类
    12、spring-jdbc.jar
        这个jar文件包含对spring对JDBC数据访问进行封装的所有类
    13、spring-hibernate.jar
        这个jar文件包含spring对hibernate 2及hibernate 3进行封装的所有类
    14、spring-orm.jar
        这个jar文件包含spring对DAO特性集进行了扩展，使其支持iBATIS、JDO、OJB、TopLink,
        因为hibernate已经独立成包了，现在不包含在这个包里了。这个jar文件里大部分的类都要依赖
        spring-dao.jar里的类，用这个包时你需要同时包含spring-dao.jar包
    15、spring-remoting.jar
        这个jar文件包含支持EJB、JMS、远程调用Remoting（RMI、Hessian、Burlap、Http Invoker、JAX-RPC）方面的类
    16、spring-suppoprt.jar
        这个jar文件包含支持缓存Cache（ehcache）、JCA、JMX、邮件服务（java Mail,COS MAil）、任务计划Schedling(Timer、Quartz)方面的类
    17、spring-webmvc.jar
        这个jar文件包含Spring MVC框架相关的所有类。包含国际化、标签、Theme、视图展现的FreeMarker、JasperReports、Tiles、Velocity、XSLT相关类。
        当然，如果你的应用使用了独立的MVC框架，则无需这个JAR文件里的任何类
    18、spring-mock.jar
        这个jar文件包含Spring一整套mock类来辅助应用的测试。Spring测试套件使用了其中大量mock类，这样测试就更加简单。
        模拟HttpServletRequest和HttpServletResponse类在Web应用单元测试是很方便的。

## mybatis常见接口和jar包介绍
    Mybatis是一款持久层框架，它支持定制化sql、存储过程以及高级映射。mybatis避免了几乎所有的JDBC
    代码和手动设置参数以及获取结果集。Mybatis可以使用简单XML或注解来配置和映射原生信息，将接口和java
    的POJOS(普通的java对象)映射成数据库中的记录
    1、mybatis的jar包
        mybatis的核心包只有一个mybatis-3.x.0.jar,另外还有一些可选的依赖包（日志、代理等所需要的）
    2、mybatis框架中一般需要两种文件
        第一种：mybatis的配置文件：mybatis-config.xml,其中包括数据库连接信息，类型别名等等
        第二种：mybatis的映射文件：XxxxxMapper.xml,这个xml文件中包括Xxxx类所对应的数据库表
              的各种增删改查sql语句
    3、mybatis中的映射文件接口XxxxMapper.java(对XxxxMapper.xml中的sql语句进行映射)
        mybatis中除了必须的jar包、各种xml配置文件之外，一般还需要有调用sql语句执行的接口Xxxxmapper.java
    4、mybatis中的SqlSession接口和SqlSessionFactory接口
        sqlSession接口的实现类对象是mybatis中最重要的一个对象，我们可以使用该对象动态获取XxxxMapper.java
        接口实现类对象，然后就可以调用XxxxMapper.java接口中的方法所映射的sql语句（在xml文件中配置的sql语句）
        sqlSessionFactory接口的实现类对象是一个工厂对象，专门负责来产生sqlsession对象的

## Mybatis和Spring的集成
    在学习mybatis配置时，对于mybatis-config配置的时候我们发现，大致是需要配置三个方面：setting、datasource、mappers

    而mybatis的setting往往使用默认配置，所以我们经常配置datasource数据源与mappers映射，但学习spring之后发现，
    对于datasource的配置交由spring进行管理，所以在spring与mybatis整合后mybatis的配置文件中将不需要配置datasource，
    mybatis的配置几乎都会在Spring配置之中完成。当然要想要实现spring与mybatis的整合，其中最重要的就是 mybatis-spring.jar 包
    
    1）mybatis-spring会用于帮助你将Mybatis代码无缝的整合到spring中
    2）spring将会加载必要的mybatis工厂类和session类
    3）提供一个简单的方式来注入Mybatis数据映射器和sqlSession到业务层的bean中
    4）方便集成spring事物
    5）翻译Mybatis的异常到spring的DataAccessExcrption异常（数据访问异常）中
    
<font color=#FF0000 >这里需要注意的是，需要考虑Mybatis-spring版本的兼容性，我们在选择spring、mybatis以及mybatis-spring时，应该注意版本之间的兼容性 </font>
 