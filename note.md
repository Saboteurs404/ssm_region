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
   
   ```
     <properties>
     <maven.compiler.source>1.8</maven.compiler.source>
     <maven.compiler.target>1.8</maven.compiler.target>
     </properties>
   ```

## 依赖包的选择
