# Guns V2.5

新版Guns基于SpringBoot全面升级,完美整合springmvc + shiro + **MyBatis 通用 Mapper** + **分页插件 PageHelper** + beetl!

# 说明

本项目 fork 自 [stylefeng](http://git.oschina.net/naan1993) 的 [Guns](http://git.oschina.net/naan1993/guns)！

经过对 Guns 项目的修改，使得该项目成为一个通用 Mapper 和 分页插件使用的示例。

项目引入了下面两个依赖：
```xml
<dependency>
    <groupId>tk.mybatis</groupId>
    <artifactId>mapper-spring-boot-starter</artifactId>
    <version>${mapper-starter.version}</version>
</dependency>
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper-spring-boot-starter</artifactId>
    <version>${pagehelper-starter.version}</version>
</dependency>
```
完全使用 MyBatis 官方的 Starter.

一个最简单的 Spring Boot 集成项目：

https://github.com/abel533/MyBatis-Spring-Boot

# 修改说明

本项目对 Guns 的改动为：

1. 将 mybatis-plus 改成了通用 Mapper.
2. 增加分页插件 PageHelper.
3. 去掉`com.stylefeng.guns.modular.system.dao`包中的所有DAO，将方法放到对应的Mapper接口中.
4. 将 Mapper.xml 移动到 resources 中

关于两者的对比，可以通过 commit 信息查看。

更多 MyBatis 相关工具可以访问： http://mybatis.tk

## V2.5更新日志
1. 新增数据范围功能(例如两个角色都有用户管理权限,但是下级部门不能看到上级部门的数据)
2. 代码生成的bug修复,现在兼容windows和linux
3. shiro的过滤器链改为LinkedHashMap
4. 修复添加顶级部门添加不了的bug
5. 解决日期格式化工具类线程安全的问题
6. 修复日志记录会出现多个重复文件的bug

## 功能简介
1. 用户管理
2. 角色管理
3. 部门管理
4. 菜单管理
5. 字典管理
6. 业务日志
7. 登录日志
8. 监控管理
9. 通知管理
10. 代码生成

## 使用说明
1. 导入sql/guns.sql文件到mysql数据库
2. 修改application.yml中的数据库用户名和密码
3. 以maven方式导入项目到ide
4. 修改application.yml中的数据库相关的配置,改为您本机的数据库配置
5. 启动项目,管理员***账号admin/密码111111***

### 如何启动项目
Guns目前支持三种启动方式:
1. 在IDE里运行GunsApplication类中的main方法启动
2. 执行如下maven命令
```
clean package -Dmaven.test.skip=true
```
并从target目录中找到guns-1.0.0-SNAPSHOT.jar,并在jar包的目录下执行如下java命令
```
java -jar guns-1.0.0-SNAPSHOT.jar
```
3. 修改pom.xml中如下片段
```
<packaging>jar</packaging>
```
改为
```
<packaging>war</packaging>
```
并打包放入到tomcat中执行

### 注意
最新版项目最低支持jdk1.7

## 所用框架
### 前端
1. Bootstrap v3.3.6
2. jQuery v2.1.4 
3. bootstrap-table v1.11.1
4. layer v2.1
5. zTree core v3.5.28
6. WebUploader 0.1.5

### 后端
1. SpringBoot 1.5.3.RELEASE
2. MyBatis-通用Mapper-starter 1.1.3
2. MyBats-PageHelper-starter 1.1.2
3. MyBatis 3.4.4
4. Spring 4.3.8.RELEASE
5. Beetl 2.7.15
6. hibernate-validator 5.3.5.Final
7. Ehcache 3.3.1
8. Kaptcha 2.3.2
9. Fastjson 1.2.31
10. Shiro 1.4.0
11. Druid 1.0.31

## 项目包结构说明
```
├─main
│  │  
│  ├─java
│  │   │
│  │   ├─com.stylefeng.guns----------------项目主代码
│  │   │          │
│  │   │          ├─common----------------项目公用的部分(业务中经常调用的类,例如常量,异常,实体,注解,分页类,节点类)
│  │   │          │
│  │   │          ├─config----------------项目配置代码(例如mybtais-plus配置,ehcache配置等)
│  │   │          │
│  │   │          ├─core----------------项目运行的核心依靠(例如aop日志记录,拦截器,监听器,guns模板引擎,shiro权限检查等)
│  │   │          │
│  │   │          ├─modular----------------项目业务代码
│  │   │          │
│  │   │          ├─GunsApplication类----------------以main方法启动springboot的类
│  │   │          │
│  │   │          └─GunsServletInitializer类----------------用servlet容器启动springboot的核心类
│  │   │
│  │   └─generator----------------mybatis-plus Entity生成器
│  │
│  ├─resources----------------项目资源文件
│  │     │
│  │     ├─gunsTemplate----------------guns代码生成模板
│  │     │ 
│  │     ├─application.yml----------------springboot项目配置
│  │     │ 
│  │     └─ehcache.xml----------------ehcache缓存配置
│  │
│  └─webapp----------------web页面和静态资源存放的目录
│  
```
注:SpringBoot项目默认不支持将静态资源和模板(web页面)放到webapp目录,但是个人感觉resources目录只放项目的配置更加简洁,所以就将web页面继续放到webapp目录了.

## 项目特点
1. 基于SpringBoot,简化了大量项目配置和maven依赖,让您更专注于业务开发,独特的分包方式,代码多而不乱。
2. 完善的日志记录体系，可记录登录日志，业务操作日志(可记录操作前和操作后的数据)，异常日志到数据库，通过@BussinessLog注解和LogObjectHolder.me().set()方法，业务操作日志可具体记录哪个用户，执行了哪些业务，修改了哪些数据，并且日志记录为异步执行，详情请见@BussinessLog注解和LogObjectHolder,LogManager,LogAop类。
3. 利用beetl模板引擎对前台页面进行封装和拆分，使臃肿的html代码变得简洁，更加易维护。
4. 对常用js插件进行二次封装，使js代码变得简洁，更加易维护，具体请见webapp/static/js/common文件夹内js代码。
5. 利用ehcache框架对经常调用的查询进行缓存，提升运行速度，具体请见ConstantFactory类中@Cacheable标记的方法。
6. controller层采用map + warpper方式的返回结果，返回给前端更为灵活的数据，具体参见com.stylefeng.guns.modular.system.warpper包中具体类。
7. 防止XSS攻击,通过XssFilter类对所有的输入的非法字符串进行过滤以及替换。
8. 简单可用的代码生成体系，通过SimpleTemplateEngine可生成带有主页跳转和增删改查的通用控制器、html页面以及相关的js，还可以生成Service和Dao，并且这些生成项都为可选的，通过ContextConfig下的一些列xxxSwitch开关,可灵活控制生成模板代码，让您把时间放在真正的业务上。
9. 控制器层统一的异常拦截机制,利用@ControllerAdvice统一对异常拦截,具体见com.stylefeng.guns.core.aop.GlobalExceptionHandler类。
10. 页面统一的js key-value单例模式写法，每个页面生成一个唯一的全局变量，提高js的利用效率，并且有效防止多个人员开发引起的函数名/类名冲突，并且可以更好地去维护代码。

## 基于javabean方式的spring配置
Guns以简洁为核心,抛弃了传统的易错,臃肿xml配置,采用javabean的方式配置spring,简化了项目的配置,如下示例为配置mybatis-plus和数据源:
```
@Configuration
@MapperScan(basePackages = {"com.stylefeng.guns.modular.*.dao", "com.stylefeng.guns.common.persistence.dao"})
public class MybatisPlusConfig {

    @Autowired
    DruidProperties druidProperties;

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType(DBType.MYSQL.getDb());
        return paginationInterceptor;
    }

    /**
     * druid数据库连接池
     */
    @Bean(initMethod = "init")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.coinfig(dataSource);
        return dataSource;
    }
}
```

## 业务日志记录原理
日志记录采用aop(LogAop类)方式对所有包含@BussinessLog注解的方法进行aop切入，会记录下当前用户执行了哪些操作（即@BussinessLog value属性的内容），如果涉及到数据修改，会取当前http请求的所有requestParameters与LogObjectHolder类中缓存的Object对象的所有字段作比较（所以在编辑之前的获取详情接口中需要缓存被修改对象之前的字段信息），日志内容会异步存入数据库中（通过ScheduledThreadPoolExecutor类）。

## beetl对前台页面的拆分与包装
例如，把主页拆分成三部分，每个部分单独一个页面，更加便于维护
```
<!--左侧导航开始-->
    @include("/common/_tab.html"){}
<!--左侧导航结束-->

<!--右侧部分开始-->
    @include("/common/_right.html"){}
<!--右侧部分结束-->

<!--右侧边栏开始-->
    @include("/common/_theme.html"){}
<!--右侧边栏结束-->
```
以及对重复的html进行包装，使前端页面更加专注于业务实现，例如,把所有页面引用包进行提取
```
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit" /><!-- 让360浏览器默认选择webkit内核 -->

<!-- 全局css -->
<link rel="shortcut icon" href="${ctxPath}/static/favicon.ico">
<!-- 全局js -->
<script src="${ctxPath}/static/js/jquery.min.js?v=2.1.4"></script>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		${layoutContent}
	</div>
	<script src="${ctxPath}/static/js/content.js?v=1.0.0"></script>
</body>
</html>
```
开发页面时，只需编写如下代码即可
```
@layout("/common/_container.html"){
<div class="row">
    <div class="col-sm-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>部门管理</h5>
            </div>
            <div class="ibox-content">
               //自定义内容
            </div>
        </div>
    </div>
</div>
<script src="${ctxPath}/static/modular/system/dept/dept.js"></script>
@}
```
以上beetl的用法请参考beetl说明文档。

## 对js常用代码的封装
在webapp/static/js/common目录中，有对常用js代码的封装，例如Feng.js,其中Feng.info(),Feng.success(),Feng.error()三个方法，分别封装了普通提示，成功提示，错误提示的代码，简化了layer提示层插件的使用。

## 极简的图片上传方法
guns对web-upload进行二次封装,让图片的上传功能呢只用2行代码即可实现,如下
```
var avatarUp = new $WebUpload("avatar");
avatarUp.init();
```
具体实现请参考static/js/common/web-upload-object.js

## 独创controller层，map+warpper返回方式
map+warpper方式即为把controller层的返回结果使用BeanKit工具类把原有bean转化为Map的的形式(或者原有bean直接是map的形式)，再用单独写的一个包装类再包装一次这个map，使里面的参数更加具体，更加有含义，下面举一个例子，例如，在返回给前台一个性别时，数据库查出来1是男2是女，假如直接返回给前台，那么前台显示的时候还需要增加一次判断，并且前后端分离开发时又增加了一次交流和文档的成本，但是采用warpper包装的形式，可以直接把返回结果包装一下，例如动态增加一个字段sexName直接返回给前台性别的中文名称即可。

## 独创mybatis数据范围拦截器,实现对数据权限的过滤
Guns的数据范围控制是指,对拥有相同角色的用户,根据部门的不同进行相应的数据筛选,如果部门不相同,那么有可能展示出的具体数据是不一致的.所以说Guns对数据范围控制是以部门id为单位来标识的,如何增加数据范围拦截呢?只需在相关的mapper接口的参数中增加一个DataScope对象即可,DataScope中有两个字段,scopeName用来标识sql语句中部门id的字段名称,例如deptiid或者id,另一个字段deptIds就是具体需要过滤的部门id的集合.拦截器原理如下:拦截mapper中包含DataScope对象的方法,获取其原始sql,并做一个包装限制部门id在deptIds范围内的数据进行展示.

## swagger api管理使用说明
swagger会管理所有包含@ApiOperation注解的控制器方法，同时，可利用@ApiImplicitParams注解标记接口中的参数，具体用法请参考CodeController类中的用法。
```
 @ApiOperation("生成代码")
 @ApiImplicitParams({
         @ApiImplicitParam(name = "moduleName", value = "模块名称", required = true, dataType = "String"),
         @ApiImplicitParam(name = "bizChName", value = "业务名称", required = true, dataType = "String"),
         @ApiImplicitParam(name = "bizEnName", value = "业务英文名称", required = true, dataType = "String"),
         @ApiImplicitParam(name = "path", value = "项目生成类路径", required = true, dataType = "String")
 })
 @RequestMapping(value = "/generate", method = RequestMethod.POST)
```

## 效果图
![输入图片说明](https://git.oschina.net/uploads/images/2017/0604/194616_36ed7fd6_551203.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0604/194623_a0761bc3_551203.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0604/194630_640dfd35_551203.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0526/104015_bdb14c74_551203.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0516/000735_b83c5c46_551203.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0526/103734_bd3e8f6b_551203.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0604/194539_f9bb482a_551203.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0526/103746_6b4129ed_551203.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0526/103755_7729b916_551203.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0526/103801_b8216865_551203.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0526/103807_20bfb868_551203.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0526/103814_67e078bb_551203.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0526/103822_58fd5d91_551203.png "在这里输入图片标题")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0526/103827_d6218c74_551203.png "在这里输入图片标题")

