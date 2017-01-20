# Spring
- Tomcat加载机制
* spring框架是一个轻量级的面向企业级开发的一站式解决方案，使用简单的POJO（Plain Old Java Object）来进行企业级开发，每一个被spring管理的对象称之为Bean；并且Spring提供了一个IOC容器用来初始化对象，解决对象间的依赖管理和对象的使用，其历史发展中依次采用了如下的配置方式：
1. XML配置
* Spring项目可以包含多个XML配置文件，每个XML配置文件中可包含多个bean；通过类的包路径引入Bean
* 可以使用<import /> 导入其他的配置文件
2. 注解配置。应用的基本配置（如数据库配置）使用XML，业务配置使用注解
3. Java配置
* 可以有多个包含@Configuration注解的配置类，每个配置类也可以有多个包含@Bean注解的Bean；通过函数返回的形式生成Bean
* 可以使用@Import注解引入其他配置类  `@Import({ CustomerConfig.class, SchedulerConfig.class })`
* bean标签属性
- id/class/parent
* abstract/dependency-check
* 依赖注入(Dependency Injection)
* 通过Setter方法
```
<bean id="OutputHelper" class="com.yiibai.output.OutputHelper">
<property name="outputGenerator">
<ref bean="CsvOutputGenerator" />
</property>
</bean>
```
* 通过构造函数。当存在多个构造函数时，会存在歧义，可以通过在配置文件中指定构造函数参数类型解决
```
<bean id="OutputHelper" class="com.yiibai.output.OutputHelper">
<constructor-arg type="*">
<bean class="com.yiibai.output.impl.CsvOutputGenerator" />
</constructor-arg>
</bean>
```
- 如果一个Bean只在一个特定的类中使用，则可以将其声明为内部Bean
- 注入值到Spring中的Bean属性的三种方式
* 正常方式 `<property name="name"> <value>chengfeng</value> </property>`
* 快捷方式 `<property name="name" value="yiibai" />`
* ‘p’方式 `<bean id="FileGenerator" class="com.yi.FileGenerator" p:name=“test” p:type="txt"/>`，需要在Spring XML Bean配置文件中，声明命名空间 `xmlns:p=”http://www.springframework.org/schema/p”`
* Spring注入值到集合类型（List、Map、Set、Properties）
* ListFactoryBean/MapFactoryBean/SetFactoryBean
* DateFormat 工厂方法将字符串转换为日期
* 4种依赖检查支持的模式(@Required，加载某个Setter方法上)，确定特定属性已设置
* none: 默认
* simple: 如果是基本类型，如int/long/double/map/list/set属性未设置，将抛出UnsatisfiedDependencyException
* objects: 如果对象类型的任何类型未设置，将抛出UnsatisfiedDependencyException
* all: 如果任何类型的属性未设置，将抛出UnsatisfiedDependencyException
* 也可以直接在beans标签里设置 `<beans default-dependency-check=“simple/objects/all”></beans>`
* @Required 可以指定具体某一个属性，相比以上方法指定一类属性，更加灵活；配置文件中需包含RequiredAnnotationBeanPostProcessor
* Spring Bean作用域
* 单例(Singleton)：每个Spring IoC容器返回一个Bean实例，默认作用域
* 原型(Prototype)：每次请求，都会返回一个新的Bean实例，`scope="prototype”` 或者 @Scope(“prototype”)
* 请求：返回每个HTTP请求的一个Bean实例
* 会话：返回每个HTTP会话的一个Bean实例
* 全局会话：返回全局HTTP会话的一个Bean实例
* Spring加载配置多个配置文件的两种方式
* `ApplicationContext cxt = new ClassPathXmlApplicationContext(new String[]{"1.xml","2.xml","3.xml”});`
* 在applicationContext.xml中 使用import导入，如`<import resource="common/Spring-Common.xml"/>`
* spring context主要负责加载bean、资源文件、消息读取等
* spring主要模块，spring是模块化的，主要分为以下几个部分的模块：
1. 核心容器
* Spring-Core: 其它模块大量使用Spring-Core
* Spring-Beans: Spring定义Bean的支持
* Spring-Context: 运行时Spring容器
* Spring-Context-Support: Spring容器对第三方包的集成支持
* Spring-Expression: 使用表达式语言在运行时查询和操作对象
2. AOP
* Spring-AOP: 基于代理的AOP支持
* Spring-Aspects: 基于AspectJ的AOP支持
3. Web
* Spring-Web: 提供基础的Web集成功能
* Spring-WebMVC: 提供基于Serlet的SpringMVC
* Spring-WebSocket: 提供WebSocket功能
* Spring-WebMVC-PortLet: 提供PortLet环境支持
4. 消息
* Spring-Messaging: 对消息架构和协议的支持
5. 数据访问和集成
* Spring-JDBC: 提供以JDBC访问数据库的支持
* Spring-TX: 提供编程式和声明式的事务支持
* Spring-ORM: 提供对对象/关系映射技术的支持
* Spring-OXM: 提供对对象/XML映射技术的支持
* Spring-JMS: 提供对JMS的支持
* Spring框架四大原则
1. 使用POJO进行轻量级和最小侵入式开发
2. 通过依赖注入和基于接口编程实现松耦合
3. 通过AOP和默认习惯进行声明式编程（注解）
4. 使用AOP和模板减少模式化代码
* Spring支持5种自动装配模式
* no 默认情况，通过ref属性手动设定
* byName 根据属性名称自动装配
* byType 根据数据类型自动装配
* constructor 在构造函数参数上的byType方式
* autodetect 如果找到默认的构造函数，使用『自动装配构造』；否则使用『按类型自动装配』
* IoC依赖注入和控制反转：依赖注入是指由容器负责创建对象和维护对象之间的依赖关系，而不是通过对象本身负责自己的创建和解决自己的依赖。
* AOP: 面向切面编程，目的是为了解耦
* 使用Aspect生命一个切面
* 使用@After、@Before、@Around定义建言（advice），可直接将拦截规则(切点)作为参数
* 其中，拦截规则称为切点（PointCut），为了使切点复用，可使用@PointCut专门定义拦截规则，然后在@After、@Before、@Around的参数中调用
* 其中符合条件的每一个被拦截处为连接点（JoinPoint）
- 注解，是描述数据的数据，即元数据。可以描述注解、包、类、方法、构造方法、成员变量、局部变量、参数等
* 常见的注解：@Override @Deprecated @SuppressWarnings(抑制警告)
* 使用@interface声明一个注解，其中的每一个方法实际上是声明了一个配置参数。方法的名称就是参数的名称，返回值类型就是参数的类型（返回值类型只能是基本类型、Class、String、enum）。可以通过default来声明参数的默认值。如果注解中只有一个属性，可以使用value代替，不再标注属性名称。
> @Target 表示该注解用于什么地方，可能的值在枚举类 ElemenetType 中，包括： 
>           ElementType.CONSTRUCTOR 构造器声明 
>           ElementType.FIELD 域声明（包括 enum 实例） 
>           ElementType.LOCAL_VARIABLE 局部变量声明
> 
>           ElementType.ANNOTATION_TYPE 作用于注解类声明
>           ElementType.METHOD 方法声明
> 
>           ElementType.PACKAGE 包声明 
>           ElementType.PARAMETER 参数声明 
>           ElementType.TYPE 类，接口（包括注解类型）或enum声明 
>            
>      @Retention 表示在什么级别保存该注解信息。可选的参数值在枚举类型 RetentionPolicy 中，包括： 
>           RetentionPolicy.SOURCE 编译之后丢弃注解
>           RetentionPolicy.CLASS 类加载完成后，丢弃注解，在class文件中可用，但会被JVM丢弃，即只在编译器有效 
>           RetentionPolicy.RUNTIME JVM将在运行期也保留注释，因此可以通过反射机制读取注解的信息。 
>            
>       @Documented 将此注解包含在 javadoc 中 ，它代表着此注解会被javadoc工具提取成文档。在doc文档中的内容会因为此注解的信息内容不同而不同。相当与@see,@param 等。
>        
>       @Inherited 允许子类继承父类中的注解，例子中补充。

* 声明Bean的注解
* @Component组件，没有明确的角色
* @Service在业务逻辑层（service层）使用
* @Repository在数据访问层（dao层）使用
* @Controller在展现层（MVC→Spring MVC）使用
* 注入Bean的注解，一般情况下通用，可注解在set方法上或者属性上。
* @Autowired: Spring提供的注解
* @Inject 
* @Resource
- Java配置：通过@Configuration和@Bean实现
* @Configuration声明当前类是一个配置类，相当于Spring配置的XML文件
* @Bean注解在方法上，声明当前方法的返回值为一个Bean
* Scope：描述Spring容器是如何创建Bean实例的
* Singleton: 单例，默认配置
* Prototype: 每次调用新建一个Bean实例
* Request: 为每一个Http Request新建一个Bean实例
* Session: 为每一个Http session新建一个Bean实例
* GlobalSession
* Bean的初始化和销毁
* @PostConstruct 在Bean构造函数执行完之后的操作，类似XML配置中的init-method
* @PreDestory 在Bean销毁之前的操作，类似XML配置中的destroy-method

















