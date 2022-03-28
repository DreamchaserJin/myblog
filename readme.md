## 一、前言

### 1.项目背景

此项目并非原创，项目原型是李仁密老师的作品，具体的教学视频来自b站https://www.bilibili.com/video/BV1nE411r7TF，不过up主貌似也是搬运的。
此个人博客前端是模仿李仁密老师的，其中，我根据自身需求做出了部分修改。
因为我是主后端的，所以想借此机会来锻炼自己，所以后端部分完全由自己来设计编写（不过异常的控制器和博客内容转html这部分是借鉴了李仁密老师的）。
为此在完成项目并测试之后我写了这篇博文来记录我的项目思路和遇到的一些问题，对于一些想学习SpringBoot，SSM，thymeleaf，semantic UI的人来说，这应该是个很好的练手项目。

### 2.部分效果图展示
话不多说，先放几张效果图展示一下项目
![请添加图片描述](https://img-blog.csdnimg.cn/20200726101821672.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
![请添加图片描述](https://img-blog.csdnimg.cn/20200726101819147.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
![请添加图片描述](https://img-blog.csdnimg.cn/20200726101819826.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
![请添加图片描述](https://img-blog.csdnimg.cn/20200726101819953.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
![请添加图片描述](https://img-blog.csdnimg.cn/20200726101820787.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![请添加图片描述](https://img-blog.csdnimg.cn/20200726101822443.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

## 二、项目总述

### 1.项目总述
此项目为个人博客系统，分前台和后台。前台负责展示你的博客，且页面适配移动端（不过不是我的功劳，是老师lirenmi的功劳）。管理员可以登录后台来对博客、分类、评论等进行管理。
### 2.技术栈选择
前端：Semantic UI、thymeleaf
后端：SpringBoot、Spring、SpringMVC、Mybatis

### 3.环境介绍
数据库：mysql8.0
数据库连接池：Druid
前端框架：Semantic UI、thymeleaf模板引擎
后端框架：SpringBoot、SSM
语言：Java
jdk版本：11.0.5（我个人是没怎么用语法糖的，按理来说jdk8以上都可以运行）
编写的IDE：IDEA 2020.1
插件引用:
lombok(简化部分代码插件)、animate.css-master(动画效果)、editor.md-master（markdown插件）、prism（代码高亮）、tocbot-master（目录生成）、typo.css-master（网页排版）、logback（日志记录）

## 三、设计思路
接下来，我来讲讲我是如何一步一步来设计后台，当然过程仅供参考，勿喷。

### 1.根据实际背景制定相应的策略

首先开始设计的时候我已经完成了前端页面的制作

以下当时完成的前端页面：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726104104678.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)![在这里插入图片描述](https://img-blog.csdnimg.cn/2020072610422915.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726104318836.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)    

### 2.总览项目，抽象功能，化为实体，画出设计图
这时候我还并没有开始写代码，而是把接下来要怎么做写个粗略的文档并画出相应的设计图（不过这也是我的习惯，我喜欢在写代码前先把思路写好，再去写代码，虽然写文档的时候确实会花一些时间，不过写代码的时候思路会很清晰，这会省下不少时间，并且能让你的代码结构清晰不少）

因为我写完前端的页面（不过后台只写了两张），所以先把所需的前端页面画出，再把这些页面汇总得到我第一张设计图——前端页面设计图
![前端页面设计](https://img-blog.csdnimg.cn/2020072610523927.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)


然后我就根据页面来分析我需要的功能，由此我画出了第二张设计图
![根据页面写出功能](https://img-blog.csdnimg.cn/20200726105055808.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)随后我根据这些功能抽象分离，并划分所需的类，由此我得到了第三张设计图——UML图
![UML图](https://img-blog.csdnimg.cn/20200726105525456.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

### 3.建库建表

至此，项目结构大致清晰了。根据这个类的划分我利用Navicat开始建表（当然PowerDeigner是个很好用的工具，可以让你在一边设计的同时完成建表的工作，但无奈我不太会用，所以采取原始的方式）。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726105853285.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

### 4.搭建框架结构

建完表后我开始搭建框架，先把最基础的那些建出来，分出最基本的Mapper（Dao）层、Service层、Controller层，pojo层（实体类），然后把写好的前端页面给搬过来，再配置所需要的依赖。经过一系列操作后，最基础的框架搭成了（SpringBoot已经简化了很多很多，这个操作还是蛮快的）。

然后再借助tablego神器，直接生成实体类和相应的mapper文件（当然接口还是要自己写的）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726110633679.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
然后再对接口加些基本的增删改查操作。

到此基本的框架已经出来了，接下来的不过是根据页面实现相应的功能。

### 5.接口设计

唯一值得一提的是接口的设计，这是一门大学问，我原先的想法是采用restful风格来设计接口，但是实际操作中还是遇到了些问题。因为这个项目并不是正宗的前后端分离项目，后端实际上还承担了一部分渲染的工作，对于一些前端页面的变化都需要后端来完成，这样**后端接口数量会因这些变化急速增长，接口设计巧不巧秒就成了至关重要的一环，因为如果接口设计少了，那么就无法应对前端错综复杂的变化，设计多了那么后端系统将会变得极其复杂，不便于后期维护。**

举个例子，比如前端有个分页查询的需求，后端需根据查询的条件和分页来返回数据，如果说将这个查询和分页分开成为多个接口，那么系统将很繁杂，尤其是restful风格，难道你要对同一个资源针对不同情况命名多次？这显然不现实，所以你要解决的问题就是如何做到一个接口应对多种不同情况。

我的解决思路是采用map来接收前端数据，如果map中有相应的数据则做相应的处理。当然这需要前端的配合，不过前后端都是我写的，规矩自然由我来定。**前后端不分离好处就在于此，但坏处也显而易见，后端承担前端的部分工作，那么系统复杂度会极度攀升。**

说完设计接口，接下来要注意的就是一些细节的地方，比如前端没有传回相应的数据，但是如果将实体类传入做增删改查，那么没有数据的部分就是为null，而你又想要默认值，那么你要么在实体类中加默认值，要么别用实体类，用map传值。再比如null的处理，String和Integer的处理。这些都是细节，但往往出bug的都是这些细节！！！

等我做了大部分功能后，忽然发现架构的时候comment实体类和blog实体类少了个别属性，唉，无奈只能慢慢改。
**所以你需要记住架构的时候千万要架构好，不然等你写代码的时候再来改，那改的成本就不是一星半点儿了。**

后来针对页面做出了点调整和优化，将修改页和新增页合为一体，随后修改了我的设计图
![前端设计图（修改后）](https://img-blog.csdnimg.cn/20200726113411208.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![根据页面写出功能（修改后）](https://img-blog.csdnimg.cn/20200726113417168.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)再往后，就是一步一步写相应页面的代码了，一开始遇到很多问题，写了两个页面就花了我四天，不过解决了相应的问题后，后面的页面就写的很快了，前前后后花了半个月时间，终于完成。在这个过程中我查了无数的博客，学到了很多很多，**不得不说做项目是最好的提升方式**。

哦，对了，跟你们分享一下我的习惯，我写代码的时候一般都会把遇到的问题记录下来，做出总结，前一天没有完成的任务我也会记录下来，以便第二天工作的开展，以下是我制作博客的文件夹
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726121956120.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

甚至是我在写这篇博客的时候我都提前写个简单的大纲，避免思路的中断

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020072612202269.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)这样的习惯对于我而言还是蛮好的，它让我执行重要事情的时候可以更有条理，不会有那种大敌当前却手忙脚乱的感觉。



## 四、项目结构

### 1.数据库结构
库名：myblog
blog表结构：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726115856995.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)comment表结构：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726115926363.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
type表结构：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726120035790.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)tag表结构：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726120109473.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
user表结构：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726120155299.png)

### 2.项目结构
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726120343467.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726120454753.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726120515368.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020072612055884.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

标准的SpringBoot结构！


## 五、项目思路
在这个模块，我来讲讲我做项目过程中几个关键问题的解决思路

### 1.用户登录
我这里采用的是一种比较常规的手法，那就是拦截器+session的组合。

首先写个拦截器，对所有访问后台的请求进行拦截，如果该请求的session中没有user对象，则拦截并将其重定向到登录页面（这里要注意登录页面不能被自己给拦截了）。如果存在该user对象，则放行通过
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020072615142020.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)登录的时候验证管理员账户密码，如果正确就在session中加入该对象。当然还有一种情况就是用户什么也不输入直接提交，如果不对这种情况加以处理，那么数据库就会报错。我采取的方法是前端进行非空验证。

当然后台也可以注销，即销毁session中的user对象。

用流程图演示就是下面这样

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726153440230.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)



### 2.restful风格多变处理
什么是restful风格？

**REST的核心原则是将你的API拆分为逻辑上的资源。这些资源通过http被操作（GET ,POST,PUT,DELETE）。**
如https://blog.csdn.net/newjueqi/article/details/44037011这个接口。

其实csdn接口就是采用这种风格。不信？你看看你当前的地址栏就知道了。

**restful在命名上有个特点就是把所有东西当做资源，这就要求接口命名上以名词为主，然后通过发送请求方式的不同来区分增删改查的操作。**

**这样好处就是我一看接口就知道我要干什么，把后端定义成资源的获取，后端分工明确，职责清晰。**

**但是这样也存在一些问题，如果全按这种方式，那么在前后端分离不那么明显的情况下，接口不能完全应对前端错综复杂的需求变化。这就很考验接口的设计。**

所以这种情况下就要求我们不能完全采用这种风格，该加参数还得加，而且还得应对一个接口适应多种变化。
### 3.评论功能
评论功能还是有点复杂的，解决思路也很多。

而且你在建表的时候就得好好思考思路了。思考如何存储评论内容，如何存储评论与评论之间的关系。这样你后面处理起来才不会手忙脚乱。

这里我介绍一下我的思路。

首先，我把评论comment赋予以下几个属性 id，name，email，blog，isAdmin，content，time，parent。
前面几个属性好理解，无非就是存储评论的用户昵称，邮箱，评论内容之类。最后一个parent表示什么呢？其实这个parent使用用来存储评论与评论之间的关系的，它是int类型，主要存储父评论的id。如果没有父评论，那么则用-1存储以示区别。这样我们就可以分清以及评论和二级评论了。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726155830894.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)不过这还是我偷懒的情况，因为在二级评论里你会发现没有回复按钮。
实际上是被我删了，用@XXX代替，不然加了这按钮，这逻辑会复杂很多，存储起来也很麻烦。反正主要的效果都能达到，不如删去些细枝末节的东西来简化逻辑（好吧，我承认是我偷懒了QAQ）。
### 4.区分博主和普通游客的评论
有人可能会问：为什么要区分博主和普通游客的评论？

那你有没有想过一种很有意思的情况，就是游客伪装成博主的用户名和头像来“过愚人节”，这很有意思，但是机智的我为了防止这种情况的发生，在comment类中加了isAdmin属性以区分是否是管理员的评论，前端也根据此来区别显示评论。

而判断的依据就是session中有没有user对象。
### 5.分页显示
**分页显示实际上有三种思路，
一是后端把所有查询结果都发到前端，然后由前端进行分页显示处理；
二是后端查询后由后端出来分页，把其分好再发到前端
三是我需要时再查，每次点击上一页下一页时发送一个请求，请求包含分页的信息，由后端返回该分页的结果**

我这里采用的是第三种方法，因为这种方法是通过后端处理，而我又擅长后端，而且这种方法展示的数据具有实时性，前端接收的数据量小，反应快，用户体验好。
但是麻烦的地方随之而来，随着分页的信息都由后端来处理，还要肩负渲染的工作，导致后端的接口（controller）极其多。**因为需求变化多。特别是同一个页面有多种返回数据的需求，而每种返回的需求都需要分页显示，这样的话接口就呈指数式快速增加。这显然会把系统搞复杂，这就要求我接口的设计必须应对多种场景。**

其实我在写的时候也很犹豫，当时我写了一半，发现比较麻烦，想尝试第一种方法，但是由于我前端能力实在不行，主要是我不知道怎么实现点击后重新加载数据。然后考虑再三，最终还是选择第三种方法，虽然麻烦是麻烦了点，但是折腾一下后发现也不是什么问题。
### 6.利用thymeleaf模板中的if来达到选中效果
大家应该知道选中时会出现选中状态，这对导航来说还好，因为毕竟页面切换了，选中状态也都是写静态效果。
但是如果不切换页面呢？
这对前端老手根本不是什么问题，但对于我这个前端菜鸟来说要解决就有点烦了。
这时候我想到了个取巧的方法，利用thymeleaf模板引擎中的if和switch，case来间接达到选中的效果。
举个例子，
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726162119388.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)在分类专栏上有这么一个需求，点击相应分页然后返回相应分类下的博客。然后切换分类的选中效果。

我的做法就是后端传数据的时候就传入一个全局的数据，比如这里就是typeId，渲染分类栏的时候，通过if比较typeId是否一致如果一致就采用选中状态，如果不是就采用非选中状态
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726162450373.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
这样就能巧妙的间接实现选中效果切换的目的。

但对于前端大佬来说可能会不屑一顾，不过对于我这种不善前端的人来说，那确实对我还是蛮方便的。

前端虽然自己看得懂，也会写一部分，但如果要我做那种交互效果，虽然我会，但既然有取巧的办法干嘛不用呢？



## 六、遇到的问题
这里写一些我写代码过程中比较坑的问题。

### 1.Semantic UI文件的导入
视频中时采用链接的方式导入，但是我怕部署到服务器上的时候响应会变慢，所以我就采用本地的方式来导入文件，但最主要的原因是官网上找不到cdn链接了，也许是官网不推荐使用了。

不过也遇到了些问题，
首先遇到的是图标显示异常，最后找了下百度，找到了缘由
原因：图标资源未导入。
最简单的办法加入这句

```java
`<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.8/components/icon.min.css'>`
```

或者把icon.min.css文件下载到本地，再引入你的html。

但是这有个问题，就是你如果单个文件引入的话，由于其内部src路径是按照压缩包里面写的路径写的，这样就会造成路径问题。

解决方法就是把引用的路径改成现在的路径。这很麻烦，所以我才用另外一种，将这个文件夹复制粘贴至项目根目录，这样，引用的时候只要引用这三句就行了。

```javascript
<link rel="stylesheet" href="../Semantic-UI-CSS-master/semantic.min.css">、<script src="../Semantic-UI-CSS-master/semantic.min.js"/>
<script src="js/jquery-3.5.1.min.js"/>
```



当然你认为问题解决了吗？
不，没呢！

我发现图标还是未导入，然后多方查找发现了原因

> 引入图标，可以去http://www.fontawesome.com.cn/icons中找，因为semantic底层也是用它的图标库，不过引用是原来是fa-angle-double-right，改成angle
> double right icon即可

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726163621464.png)
这里我们就可以知道页面jquery.js的引用位置问题，如果导入了其它与jquery有关的js文件,那么jquery.js须在其它js的前面。
所以jquery.js文件的引用必须在semantic UI 的前面。

你以为问题解决了吗？
不，没呢！！！

图标还是不显示！！！

当我近乎绝望的时候，我意外的发现了原因

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726164709558.png)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726164639540.png)
这两者是有区别的！不然你的js操作都没用。。。后者才能成功导入，不能以/>结尾。别问我为什么知道的！问就是老天可怜我的！

### 2.maven项目的静态资源问题
当你发现SpringBoot给你报无数据源，可你明明在配置中配置了时，不要怀疑，点开target文件，看看里面是否有你的配置文件！

SpringBoot项目实际上也是maven项目，其项目结构完全参照maven的结构，只是多了些额外的要求。

**不例外的，SpringBoot项目启动的时候实际上执行的是target文件夹中的内容**，如果你明明配置了可还是给你报错，务必查找下target文件夹下面是否有你所需的文件。

如果没有则需检查你的pom.xml文件里是否配置了静态资源扫描（即是你的某些配置文件是在resource目录下，但并不是所有文件都会扫描进target文件夹的），所以我们必须加入以下配置

```java
<!-- 如果不添加此节点mybatis的mapper.xml文件都会被漏掉。 --><resources>
    <resource>
        <directory>src/main/java</directory>
        <includes>
            <include>**/*.yml</include>
            <include>**/*.properties</include>
            <include>**/*.xml</include>
        </includes>
        <filtering>false</filtering>
    </resource>
    <resource>
        <directory>src/main/resources</directory>
        <includes>
            <include>**/*.yml</include>
            <include>**/*.properties</include>
            <include>**/*.xml</include>
        </includes>
        <filtering>false</filtering>
</resource>
```
当然为了一劳永逸我采取的是这种把所有在resource文件夹下文件全部扫描的方式
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726165704925.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

### 3.SpringBoot项目的路径问题
在SpringBoot中，引用的文件路径直接写成
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726165832306.png)

不用在前面加上static，且不用../的形式。

### 4.数据库中设置默认值可实际操作中字段还是为null
原因：用实体类插入时，没有数据，但是创建实体类的时候默认给了个null，所以插入数据库时会出现null。

解决办法：在实体类定义的时候就给它一个初始化的默认值，这样就不会为空了。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726170002953.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

### 5.mybatis框架报数组越界
一开始我还很奇怪mybatis框架怎么会报数组越界呢？
后来我才知道是因为xml中resultmap写的字段和sql语句不匹配（实体类中不一致也会发生）是会发生这个错误

### 6.表单怎么发送put请求
其实SpringBoot已经有相应的措施，原理就是SpringBoot默认维护了一个WebMvcAutoConfiguration，其中如果有_method就改变请求方式，不过SpringBoot项目得在配置中开启，默认是关闭的 

这时候你要做就是在配置中将这个类设置为true
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726172014202.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)然后再前端表单中加入这么一句即可。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726172211627.png)



## 七、关键代码清单

### 1.实体类（pojo层）
#### blog类

```java
package com.dreamchaser.pojo;

import java.util.Date;

/**
 * blog
 * 
 */
public class Blog {

    /** ID编号 */
    private Integer id;

    /** 博客标题 */
    private String title;

    /** 博客摘要 */
    private String summary;

    /** 博客内容 */
    private String content;

    /** 发布时间 */
    private Date date;

    /** 所属专栏 */
    private Integer type;

    /** 浏览量 */
    private Integer views=563;

    /** 标签 */
    private String tags;

    /** 评论 */
    private String comments;

    /** 首图地址 */
    private String pictureUrl;

    /** 是否开启推荐 */
    private Integer isRecommend=0;

    /** 是否开启转载声明 */
    private Integer isReprint=0;

    /** 是否开启赞赏 */
    private Integer isAppreciation=0;

    /** 是否开启评论 */
    private Integer isComment=0;

    /** 1.原创；2.转载；3.翻译 */
    private Integer property=1;

    /** 状态：0.草稿；1.已发布 */
    private Integer state;


    /**
     * 获取ID编号
     * 
     * @return ID编号
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置ID编号
     * 
     * @param id
     *          ID编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取博客标题
     * 
     * @return 博客标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置博客标题
     * 
     * @param title
     *          博客标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取博客摘要
     * 
     * @return 博客摘要
     */
    public String getSummary() {
        return this.summary;
    }

    /**
     * 设置博客摘要
     * 
     * @param summary
     *          博客摘要
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 获取博客内容
     * 
     * @return 博客内容
     */
    public String getContent() {
        return this.content;
    }

    /**
     * 设置博客内容
     * 
     * @param content
     *          博客内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取发布时间
     * 
     * @return 发布时间
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * 设置发布时间
     * 
     * @param date
     *          发布时间
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取所属专栏
     * 
     * @return 所属专栏
     */
    public Integer getType() {
        return this.type;
    }

    /**
     * 设置所属专栏
     * 
     * @param type
     *          所属专栏
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取浏览量
     * 
     * @return 浏览量
     */
    public Integer getViews() {
        return this.views;
    }

    /**
     * 设置浏览量
     * 
     * @param views
     *          浏览量
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     * 获取标签
     * 
     * @return 标签
     */
    public String getTags() {
        return this.tags;
    }

    /**
     * 设置标签
     * 
     * @param tags
     *          标签
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * 获取评论
     * 
     * @return 评论
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * 设置评论
     * 
     * @param comments
     *          评论
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * 获取首图地址
     * 
     * @return 首图地址
     */
    public String getPictureUrl() {
        return this.pictureUrl;
    }

    /**
     * 设置首图地址
     * 
     * @param pictureUrl
     *          首图地址
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    /**
     * 获取是否开启推荐
     * 
     * @return 是否开启推荐
     */
    public Integer getIsRecommend() {
        return this.isRecommend;
    }

    /**
     * 设置是否开启推荐
     * 
     * @param isRecommend
     *          是否开启推荐
     */
    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * 获取是否开启转载声明
     * 
     * @return 是否开启转载声明
     */
    public Integer getIsReprint() {
        return this.isReprint;
    }

    /**
     * 设置是否开启转载声明
     * 
     * @param isReprint
     *          是否开启转载声明
     */
    public void setIsReprint(Integer isReprint) {
        this.isReprint = isReprint;
    }

    /**
     * 获取是否开启赞赏
     * 
     * @return 是否开启赞赏
     */
    public Integer getIsAppreciation() {
        return this.isAppreciation;
    }

    /**
     * 设置是否开启赞赏
     * 
     * @param isAppreciation
     *          是否开启赞赏
     */
    public void setIsAppreciation(Integer isAppreciation) {
        this.isAppreciation = isAppreciation;
    }

    /**
     * 获取是否开启评论
     * 
     * @return 是否开启评论
     */
    public Integer getIsComment() {
        return this.isComment;
    }

    /**
     * 设置是否开启评论
     * 
     * @param isComment
     *          是否开启评论
     */
    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    /**
     * 获取1.原创；2.转载；3.翻译
     * 
     * @return 1.原创；2.转载；3.翻译
     */
    public Integer getProperty() {
        return this.property;
    }

    /**
     * 设置1.原创；2.转载；3.翻译
     * 
     * @param property
     *          1.原创；2.转载；3.翻译
     */
    public void setProperty(Integer property) {
        this.property = property;
    }

    /**
     * 获取状态：0.草稿；1.已发布
     * 
     * @return 状态
     */
    public Integer getState() {
        return this.state;
    }

    /**
     * 设置状态：0.草稿；1.已发布
     * 
     * @param state
     *          状态
     */
    public void setState(Integer state) {
        this.state = state;
    }

}
```
#### BlogCombination类
由于前端的某些需求，需要整合blog类，将对应的type，tag和comment集成到一起

```java
package com.dreamchaser.pojo;
import java.util.Date;
import java.util.List;

/**
 * blog
 *
 */

public class BlogCombination {

    /** ID编号 */
    private Integer id;

    /** 博客标题 */
    private String title;

    /** 博客摘要 */
    private String summary;

    /** 博客内容 */
    private String content;

    /** 发布时间 */
    private Date date;

    /** 所属专栏 */
    private Type type;

    /** 浏览量 */
    private Integer views=563;

    /** 标签 */
    private List<Tag> tags;

    /** 评论 */
    private List<Comment> comments;

    /** 首图地址 */
    private String pictureUrl;

    /** 是否开启推荐 */
    private Integer isRecommend=0;

    /** 是否开启转载声明 */
    private Integer isReprint=0;

    /** 是否开启赞赏 */
    private Integer isAppreciation=0;

    /** 是否开启评论 */
    private Integer isComment=0;

    /** 1.原创；2.转载；3.翻译 */
    private Integer property;

    /** 状态：0.草稿；1.已发布 */
    private Integer state;

    public BlogCombination(Integer id, String title, String summary, String content, Date date, Type type, Integer views, List<Tag> tags, List<Comment> comments, String pictureUrl, Integer isRecommend, Integer isReprint, Integer isAppreciation, Integer isComment, Integer property, Integer state) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.date = date;
        this.type = type;
        this.views = views;
        this.tags = tags;
        this.comments = comments;
        this.pictureUrl = pictureUrl;
        this.isRecommend = isRecommend;
        this.isReprint = isReprint;
        this.isAppreciation = isAppreciation;
        this.isComment = isComment;
        this.property = property;
        this.state = state;
    }
    public BlogCombination(Blog blog,Type type,List<Tag> tags,List<Comment> comments) {
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.summary = blog.getSummary();
        this.content = blog.getContent();
        this.date = blog.getDate();
        this.type = type;
        this.views = blog.getViews();
        this.tags = tags;
        this.comments = comments;
        this.pictureUrl = blog.getPictureUrl();
        this.isRecommend = blog.getIsRecommend();
        this.isReprint = blog.getIsReprint();
        this.isAppreciation = blog.getIsAppreciation();
        this.isComment = blog.getIsComment();
        this.property = blog.getProperty();
        this.state = blog.getState();
    }
    public BlogCombination(Blog blog,Type type,List<Tag> tags) {
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.summary = blog.getSummary();
        this.content = blog.getContent();
        this.date = blog.getDate();
        this.type = type;
        this.views = blog.getViews();
        this.tags = tags;
        this.pictureUrl = blog.getPictureUrl();
        this.isRecommend = blog.getIsRecommend();
        this.isReprint = blog.getIsReprint();
        this.isAppreciation = blog.getIsAppreciation();
        this.isComment = blog.getIsComment();
        this.property = blog.getProperty();
        this.state = blog.getState();
    }
    public BlogCombination(Blog blog,Type type) {
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.summary = blog.getSummary();
        this.content = blog.getContent();
        this.date = blog.getDate();
        this.type = type;
        this.views = blog.getViews();
        this.pictureUrl = blog.getPictureUrl();
        this.isRecommend = blog.getIsRecommend();
        this.isReprint = blog.getIsReprint();
        this.isAppreciation = blog.getIsAppreciation();
        this.isComment = blog.getIsComment();
        this.property = blog.getProperty();
        this.state = blog.getState();
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }



    public Integer getViews() {
        return views;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }



    public List<Comment> getComments() {
        return comments;
    }



    public String getPictureUrl() {
        return pictureUrl;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public Integer getIsReprint() {
        return isReprint;
    }

    public Integer getIsAppreciation() {
        return isAppreciation;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public Integer getProperty() {
        return property;
    }

    public Integer getState() {
        return state;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public void setViews(Integer views) {
        this.views = views;
    }

    public Type getType() {
        return type;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public void setIsReprint(Integer isReprint) {
        this.isReprint = isReprint;
    }

    public void setIsAppreciation(Integer isAppreciation) {
        this.isAppreciation = isAppreciation;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public void setProperty(Integer property) {
        this.property = property;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BlogCombination{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", views=" + views +
                ", tags=" + tags +
                ", comments=" + comments +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", isRecommend=" + isRecommend +
                ", isReprint=" + isReprint +
                ", isAppreciation=" + isAppreciation +
                ", isComment=" + isComment +
                ", property=" + property +
                ", state=" + state +
                '}';
    }
}
```
#### comment类

```java
package com.dreamchaser.pojo;

import java.util.Date;

/**
 * comment
 * @author 金昊霖
 */
public class Comment implements java.io.Serializable {

    /** ID编号 */
    private Integer id;

    /** 发表评论的用户名称 */
    private String name;

    /** 邮箱地址 */
    private String email;

    /** 博客ID编号 */
    private Integer blog;

    /** 发布时间 */
    private Date time;

    /** 是否是管理员 */
    private Integer isAdmin;

    /** 评论内容 */
    private String content;

    /** 父评论的id */
    private Integer parent;

    public Comment(Integer id, String name, String email, Integer blog, Date time, Integer isAdmin, String content, Integer parent) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.blog = blog;
        this.time = time;
        this.isAdmin = isAdmin;
        this.content = content;
        this.parent = parent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    /**
     * 获取ID编号
     * 
     * @return ID编号
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置ID编号
     * 
     * @param id
     *          ID编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取发表评论的用户名称
     * 
     * @return 发表评论的用户名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置发表评论的用户名称
     * 
     * @param name
     *          发表评论的用户名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取邮箱地址
     * 
     * @return 邮箱地址
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 设置邮箱地址
     * 
     * @param email
     *          邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取博客ID编号
     * 
     * @return 博客ID编号
     */
    public Integer getBlog() {
        return this.blog;
    }

    /**
     * 设置博客ID编号
     * 
     * @param blog
     *          博客ID编号
     */
    public void setBlog(Integer blog) {
        this.blog = blog;
    }

    /**
     * 获取发布时间
     * 
     * @return 发布时间
     */
    public Date getTime() {
        return this.time;
    }

    /**
     * 设置发布时间
     * 
     * @param time
     *          发布时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取是否是管理员
     * 
     * @return 是否是管理员
     */
    public Integer getIsAdmin() {
        return this.isAdmin;
    }

    /**
     * 设置是否是管理员
     * 
     * @param isAdmin
     *          是否是管理员
     */
    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

}
```

### 2.Mapper层

#### BlogMapper.xml

```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- blog -->
<mapper namespace="com.dreamchaser.mapper.BlogMapper">
    <!-- 字段映射 -->

    <resultMap id="blogMap" type="com.dreamchaser.pojo.Blog">
        <id column="id" property="id" jdbcType="INTEGER" />
        <result column="title" property="title" jdbcType="VARCHAR" />
        <result column="summary" property="summary" jdbcType="VARCHAR" />
        <result column="content" property="content" jdbcType="VARCHAR" />
        <result column="date" property="date" jdbcType="TIMESTAMP" />
        <result column="type" property="type" jdbcType="INTEGER" />
        <result column="views" property="views" jdbcType="INTEGER" />
        <result column="tags" property="tags" jdbcType="VARCHAR" />
        <result column="comments" property="comments" jdbcType="VARCHAR" />
        <result column="pictureUrl" property="pictureUrl" jdbcType="VARCHAR" />
        <result column="isRecommend" property="isRecommend" jdbcType="INTEGER" />
        <result column="isReprint" property="isReprint" jdbcType="INTEGER" />
        <result column="isAppreciation" property="isAppreciation" jdbcType="INTEGER" />
        <result column="isComment" property="isComment" jdbcType="INTEGER" />
        <result column="property" property="property" jdbcType="INTEGER" />
        <result column="state" property="state" jdbcType="INTEGER" />
    </resultMap>


    <!-- 表查询字段 -->
    <sql id="allColumns">
        b.id, b.title, b.summary, b.content, b.date, b.type, b.views, b.tags, 
        b.comments, b.pictureUrl, b.isRecommend, b.isReprint, b.isAppreciation, b.isComment, b.property, b.state
    </sql>

    <!-- 查询所有数据 -->
    <select id="findBlogAll" resultMap="blogMap">
        SELECT
        <include refid="allColumns" />
        FROM blog b
        ORDER by b.date desc
    </select>

    <select id="findBlogAllVisible" resultMap="blogMap">
        SELECT
        <include refid="allColumns" />
        FROM blog b
        WHERE b.state=1
        ORDER by b.date desc
    </select>
    
    <!-- 根据条件参数查询数据列表 -->
    <select id="findBlogByCondition" resultMap="blogMap" parameterType="map">
        SELECT
        <include refid="allColumns" />
        FROM blog b
        WHERE 1 = 1
        <if test="title != null and title != ''">
            AND b.title LIKE CONCAT('%', #{title}, '%')
        </if>
        <if test="summary != null and summary != ''">
            AND b.summary LIKE CONCAT('%', #{summary}, '%')
        </if>
        <if test="content != null and content != ''">
            AND b.content LIKE CONCAT('%', #{content}, '%')
        </if>
        <if test="date != null and date != ''">
            AND b.date = #{date}
        </if>
        <if test="type != null and type != ''">
            AND b.type = #{type}
        </if>
        <if test="views != null and views != ''">
            AND b.views = #{views}
        </if>
        <if test="tags != null and tags != ''">
            AND b.tags  LIKE CONCAT('%', #{tags}, '%')
        </if>
        <if test="comments != null and comments != ''">
            AND b.comments = #{comments}
        </if>
        <if test="pictureUrl != null and pictureUrl != ''">
            AND b.pictureUrl LIKE CONCAT('%', #{pictureUrl}, '%')
        </if>
        <if test="isRecommend != null and isRecommend != ''">
            AND b.isRecommend = #{isRecommend}
        </if>
        <if test="isReprint != null and isReprint != ''">
            AND b.isReprint = #{isReprint}
        </if>
        <if test="isAppreciation != null and isAppreciation != ''">
            AND b.isAppreciation = #{isAppreciation}
        </if>
        <if test="isComment != null and isComment != ''">
            AND b.isComment = #{isComment}
        </if>
        <if test="property != null and property != ''">
            AND b.property = #{property}
        </if>
        <if test="state != null and state != ''">
            AND b.state = #{state}
        </if>
        ORDER by b.date desc
        <if test="begin != null and size != null">
            LIMIT #{begin},#{size}
        </if>

    </select>


    <!-- 根据条件参数查询数据列表 -->
    <select id="findBlogByPage" resultMap="blogMap" parameterType="Integer">
        SELECT
        <include refid="allColumns" />
        FROM blog b
        ORDER by b.date desc
        LIMIT #{begin} , #{size}
    </select>
    
    <!-- 根据主键查询数据 -->
    <select id="findBlogById" resultMap="blogMap" parameterType="integer">
        SELECT
        <include refid="allColumns" />
        FROM blog b WHERE b.id =#{id}
    </select>
    <select id="findBlogIdByName" resultType="integer" parameterType="string">
        SELECT
        b.id
        FROM blog b WHERE b.title =#{title}
    </select>
    <select id="findBlogByIds" resultMap="blogMap" parameterType="list">
        SELECT
        <include refid="allColumns" />
        FROM blog b WHERE b.id IN
        <foreach collection="list" index="index" item="id" open="(" separator="," close=")">
            #{id}
        </foreach>
    </select>
    
    <!-- 插入数据 -->
    <insert id="insertBlog" parameterType="map">
        INSERT INTO blog (
            id, title, summary, content, date, type, views, tags,
            comments, pictureUrl, isRecommend, isReprint, isAppreciation, isComment, property, state
        ) VALUES (
            #{id},
            #{title},
            #{summary},
            #{content},
            #{date},
            #{type},
            #{views},
            #{tags},
            #{comments},
            #{pictureUrl},
            #{isRecommend},
            #{isReprint},
            #{isAppreciation},
            #{isComment},
            #{property},
            #{state}
        )
    </insert>

    <!-- 插入数据 -->
    <insert id="addBlog" parameterType="com.dreamchaser.pojo.Blog">
        INSERT INTO blog (
            id, title, summary, content, date, type, views, tags,
            comments, pictureUrl, isRecommend, isReprint, isAppreciation, isComment, property, state
        ) VALUES (
            #{id},
            #{title},
            #{summary},
            #{content},
            #{date},
            #{type},
            #{views},
            #{tags},
            #{comments},
            #{pictureUrl},
            #{isRecommend},
            #{isReprint},
            #{isAppreciation},
            #{isComment},
            #{property},
            #{state}
        )
    </insert>
    <!-- 批量插入数据 -->
    <insert id="insertBlogs" parameterType="list">
        INSERT INTO blog (
            id, title, summary, content, date, type, views, tags, 
            comments, pictureUrl, isRecommend, isReprint, isAppreciation, isComment, property, state
        ) VALUES
        <foreach collection="list" index="index" item="item" separator=",">
            (
                #{item.id},
                #{item.title},
                #{item.summary},
                #{item.content},
                #{item.date},
                #{item.type},
                #{item.views},
                #{item.tags},
                #{item.comments},
                #{item.pictureUrl},
                #{item.isRecommend},
                #{item.isReprint},
                #{item.isAppreciation},
                #{item.isComment},
                #{item.property},
                #{item.state}
            )
        </foreach>
    </insert>
    
    <!-- 修改数据 -->
    <update id="updateBlog" parameterType="com.dreamchaser.pojo.Blog">
        UPDATE blog
        <set>
            <if test="title != null">
                title = #{title},
            </if>
            <if test="summary != null">
                summary = #{summary},
            </if>
            <if test="content != null">
                content = #{content},
            </if>
            <if test="date != null">
                date = #{date},
            </if>
            <if test="type != null">
                type = #{type},
            </if>
            <if test="views != null">
                views = #{views},
            </if>
            <if test="tags != null">
                tags = #{tags},
            </if>
            <if test="comments != null">
                comments = #{comments},
            </if>
            <if test="pictureUrl != null">
                pictureUrl = #{pictureUrl},
            </if>
            <if test="isRecommend != null">
                isRecommend = #{isRecommend},
            </if>
            <if test="isReprint != null">
                isReprint = #{isReprint},
            </if>
            <if test="isAppreciation != null">
                isAppreciation = #{isAppreciation},
            </if>
            <if test="isComment != null">
                isComment = #{isComment},
            </if>
            <if test="property != null">
                property = #{property},
            </if>
            <if test="state != null">
                state = #{state}
            </if>
        </set>
        WHERE id = #{id}
    </update>
    
    <!-- 批量修改数据 -->
    <update id="updateBlogs" parameterType="list">
        <foreach collection="list" index="index" item="item" separator=";">
            UPDATE blog
            <set>
                <if test="item.title != null">
                    title = #{item.title},
                </if>
                <if test="item.summary != null">
                    summary = #{item.summary},
                </if>
                <if test="item.content != null">
                    content = #{item.content},
                </if>
                <if test="item.date != null">
                    date = #{item.date},
                </if>
                <if test="item.type != null">
                    type = #{item.type},
                </if>
                <if test="item.views != null">
                    views = #{item.views},
                </if>
                <if test="item.tags != null">
                    tags = #{item.tags},
                </if>
                <if test="item.comments != null">
                    comments = #{item.comments},
                </if>
                <if test="item.pictureUrl != null">
                    pictureUrl = #{item.pictureUrl},
                </if>
                <if test="item.isRecommend != null">
                    isRecommend = #{item.isRecommend},
                </if>
                <if test="item.isReprint != null">
                    isReprint = #{item.isReprint},
                </if>
                <if test="item.isAppreciation != null">
                    isAppreciation = #{item.isAppreciation},
                </if>
                <if test="item.isComment != null">
                    isComment = #{item.isComment},
                </if>
                <if test="item.property != null">
                    property = #{item.property},
                </if>
                <if test="item.state != null">
                    state = #{item.state}
                </if>
            </set>
            WHERE id = #{item.id}
        </foreach>
    </update>
    
    <!-- 根据主键删除数据 -->
    <delete id="deleteBlogById" parameterType="int">
        DELETE FROM blog WHERE id = #{id}
    </delete>
    
    <!-- 根据主键批量删除数据 -->
    <delete id="deleteBlogByIds" parameterType="list">
        DELETE FROM blog WHERE id IN
        <foreach collection="list" index="index" item="id" open="(" separator="," close=")">
            #{id}
        </foreach>
    </delete>
</mapper>
```
#### BlogMapper接口

```java
package com.dreamchaser.mapper;

import com.dreamchaser.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author 金昊霖
 */
public interface BlogMapper {
    /**
     * 增加博客
     * @param blog
     * @return
     */
    int addBlog(Blog blog);

    /**
     * 通过主键删除博客
     * @param id
     * @return
     */
    Integer deleteBlogById(Integer id);

    /**
     * 更新博客
     * @param blog
     * @return
     */
    Integer updateBlog(Blog blog);

    /**
     * 查询所有博客
     * @return
     */
    List<Blog> findBlogAll();

    /**
     * 分页查询博客
     * @param begin
     * @param size
     * @return
     */
    List<Blog> findBlogByPage(Integer begin, Integer size);

    /**
     * 按条件查询博客
     * @param map
     * @return
     */
    List<Blog> findBlogByCondition(Map<String, Object> map);

    /**
     * 通过主键查询博客
     * @param id
     * @return
     */
    Blog findBlogById(Integer id);

    /**
     * 根据名称查询id
     * @param title
     * @return
     */
    Integer findBlogIdByName(String title);

    /**
     * 用于查询所有可见blog（已发布）
     * @return
     */
    List<Blog> findBlogAllVisible();

}

```
#### CommentMapper.xml

```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- comment -->
<mapper namespace="com.dreamchaser.mapper.CommentMapper">
    <!-- This code was generated by TableGo tools, mark 1 begin. -->
    <!-- 字段映射 -->
    <resultMap id="commentMap" type="com.dreamchaser.pojo.Comment">
        <id column="id" property="id" jdbcType="INTEGER" />
        <result column="name" property="name" jdbcType="VARCHAR" />
        <result column="email" property="email" jdbcType="VARCHAR" />
        <result column="blog" property="blog" jdbcType="INTEGER" />
        <result column="time" property="time" jdbcType="TIMESTAMP" />
        <result column="isAdmin" property="isAdmin" jdbcType="INTEGER" />
        <result column="content" property="content" jdbcType="VARCHAR"/>
        <result column="parent" property="parent" jdbcType="INTEGER"/>
    </resultMap>

    <!-- 表查询字段 -->
    <sql id="allColumns">
        c.id, c.name, c.email, c.blog, c.time, c.isAdmin,c.content,c.parent
    </sql>
    <!-- This code was generated by TableGo tools, mark 2 end. -->
    
    <!-- 查询所有数据 -->
    <select id="findCommentAll" resultMap="commentMap">
        SELECT
        <include refid="allColumns" />
        FROM comment c
    </select>
    
    <!-- 根据条件参数查询数据列表 -->
    <select id="findCommentByPage" resultMap="commentMap" parameterType="map">
        SELECT
        <include refid="allColumns" />
        FROM comment c WHERE 1 = 1
        <if test="name != null and name != ''">
            AND c.name = #{name}
        </if>
        <if test="email != null and email != ''">
            AND c.email = #{email}
        </if>
        <if test="blog != null">
            AND c.blog = #{blog}
        </if>
        <if test="time != null">
            AND c.time = #{time}
        </if>
        <if test="isAdmin != null">
            AND c.isAdmin = #{isAdmin}
        </if>
        <if test="content != null">
            AND c.content = #{content}
        </if>
        ORDER by c.time desc
        LIMIT #{begin} , #{size}
    </select>
    <select id="findCommentByCondition" resultMap="commentMap" parameterType="map">
        SELECT
        <include refid="allColumns" />
        FROM comment c WHERE 1 = 1
        <if test="name != null and name != ''">
            AND c.name LIKE CONCAT('%', #{name}, '%')
        </if>
        <if test="email != null and email != ''">
            AND c.email LIKE CONCAT('%', #{email}, '%')
        </if>
        <if test="blog != null">
            AND c.blog = #{blog}
        </if>
        <if test="time != null">
            AND c.time = #{time}
        </if>
        <if test="isAdmin != null">
            AND c.isAdmin = #{isAdmin}
        </if>
    </select>
    
    <!-- 根据主键查询数据 -->
    <select id="findCommentById" resultMap="commentMap" parameterType="integer">
        SELECT
        <include refid="allColumns" />
        FROM comment c WHERE c.id =#{id}
    </select>

    <select id="findCommentByIds" resultMap="commentMap" parameterType="list">
        SELECT
        <include refid="allColumns" />
        FROM comment c WHERE c.id IN
        <foreach collection="list" index="index" item="id" open="(" separator="," close=")">
            #{id}
        </foreach>
    </select>

    <select id="findPCommentByBlogId" resultMap="commentMap" parameterType="integer">
        SELECT
        <include refid="allColumns" />
        FROM comment c WHERE c.blog =#{blog} and c.parent=-1
    </select>

    <select id="findSCommentByBlogId" resultMap="commentMap" parameterType="integer">
        SELECT
        <include refid="allColumns" />
        FROM comment c WHERE c.blog =#{blog} and c.parent !=-1
    </select>

    <!-- 插入数据 -->
    <insert id="insertComment" parameterType="com.dreamchaser.pojo.Comment">
        INSERT INTO comment (
            id, name, email, blog, time, isAdmin,content,parent
        ) VALUES (
            #{id},
            #{name},
            #{email},
            #{blog},
            #{time},
            #{isAdmin},
            #{content},
            #{parent}
        )
    </insert>
    
    <!-- 批量插入数据 -->
    <insert id="insertComments" parameterType="list">
        INSERT INTO comment (
            id, name, email, blog, time, isAdmin,content
        ) VALUES
        <foreach collection="list" index="index" item="item" separator=",">
            (
                #{item.id},
                #{item.name},
                #{item.email},
                #{item.blog},
                #{item.time},
                #{item.isAdmin},
                ${item.content}.
                ${item.parent}
            )
        </foreach>
    </insert>
    
    <!-- 修改数据 -->
    <update id="updateComment" parameterType="com.dreamchaser.pojo.Comment">
        UPDATE comment
        <set>
            <if test="name != null">
                name = #{name},
            </if>
            <if test="email != null">
                email = #{email},
            </if>
            <if test="blog != null">
                blog = #{blog},
            </if>
            <if test="time != null">
                time = #{time},
            </if>
            <if test="isAdmin != null">
                isAdmin = #{isAdmin}
            </if>
            <if test="content != null">
                content = #{content}
            </if>
            <if test="parent != null">
                parent = #{parent}
            </if>
        </set>
        WHERE id = #{id}
    </update>
    
    <!-- 批量修改数据 -->
    <update id="updateComments" parameterType="list">
        <foreach collection="list" index="index" item="item" separator=";">
            UPDATE comment
            <set>
                <if test="item.name != null">
                    name = #{item.name},
                </if>
                <if test="item.email != null">
                    email = #{item.email},
                </if>
                <if test="item.blog != null">
                    blog = #{item.blog},
                </if>
                <if test="item.time != null">
                    time = #{item.time},
                </if>
                <if test="item.isAdmin != null">
                    isAdmin = #{item.isAdmin}
                </if>
                <if test="item.content != null">
                    content = #{item.content}
                </if>
                <if test="item.parent != null">
                    parent = #{item.parent}
                </if>
            </set>
            WHERE id = #{item.id}
        </foreach>
    </update>
    
    <!-- 根据主键删除数据 -->
    <delete id="deleteCommentById" parameterType="int">
        DELETE FROM comment WHERE id = #{id}
    </delete>
    
    <!-- 根据主键批量删除数据 -->
    <delete id="deleteCommentByIds" parameterType="list">
        DELETE FROM comment WHERE id IN
        <foreach collection="list" index="index" item="id" open="(" separator="," close=")">
            #{id}
        </foreach>
    </delete>
</mapper>
```

#### CommentMapper接口

```java
package com.dreamchaser.mapper;

import com.dreamchaser.pojo.Comment;

import java.util.List;
import java.util.Map;

public interface CommentMapper {
    /**
     * 插入一条评论
     * @param comment
     * @return
     */
    int insertComment(Comment comment);

    /**
     * 根据主键删除一条评论
     * @param id
     * @return
     */
    int deleteCommentById(Integer id);

    /**
     * 根据主键删除多条评论
     * @param ids
     * @return
     */
    int deleteCommentByIds(List<Integer> ids);

    /**
     * 更新一条评论
     * @param comment
     * @return
     */
    int updateComment(Comment comment);

    /**
     * 分页查找
     * @param map
     * @return
     */
    List<Comment> findCommentByPage(Map<String,Object> map);

    /**
     * 根据主键id查询评论
     * @param id
     * @return
     */
    Comment findCommentById(Integer id);

    /**
     * 根据博客id查询父级评论
     * @param blog
     * @return
     */
    List<Comment> findPCommentByBlogId(Integer blog);

    /**
     * 根据博客id查询子级评论
     * @param blog
     * @return
     */
    List<Comment> findSCommentByBlogId(Integer blog);
}

```
### 3.Service层
#### BlogService接口

```java
package com.dreamchaser.service;

import com.dreamchaser.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author 金昊霖
 */
public interface BlogService {
    /**
     * 查询所有的博客
     * @return
     */
    List<Blog> findBlogAll();

    /**
     * 增加一个博客
     * @param blog
     * @return
     */
    int addBlog(Blog blog);

    /**
     * 按条件查询博客
     * @param map
     * @return
     */
    List<Blog> findBlogByCondition(Map<String,Object> map);

    /**
     * 分页查找博客
     * @param begin
     * @param size
     * @return
     */
    List<Blog> findBlogByPage(Integer begin, Integer size);

    /**
     * 根据主键查询博客
     * @param blogId
     * @return
     */
    Blog findBlogById(Integer blogId);

    /**
     * 根据主键删除博客
     * @param id
     * @return
     */
    int deleteBlog(Integer id);

    /**
     * 更新一个博客
     * @param blog
     * @return
     */
    int updateBlog(Blog blog);

    /**
     * 通过名称寻找id
     * @return
     * @param name
     */
    Integer findBlogIdByName(String name);

    /**
     * 用于查询所有可见的博客（发布状态的）
     * @return
     */
    List<Blog> findBlogAllVisible();

    /**
     * 根据条件查询查询可见的博客（发布状态的）
     * @param map
     * @return
     */
    List<Blog> findBlogByConditionVisible(Map<String, Object> map);
}

```
#### BlogServiceImpl实现类

```java
package com.dreamchaser.service.impl;

import com.dreamchaser.mapper.BlogMapper;
import com.dreamchaser.mapper.CommentMapper;
import com.dreamchaser.mapper.TagMapper;
import com.dreamchaser.mapper.TypeMapper;
import com.dreamchaser.pojo.Blog;
import com.dreamchaser.pojo.Tag;
import com.dreamchaser.pojo.Type;
import com.dreamchaser.service.BlogService;
import com.dreamchaser.utils.TagUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BlogServiceImpl implements BlogService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    BlogMapper blogMapper;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TagMapper tagMapper;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TypeMapper typeMapper;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<Blog> findBlogAll() {
        return blogMapper.findBlogAll();
    }

    @Override
    @Transactional
    public int addBlog(Blog blog) {
        blog.setDate(new Date());
        change(blog,1);
        return blogMapper.addBlog(blog);
    }

    @Override
    public List<Blog> findBlogByCondition(Map<String, Object> map) {
        return blogMapper.findBlogByCondition(map);
    }

    @Override
    public List<Blog> findBlogByPage(Integer begin, Integer end) {
        return blogMapper.findBlogByPage(begin,end);
    }

    @Override
    public Blog findBlogById(Integer blogId) {
        return blogMapper.findBlogById(blogId);
    }

    @Transactional
    @Override
    public int deleteBlog(Integer id) {
        change(findBlogById(id),-1);
        return blogMapper.deleteBlogById(id);
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    public Integer findBlogIdByName(String name) {
        return blogMapper.findBlogIdByName(name);
    }

    @Override
    public List<Blog> findBlogAllVisible() {
        return blogMapper.findBlogAllVisible();
    }

    @Override
    public List<Blog> findBlogByConditionVisible(Map<String, Object> map) {
        map.put("state",1);
        return blogMapper.findBlogByCondition(map);
    }


    /**
     * 提取封装的一个私有方法
     * 作用：更新博客的同时要对分类和标签中的博客数量属性进行修改，同时删除对应的评论
     * @param blog 要变化的博客
     * @param i 判断是增加还是减少
     */
    private void change(Blog blog,Integer i){
        //处理标签
        Type type = typeMapper.findTypeById(blog.getType());
        type.setNumber(type.getNumber()+i);
        typeMapper.updateType(type);

        Map<String,Object> map1=new HashMap<>();
        List<Tag> tags=tagMapper.findTagByIds(TagUtil.stringTolist(blog.getTags()));
        for (Tag tag:tags){
            tag.setNumber(tag.getNumber()+i);
            tagMapper.updateTag(tag);
        }
        //处理评论变化
        if (i==-1){
            commentMapper.deleteCommentByIds(TagUtil.stringTolist(blog.getComments()));
        }
    }
}

```
#### BlogCombinationService接口类

```java
package com.dreamchaser.service;

import com.dreamchaser.pojo.Blog;
import com.dreamchaser.pojo.BlogCombination;

import java.util.List;
import java.util.Map;

/**
 * @author 金昊霖
 */
public interface BlogCombinationService {
    /**
     * 分页查询得到组合类集合
     * @param begin
     * @param size
     * @return
     */
//    List<BlogCombination> findBlogCombinationByPage(Integer begin, Integer size);

    /**
     * 根据条件查询得到集合类
     * @param map
     * @return
     */
    List<BlogCombination> findBlogCombinationByCondition(Map<String, Object> map);

    /**
     * 根据条件查询已发布的博客
     * @param map
     * @return
     */
    List<BlogCombination> findBlogCombinationByConditionVisible(Map<String, Object> map);

    /**
     * 根据主键查询
     * @param blogId
     * @return
     */
    BlogCombination findBlogCombinationById(Integer blogId);

    /**
     * 查询所有已发布的博客并封装成BlogCombination返回
     * @return
     */
    List<BlogCombination> findBlogCombinationAllVisible();

}

```
#### BlogCombinationServiceImpl实现类

```java
package com.dreamchaser.service.impl;

import com.dreamchaser.mapper.BlogMapper;
import com.dreamchaser.mapper.TagMapper;
import com.dreamchaser.mapper.TypeMapper;
import com.dreamchaser.pojo.Blog;
import com.dreamchaser.pojo.BlogCombination;
import com.dreamchaser.pojo.Tag;
import com.dreamchaser.pojo.Type;
import com.dreamchaser.service.BlogCombinationService;
import com.dreamchaser.utils.TagUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 金昊霖
 */
@Service
public class BlogCombinationServiceImpl implements BlogCombinationService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    BlogMapper blogMapper;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TagMapper tagMapper;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TypeMapper typeMapper;


    @Override
    public List<BlogCombination> findBlogCombinationByCondition(Map<String, Object> map) {
        List<Blog> blogs=blogMapper.findBlogByCondition(map);
        return getBlogCombinations(blogs);
    }

    @Override
    public List<BlogCombination> findBlogCombinationByConditionVisible(Map<String, Object> map) {
        map.put("state",1);
        List<Blog> blogs=blogMapper.findBlogByCondition(map);
        return getBlogCombinations(blogs);
    }

    @Override
    public BlogCombination findBlogCombinationById(Integer blogId) {
        Blog blog=blogMapper.findBlogById(blogId);
        return getBlogCombination(blog);
    }

    @Override
    public List<BlogCombination> findBlogCombinationAllVisible() {
        List<Blog> blogs=blogMapper.findBlogAllVisible();
        return getBlogCombinations(blogs);
    }

    /**
     * 根据找到的多个blog将其封装成BlogCombination返回
     * @param blogs
     * @return
     */
    private List<BlogCombination> getBlogCombinations(List<Blog> blogs) {
        List<BlogCombination> blogCombinationList=new ArrayList<>();
        Type type=null;
        for (Blog blog:blogs) {
            type=typeMapper.findTypeById(blog.getType());
            List<Tag> tags=tagMapper.findTagByIds(TagUtil.stringTolist(blog.getTags()));
            BlogCombination blogCombination=new BlogCombination(blog,type,tags);
            blogCombinationList.add(blogCombination);
        }
        return blogCombinationList;
    }

    /**
     * 根据找到的单个blog将其封装成BlogCombination返回
     * @param blog
     * @return
     */
    private BlogCombination getBlogCombination(Blog blog) {
        Type type=typeMapper.findTypeById(blog.getType());
        List<Tag> tags=tagMapper.findTagByIds(TagUtil.stringTolist(blog.getTags()));
        BlogCombination blogCombination=new BlogCombination(blog,type,tags);
        return blogCombination;
    }


}

```
### 4.Controller层
#### PageController
负责页面的返回

```java
package com.dreamchaser.controller;

import com.dreamchaser.pojo.*;
import com.dreamchaser.service.*;
import com.dreamchaser.utils.ArchivesUtil;
import com.dreamchaser.utils.MapUtil;
import com.dreamchaser.utils.MarkdownUtil;
import com.dreamchaser.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {
    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    CommentService commentService;
    @Autowired
    BlogCombinationService blogCombinationService;
    @Autowired
    CommentCombinationService commentCombinationService;


    @GetMapping("/login")
    public String login(){
        return "/admin/login";
    }

    @GetMapping("/admin/blog-input")
    public ModelAndView blog_input(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("types",typeService.findTypeAll());
        mv.addObject("tags",tagService.findTagAll());
        mv.addObject("method","post");
        mv.setViewName("admin/blog-input");
        return getModelAndView(mv);
    }

    @GetMapping("/admin/blog-input/{blogId}")
    public ModelAndView blog_input_update(@PathVariable Integer blogId){
        ModelAndView mv=new ModelAndView();
        mv.addObject("types",typeService.findTypeAll());
        mv.addObject("tags",tagService.findTagAll());
        mv.addObject("blog",blogService.findBlogById(blogId));
        mv.addObject("method","put");
        mv.setViewName("admin/blog-input");
        return getModelAndView(mv);
    }

    @GetMapping("/admin/blogs")
    public ModelAndView blogs(){
        ModelAndView mv=new ModelAndView();
        Map<String,Object>map=new HashMap<>();
        map.put("begin",0);
        map.put("size",6);
        mv.setViewName("admin/blogs");
        mv.addObject("types",typeService.findTypeAll());
        mv.addObject("blogs",blogCombinationService.findBlogCombinationByCondition(map));
        return getModelAndView(mv);
    }



    @GetMapping("/admin/comments")
    public ModelAndView comments(){
        ModelAndView mv=new ModelAndView();
        Map<String,Object> map=new HashMap<>();
        map.put("begin",0);
        map.put("size",6);
        mv.addObject("comments",commentCombinationService.findCommentByPage(map));
        mv.setViewName("admin/comments");
        return getModelAndView(mv);
    }
    @GetMapping("/admin/comments-details/{id}")
    public ModelAndView comments_details(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.addObject("comment",commentCombinationService.findCommentById(id));
        mv.setViewName("admin/comments-details");
        return getModelAndView(mv);
    }
    @GetMapping("/admin/tag-input")
    public ModelAndView tag_input(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("method","post");
        mv.setViewName("admin/tag-input");
        return getModelAndView(mv);
    }
    @GetMapping("/admin/tag-input/{id}")
    public ModelAndView tag_input(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.addObject("tag",tagService.findTagById(id));
        mv.addObject("method","put");
        mv.setViewName("admin/tag-input");
        return getModelAndView(mv);
    }

    @GetMapping("/admin/tags")
    public ModelAndView tags(){
        ModelAndView mv=new ModelAndView();
        Map<String,Object> map=new HashMap<>();
        map.put("begin",0);
        map.put("size",6);
        mv.addObject("tags",tagService.findTagByPage(map));
        mv.setViewName("admin/tags");
        return getModelAndView(mv);
    }
    @GetMapping("/admin/types")
    public ModelAndView types(){
        ModelAndView mv=new ModelAndView();
        Map<String,Object> map=new HashMap<>();
        map.put("begin",0);
        map.put("size",6);
        mv.addObject("types",typeService.findTypeByPage(map));
        mv.setViewName("admin/types");
        return getModelAndView(mv);
    }
    @GetMapping("/admin/types-input")
    public ModelAndView types_input(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/types-input");
        mv.addObject("method","post");
        return getModelAndView(mv);
    }
    @GetMapping("/admin/types-input/{id}")
    public ModelAndView types_input(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/types-input");
        mv.addObject("type",typeService.findTypeById(id));
        mv.addObject("method","put");
        return getModelAndView(mv);
    }

    @GetMapping("/page_blog/{id}")
    public ModelAndView blog(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("blog");
        BlogCombination blogCombination=blogCombinationService.findBlogCombinationById(id);
        blogCombination.setContent(MarkdownUtil.markdownToHtmlExtens(blogCombination.getContent()));
        mv.addObject("blog",blogCombination);
        Map<String,List<Comment>> map=commentService.findCommentsByBlog(id);
        mv.addObject("parents",map.get("parents"));
        mv.addObject("sons",map.get("sons"));
        return getModelAndView(mv);
    }


    @GetMapping("/archives")
    public ModelAndView archives(){
        ModelAndView mv=new ModelAndView();
        List<Blog>blogs=blogService.findBlogAllVisible();
        mv.addObject("number",blogs.size());
        mv.addObject("years", ArchivesUtil.handle(blogs));
        mv.setViewName("archives");
        return getModelAndView(mv);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam Map<String,Object> map){
        ModelAndView mv=new ModelAndView();
        //预处理
        if (map.get("begin")==null){
            map.put("begin",0);
        }else if (ObjectUtil.ObjectToInteger(map.get("begin")) <ObjectUtil.ObjectToInteger(map.get("size"))){
            map.replace("begin",0);
        }
        if (map.get("size")==null){
            map.put("size",6);
        }

        //所有博客分页查询
        //因为有一种情况是上一页下一页，前端发送begin和size，而后端接受到时是string，而数据库中limit后只能跟数字，所以得先对其做处理
        mv.addObject("blogs",blogCombinationService.findBlogCombinationByConditionVisible(MapUtil.handle(map)));
        //注意此时map其实已经处理过了，所以取出来的begin和size类型就是Integer
        mv.addObject("begin",map.get("begin"));
        mv.addObject("size",map.get("size"));

        map.put("begin",0);
        map.put("size",10);
        mv.addObject("types",typeService.findTypeByPage(map));
        mv.addObject("tags",tagService.findTagByPage(map));
        mv.setViewName("index");
        //最新推荐的博客
        map.put("isRecommend",1);
        mv.addObject("recommendedBlogs",blogService.findBlogByConditionVisible(map));

        List<Blog>blogs=blogService.findBlogAllVisible();
        mv.addObject("number",blogs.size());

        return getModelAndView(mv);
    }

    /**
     * 实现前台展示的search功能
     * @param map
     * @return
     */
    @GetMapping("/search")
    public ModelAndView index_search(@RequestParam Map<String, Object> map){
        ModelAndView mv=new ModelAndView();
        mv.addObject("blogs",blogCombinationService.findBlogCombinationByConditionVisible(map));
        mv.setViewName("search");
        return getModelAndView(mv);
    }



    @GetMapping("/page_tags")
    public ModelAndView page_tags(@RequestParam Map<String,Object>map){
        ModelAndView mv=new ModelAndView();
        List<Tag> tags=tagService.findTagAll();
        mv.addObject("tags",tags);
        //预处理，可以让接口有更多变化
        if (map.get("tagId")==null){
            map.put("tags",String.valueOf(tags.get(0).getId()));
        }else{
            map.put("tags",String.valueOf(map.get("tagId")));
        }
        //这里要把typeId转换为Integer，不然thymeleaf中比较时会因为类型问题导致if判断达不到想要的效果
        mv.addObject("tagId",ObjectUtil.ObjectToInteger(map.get("tags")));
        if (map.get("begin")==null){
            map.put("begin",0);
        }else if (ObjectUtil.ObjectToInteger(map.get("begin")) <ObjectUtil.ObjectToInteger(map.get("size"))){
            map.replace("begin",0);
        }
        if (map.get("size")==null){
            map.put("size",6);
        }
        mv.setViewName("tags");
        mv.addObject("blogs",blogCombinationService.findBlogCombinationByConditionVisible(MapUtil.handle(map)));
        mv.addObject("begin",map.get("begin"));
        mv.addObject("size",map.get("size"));
        return getModelAndView(mv);
    }
    @GetMapping("/about")
    public ModelAndView about(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("about");
        return getModelAndView(mv);
    }
    @GetMapping("/page_types")
    public ModelAndView page_types(@RequestParam Map<String,Object>map){
        ModelAndView mv=new ModelAndView();
        List<Type> types=typeService.findTypeAll();
        mv.addObject("types",types);
        //预处理，可以让接口有更多变化
        if (map.get("typeId")==null){
            map.put("type",types.get(0).getId());
        }else{
            map.put("type",map.get("typeId"));
        }
        //这里要把typeId转换为Integer，不然thymeleaf中比较时会因为类型问题导致if判断达不到想要的效果
        mv.addObject("typeId",ObjectUtil.ObjectToInteger(map.get("type")));
        if (map.get("begin")==null){
            map.put("begin",0);
        }else if (ObjectUtil.ObjectToInteger(map.get("begin")) <ObjectUtil.ObjectToInteger(map.get("size"))){
            map.replace("begin",0);
        }
        if (map.get("size")==null){
            map.put("size",6);
        }
        mv.setViewName("types");
        mv.addObject("blogs",blogCombinationService.findBlogCombinationByConditionVisible(MapUtil.handle(map)));
        mv.addObject("begin",map.get("begin"));
        mv.addObject("size",map.get("size"));
        return getModelAndView(mv);
    }

    /**
     * 由于前台页面都不footer部分都要有最新博客推荐，所以抽象分离出来，将其封装成一个方法
     * @param mv
     * @return
     */
    private ModelAndView getModelAndView(  ModelAndView mv) {
        Map<String,Object> map=new HashMap<>(3);
        map.put("begin",0);
        map.put("size",3);
        map.put("isRecommend",1);
        mv.addObject("newBlogs",blogService.findBlogByConditionVisible(map));
        return mv;
    }

}

```
#### BlogCtroller

```java
package com.dreamchaser.controller;

import com.dreamchaser.pojo.Blog;
import com.dreamchaser.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class BlogCtroller {
    @Autowired
    BlogService blogService;


    @PostMapping(value = "/blog")
    public ModelAndView  insertBlog(Blog blog){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/tip");
        if (blogService.addBlog(blog)==1){
            mv.addObject("message","博客保存成功!");
        }else {
            mv.addObject("message","博客保存失败!");
        }
        return mv;
    }
    @DeleteMapping(value = "/blog")
    public ModelAndView  deleteBlog(@RequestParam Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/tip");
        if (blogService.deleteBlog(id)==1){
            mv.addObject("message","博客删除成功!");
        }else {
            mv.addObject("message","博客删除失败!");
        }
        return mv;
    }
    @PutMapping(value = "/blog")
    public ModelAndView  update(Blog blog){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/tip");
        if (blogService.updateBlog(blog)==1){
            mv.addObject("message","博客更新成功!");
        }else {
            mv.addObject("message","博客更新失败!");
        }
        return mv;
    }
}

```
#### UserController

```java
package com.dreamchaser.controller;

import com.dreamchaser.pojo.User;
import com.dreamchaser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    HttpServletRequest request;
    @Autowired
    UserService userService;


    @PostMapping("/user/login")
    public ModelAndView loginUser(@RequestParam Map<String,Object> map,HttpSession session)throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        User user=userService.findUserByCondition(map);
        if (map.get("name")!=""&&map.get("password")!=""&&user!=null){
            session.setAttribute("user",user);
            modelAndView.setViewName("redirect:/admin/blogs");
        }else {
            modelAndView.addObject("tip","用户名或密码错误请重新输入!");
            modelAndView.setViewName("admin/login");
        }
        return modelAndView;
    }

    @GetMapping("/user/logout")
    public ModelAndView logOut(HttpSession session){
        ModelAndView modelAndView=new ModelAndView();
        session.removeAttribute("user");
        modelAndView.addObject("message","用户退出成功!");
        modelAndView.setViewName("/admin/tip");
        return modelAndView;
    }
}

```
#### ControllerExceptionHandler
作为异常处理的控制器

```java
package com.dreamchaser.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e)throws Exception {
        log.error("Request URL : {},Exception: {}", request.getRequestURL(), e);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("url",request.getRequestURL());
        modelAndView.addObject("exception",e);
        modelAndView.setViewName("error/error");
        return modelAndView;
    }
}

```
### 5.Intercepter层
#### UserIntercepter拦截器
```java
package com.dreamchaser.intercepter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class UserIntercepter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        Object user = request.getSession().getAttribute("user");
        if (user == null || user.equals(""))  {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

}

```

### 6.config层
#### WebMvcConfig
将拦截器加入项目

```java
package com.dreamchaser.cofig;

import com.dreamchaser.intercepter.UserIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserIntercepter()).addPathPatterns("/admin/**");
    }
}



```
### 7.utils层
#### ArchivesUtil

```java
package com.dreamchaser.utils;

import com.dreamchaser.pojo.Blog;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 用于归档的处理，把blog集合处理后以map形式返回，把blog根据年份分
 * @author 金昊霖
 */
public class ArchivesUtil {
    public static Map<Integer, List<Blog>> handle(List<Blog> blogs){
        Map<Integer, List<Blog>> map=new HashMap<>();
        for (Blog blog:blogs){
            //标记该blog的年份是否在map中存在
            Boolean flag=false;
            for (Integer year:map.keySet()){
                if (DateToInterger("yyyy",blog.getDate()).equals(year)){
                    map.get(year).add(blog);
                    flag=true;
                }
            }
            if (!flag){
                List<Blog> blogList=new ArrayList<>(6);
                blogList.add(blog);
                map.put(DateToInterger("yyyy",blog.getDate()),blogList);
            }
        }
        return map;
    }
    public static Integer DateToInterger(String format,Date date){
        String s=new SimpleDateFormat(format).format(date);

        return Integer.parseInt(s);
    }
}

```

#### MapUtil

```java
package com.dreamchaser.utils;

import java.util.Map;

/**
 * @author 金昊霖
 */
public class MapUtil {
    /**
     * 用于处理前端传递的数据，将分页查询的数据转换成Integer类，因为limit后面只能跟数字，否则会报错
     * @param map
     * @return
     */
    public static Map<String,Object> handle(Map<String,Object> map){
        Object begin=map.get("begin");
        Object size=map.get("size");
        map.replace("begin",Integer.parseInt(String.valueOf(begin)));
        map.replace("size",Integer.parseInt(String.valueOf(size)));
        return map;
    }
}

```
#### MarkdownUtil

```java
package com.dreamchaser.utils;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 用于把博客内容转换为html
 * @author 76756
 */
public class MarkdownUtil {
    public static String markdownToHtmlExtens(String markdown){
        //h标题生成id
        Set<Extension> headingAnchorExtension = Collections.singleton(HeadingAnchorExtension.create());
        //转换table的HTML
        List<Extension> tableExtension= Arrays.asList(TablesExtension.create());
        Parser parser =Parser.builder().extensions(tableExtension).build();
        Node document=parser.parse(markdown);
        HtmlRenderer renderer=HtmlRenderer.builder()
                .extensions(headingAnchorExtension)
                .extensions(tableExtension)
                .build();
        return renderer.render(document);
    }
}

```
#### TagUtil

```java
package com.dreamchaser.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理blog中tags和comment属性
 * @author 金昊霖
 */
public class TagUtil {
    public static List<Integer>  stringTolist(String s){
        List<Integer> integers=new ArrayList<>();
        String[] split = s.split(",");
        for (String s1:split){
            integers.add(Integer.parseInt(s1));
        }
        return integers;
    }
}

```
### 8.pom.xml

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.1.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.dreamchaser</groupId>
    <artifactId>blog</artifactId>
    <version>1.0.0</version>
    <name>blog</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>11</java.version>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
            <version>2.3.1.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.23</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.20</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.3</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <!--博客内容转html-->
        <dependency>
            <groupId>com.atlassian.commonmark</groupId>
            <artifactId>commonmark</artifactId>
            <version>0.15.1</version>
        </dependency>

        <dependency>
            <groupId>com.atlassian.commonmark</groupId>
            <artifactId>commonmark-ext-heading-anchor</artifactId>
            <version>0.15.1</version>
        </dependency>

        <dependency>
            <groupId>com.atlassian.commonmark</groupId>
            <artifactId>commonmark-ext-gfm-tables</artifactId>
            <version>0.15.1</version>
        </dependency>



    </dependencies>


    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                    <include>**/*.yml</include>
                    <include>**/*.properties</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.*</include>
                </includes>
            </resource>
        </resources>
    </build>


</project>

```
### 9.application.yml

```java
spring:
  datasource:
    username: root
    password: jinhaolin
    url: jdbc:mysql://localhost:3306/myblog?serverTimezone=Asia/Shanghai
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource
    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: SELECT 1 FROM DUAL
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
    server:
    port: 9090
  banner:
    location: banner.txt
  thymeleaf:
    cache: false
    mode: HTML
  mvc:
    hiddenmethod:
      filter:
        enabled: true
server:
  port: 9090
mybatis:
  type-aliases-package: com.dreamchaser.pojo


```
### 10.logback-spring.xml

```java
<?xml version="1.0" encoding="UTF-8"?>
<configuration scan="true" scanPeriod="60 seconds" debug="false">
    <include resource="org/springframework/boot/logging/logback/defaults.xml"/>
    <!-- 应用名称-->
    <property name="appName" value="Dreamchser"/>
    <!-- 日志的存放目录-->
    <!-- debug-->
    <property name="DEBUG_LOG_FILE_NAME_PATTERN" value="logs/${appName}-debug.%d{yyyy-MM-dd}.%i.log"/>
    <property name="INFO_LOG_FILE_NAME_PATTERN" value="logs/${appName}-info.%d{yyyy-MM-dd}.%i.log"/>
    <property name="WARN_LOG_FILE_NAME_PATTERN" value="errlogs/${appName}-warn.%d{yyyy-MM-dd}.%i.log"/>
    <property name="ERROR_LOG_FILE_NAME_PATTERN" value="errlogs/${appName}-error.%d{yyyy-MM-dd}.%i.log"/>
    <!-- 日志格式 -->
    <property name="CONSOLE_LOG_PATTERN"
              value="%clr(%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss.SSS}}){faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%c){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}"/>
    <property name="FILE_LOG_PATTERN"
              value="%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss.SSS}} ${LOG_LEVEL_PATTERN:-%5p} ${PID:- } --- [%t] %c : %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}"/>
    <!--输出到控制台-->
    <appender name="console" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>${CONSOLE_LOG_PATTERN}</pattern>
        </encoder>

    </appender>

    <!--输出到DEBUG文件-->
    <appender name="debug_file" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${DEBUG_LOG_FILE_NAME_PATTERN}</fileNamePattern>
            <!-- 日志保留天数 -->
            <maxHistory>30</maxHistory>
            <!-- 日志文件上限大小，达到指定大小后删除旧的日志文件 -->
            <totalSizeCap>2GB</totalSizeCap>
            <!-- 每个日志文件的最大值 -->
            <timeBasedFileNamingAndTriggeringPolicy
                    class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                <maxFileSize>50MB</maxFileSize>
            </timeBasedFileNamingAndTriggeringPolicy>
        </rollingPolicy>
        <encoder>
            <pattern>${FILE_LOG_PATTERN}</pattern>
        </encoder>
        <!-- 此日志文件只记录debug级别的 -->
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>debug</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
    </appender>

    <!--输出到INFO文件-->
    <appender name="info_file" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${INFO_LOG_FILE_NAME_PATTERN}</fileNamePattern>
            <!-- 日志保留天数 -->
            <maxHistory>7</maxHistory>
            <!-- 日志文件上限大小，达到指定大小后删除旧的日志文件 -->
            <totalSizeCap>1GB</totalSizeCap>
            <!-- 每个日志文件的最大值 -->
            <timeBasedFileNamingAndTriggeringPolicy
                    class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                <maxFileSize>50MB</maxFileSize>
            </timeBasedFileNamingAndTriggeringPolicy>
        </rollingPolicy>
        <encoder>
            <pattern>${FILE_LOG_PATTERN}</pattern>
        </encoder>
        <!-- 此日志文件只记录info级别的 -->
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>info</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
    </appender>

    <!--输出到WARN文件-->
    <appender name="warn_file" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${WARN_LOG_FILE_NAME_PATTERN}</fileNamePattern>
            <!-- 日志保留天数 -->
            <maxHistory>30</maxHistory>
            <!-- 日志文件上限大小，达到指定大小后删除旧的日志文件 -->
            <totalSizeCap>1GB</totalSizeCap>
            <!-- 每个日志文件的最大值 -->
            <timeBasedFileNamingAndTriggeringPolicy
                    class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                <maxFileSize>10MB</maxFileSize>
            </timeBasedFileNamingAndTriggeringPolicy>
        </rollingPolicy>
        <encoder>
            <pattern>${FILE_LOG_PATTERN}</pattern>
        </encoder>
        <!-- 此日志文件只记录warn级别的 -->
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>warn</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
    </appender>

    <!--输出到ERROR文件-->
    <appender name="error_file" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${ERROR_LOG_FILE_NAME_PATTERN}</fileNamePattern>
            <!-- 日志保留天数 -->
            <maxHistory>30</maxHistory>
            <!-- 日志文件上限大小，达到指定大小后删除旧的日志文件 -->
            <totalSizeCap>1GB</totalSizeCap>
            <!-- 每个日志文件的最大值 -->
            <timeBasedFileNamingAndTriggeringPolicy
                    class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                <maxFileSize>10MB</maxFileSize>
            </timeBasedFileNamingAndTriggeringPolicy>
        </rollingPolicy>
        <encoder>
            <pattern>${FILE_LOG_PATTERN}</pattern>
        </encoder>
        <!-- 此日志文件只记录error级别的 -->
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>error</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
    </appender>
    <!-- region 根据不同的环境设置不同的日志输出级别 -->
    <springProfile name="default,local,dev">
        <root level="info">
            <appender-ref ref="console"/>
        </root>
<!--        <logger name="com.dreamchaser" level="debug"/>-->
    </springProfile>


    <springProfile name="prod,pre,test">
        <root level="info">
            <appender-ref ref="console"/>
            <appender-ref ref="debug_file"/>
            <appender-ref ref="info_file"/>
            <appender-ref ref="warn_file"/>
            <appender-ref ref="error_file"/>

        </root>
<!--        <logger name="com.dreamchaser.mapper" level="debug"/>-->
    </springProfile>
    <!-- endregion -->

</configuration>
```
### 11.banner.txt(启动图标)

```java
    ,---,                                            ____            ,---,                                                
  .'  .' `\                                        ,'  , `.        ,--.' |                                                
,---.'     \   __  ,-.                          ,-+-,.' _ |        |  |  :                                        __  ,-. 
|   |  .`\  |,' ,'/ /|                       ,-+-. ;   , ||        :  :  :                  .--.--.             ,' ,'/ /| 
:   : |  '  |'  | |' | ,---.     ,--.--.    ,--.'|'   |  || ,---.  :  |  |,--.  ,--.--.    /  /    '     ,---.  '  | |' | 
|   ' '  ;  :|  |   ,'/     \   /       \  |   |  ,', |  |,/     \ |  :  '   | /       \  |  :  /`./    /     \ |  |   ,' 
'   | ;  .  |'  :  / /    /  | .--.  .-. | |   | /  | |--'/    / ' |  |   /' :.--.  .-. | |  :  ;_     /    /  |'  :  /   
|   | :  |  '|  | ' .    ' / |  \__\/: . . |   : |  | ,  .    ' /  '  :  | | | \__\/: . .  \  \    `. .    ' / ||  | '    
'   : | /  ; ;  : | '   ;   /|  ," .--.; | |   : |  |/   '   ; :__ |  |  ' | : ," .--.; |   `----.   \'   ;   /|;  : |    
|   | '` ,/  |  , ; '   |  / | /  /  ,.  | |   | |`-'    '   | '.'||  :  :_:,'/  /  ,.  |  /  /`--'  /'   |  / ||  , ;    
;   :  .'     ---'  |   :    |;  :   .'   \|   ;/        |   :    :|  | ,'   ;  :   .'   \'--'.     / |   :    | ---'     
|   ,.'              \   \  / |  ,     .-./'---'          \   \  / `--''     |  ,     .-./  `--'---'   \   \  /           
'---'                 `----'   `--`---'                    `----'             `--`---'                  `----'            


```
### 12.templates层
#### index.html

```java
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <!--移动端的预览设置，用于适配移动端-->
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link rel="stylesheet" href="/Semantic-UI-CSS-master/semantic.min.css">
    <link rel="stylesheet" href="/css/myblog.css">
    <title>首页</title>
</head>
<body>
    <!--导航-->
    <nav class="ui inverted attached segment m-padded-tb-mini m-shadow-small">
        <div class="ui container">
            <div class="ui inverted secondary menu stackable">
                <h2 class="ui teal header item">Blog</h2>
                <a href="/index" class="m-item item m-mobile-hide active"><i class="home icon"></i>首页</a>
                <a href="/page_types" class="m-item item m-mobile-hide"><i class="idea icon"></i>分类</a>
                <a href="/page_tags" class="m-item item m-mobile-hide"><i class="tags icon"></i>标签</a>
                <a href="/archives" class="m-item item m-mobile-hide"><i class="clone icon"></i>归档</a>
                <a href="/about" class="m-item item m-mobile-hide"><i class="info icon"></i>关于我</a>
                <div class="m-item right item  m-mobile-hide">
                    <form action="/search" method="get">
                        <div class="ui action input inverted transparent ">
                            <input type="text" name="title" placeholder="search...">
                            <button class="ui icon button" type="submit">
                                <i class="search icon"></i>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <a id="b1" href="#" class="ui menu toggle black icon button m-right-top m-mobile-show">
            <i class="sidebar icon"></i>
        </a>
    </nav>

    <!--中间内容-->
    <div class="m-padded-tb-large m-opacity-mini m-container ">
        <div class="ui container">
            <div class="ui grid stackable ">
                <!----左边博客列表--->
                <div class="eleven wide column ">
                    <!--头部-->
                    <div class="ui segment top attached ">
                        <div class="ui middle aligned grid two column">
                            <div class="column">
                                <h3 class="ui header teal">博客</h3>
                            </div>
                            <div class="column right aligned">
                                共<h2 class="ui orange header m-inline-block mth" th:text="${number}">&nbsp;14&nbsp; </h2>篇
                            </div>
                        </div>
                    </div>
                    <!--列表-->
                    <div class="ui attached segment ">
                        <div th:if="${blogs.size()==0}"><h2>没有更多的博客啦！不过未来说不定会有哦！QAQ</h2></div>
                        <div class="ui padded segment vertical m-padded-b-small m-mobile-clear" th:each="blog,iter:${blogs}">
                            <div class="ui grid mobile reversed stackable">
                                <div class="ui eleven wide column">
                                    <a th:href="@{'/page_blog/'+${blog.getId()}}" target="_blank">
                                        <h3 class="ui header" th:text="${blog.getTitle()}" >【一年总结】记我的大一生活</h3>
                                    </a>

                                    <p class="m-text-thin m-text-lined m-text-spaced" th:text="${blog.getSummary()}">去年夏天，平平无奇的我过着平平无奇的生活。一年之后，依旧是那个夏天，依旧是那个我，只是此时的我成了别人口中的“大佬”。而同是参加软件创新实验室的集训，别人是听课的那个，而我是讲课的那个。我感慨无限，是啊，奋斗真的可以改变人呢！</p>
                                    <div class="ui grid">
                                        <div class="eleven wide column">
                                            <div class="ui list horizontal link mini ">
                                                <div class="item">
                                                    <img src="/images/头像.jpg" class="ui avatar image">
                                                    <div class="content"><a href="#" class="header ">追梦</a></div>
                                                </div>
                                                <div class="item">
                                                    <i class="calendar icon" ></i><span th:text="${#dates.format(blog.getDate(),'yyyy-MM-dd')}">2020-7-04</span>
                                                </div>
                                                <div class="item">
                                                    <i class="eye icon"></i><span th:text="${blog.getViews()}">3012</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="five wide column right aligned ">
                                            <a th:href="@{'/page_types?typeId='+${blog.getType().getId()}}" target="_blank" class="ui label teal basic m-padded-tiny" th:text="${blog.getType().getName()}">一年总结</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="ui five wide column m-padded-tb-large">

                                    <a th:href="@{'/page_blog/'+${blog.getId()}}" target="_blank" >
                                        <img th:src="${blog.getPictureUrl()}" class="ui round image ">
                                    </a>
                                </div>
                            </div>

                        </div>

                    </div>

                    <!--底部-->
                    <div class="ui bottom attached segment">
                        <div class="ui middle aligned grid two column">
                            <div class="column">
                                <a class="ui button basic mini teal" th:href="@{'/index?begin='+${begin-size}+'&size='+${size}}">上一页</a>
                            </div>
                            <div class="column right aligned">
                                <a class="ui button basic mini teal" th:href="@{'/index?begin='+${begin+size}+'&size='+${size}}">下一页</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!----右边的top--->
                <div class="five wide column">
                    <div class="ui segments">
                        <!--secondary加个灰色的效果-->
                        <!--分类-->
                        <div class="ui secondary segment ">
                            <div class="ui two column grid">
                                <div class="column">
                                    <i class="idea icon"></i>分类
                                </div>
                                <div class="column right aligned">
                                    <a href="/page_types" target="_blank">more<i class="angle double right icon"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="ui teal segment">
                            <div class="ui fluid vertical menu">
                                <a  class="item" th:each="type,iter:${types}" th:href="@{'/page_types?typeId='+${type.getId()}}">
                                    <span th:text="${type.getName()}"></span>
                                    <div class="ui basic teal left pointing label" th:text="${type.getNumber()}">13</div>
                                </a>

                            </div>
                        </div>
                    </div>
                    <!--标签-->
                    <div class="ui segments m-margin-top-large">
                        <div class="ui secondary segment">
                            <div class="ui two column grid" >
                                <div class="column">
                                    <i class="tags icon"></i>标签
                                </div>
                                <div class="column right aligned">
                                    <a href="/page_tags" target="_blank">more<i class="angle double right icon"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="ui teal segment">
                            <a  target="_blank" class="ui basic teal left pointing label item m-margin-tb-tiny" th:each="tag,iter:${tags}" th:href="@{'/page_tags?tagId='+${tag.getId()}}">
                                <span th:text="${tag.getName()}">一年总结</span> <div class="detail" th:text="${tag.getNumber()}">1</div>
                            </a>


                        </div>
                    </div>
                    <!--最新推荐-->
                    <div class="ui segments m-margin-top-large">
                        <div class="ui secondary segment">
                            <div class="ui two column grid">
                                <div class="column">
                                    <i class="bookmark icon"></i>最新推荐
                                </div>  
                            </div>
                        </div>
                        <div class="ui segment " th:each="rblog,iter:${recommendedBlogs}">
                            <a th:href="@{'/page_blog/'+${rblog.getId()}}" target="_blank" class="m-color-black m-text-thin" th:text="${rblog.getTitle()}">【一年总结】记我的大一生活</a>
                        </div>

                    </div>
                    <!--二维码-->
                    <div class="ui horizontal divider header">扫码关注我</div>
                    <div class="ui card centered" style="width: 11em">
                        <img src="/images/csdn.png" alt="" class="ui rounded image">
                    </div>

                </div>
            </div>
        </div>

    </div>
    <br>
    <br>
    <!--底部footer-->
    <footer class="ui inverted vertical segment m-opacity-tiny">
        <div class="ui center aligned container">
            <div class="ui inverted divided stackable grid">
                <div class="two wide column ">
                    <h4 class="ui inverted header item m-text-thin m-text-spaced m-opacity-mini" >QQ讨论群</h4>
                    <div class="ui inverted link list">
                        <div class="item">
                            <img src="/images/QRcode.png" class="ui rounded image item" style="width: 100px">
                        </div>
                    </div>

                </div>
                <div class="five wide column">
                    <h4 class="ui inverted header m-text-thin m-text-spaced ">最新博客</h4>
                    <div class="ui inverted link list">
                        <a class="item m-text-lined" th:each="newBlog,iter:${newBlogs}" th:href="@{'/page_blog/'+${newBlog.getId()}}" th:text="${newBlog.getTitle()}">博客1</a>
                    </div>
                </div>
                <div class="three wide column">
                    <h4 class="ui inverted header m-text-thin m-text-spaced ">联系我</h4>
                    <div class="ui inverted link list">
                        <p class="item m-text-lined" href="#">QQ:767564319</p>
                        <p class="item m-text-lined" href="#">email:767564319@qq.com</p>
                        <a class="item m-text-lined" href="https://blog.csdn.net/qq_46101869">CSDN博客</a>
                    </div>
                </div>
                <div class="six wide column">
                    <h4 class="ui inverted header m-text-thin m-text-spaced">博客简介</h4>
                    <p class="m-text-small m-text-thin m-text-spaced m-opacity-mini" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;此博客为金昊霖的个人博客。在这里，记录了我的技术博客，记录了我的经
                        验分享，也记录了我生活的点滴，记录了我的成长。我特别喜欢一个词，那就是"追梦"，这也是我昵称的由来，同时也是我和我的团队筹备的一款app的名字
                        。人生在世，必然会有自己的梦想，不论这个梦想是大是小，是遥不可及还是触手可得，你所要坚信的便只有一件事——有梦便一定要去追，我们都该是追梦人！不论现在处境如何，我们都要去拼一拼，不试怎么知道你会不会成功呢？愿大家都能以梦为马，不负青春韶华！</p>
                </div>
            </div>
            <div class="ui divider "></div>
            <p class="m-text-thin m-text-spaced m-opacity-tiny m-text-lined">Copyright © 2020 Dreamchaser追梦 </p>
        </div>
    </footer>


<script src="/js/jquery-3.5.1.min.js"></script>
<script src="/Semantic-UI-CSS-master/semantic.min.js"></script>
    <script >

        $("#b1").click(function (){
            $(".m-item").toggleClass("m-mobile-hide");
        });
    </script>
</body>
</html>
```
#### blogs.html

```java
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <!--移动端的预览设置，用于适配移动端-->
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link rel="stylesheet" href="/Semantic-UI-CSS-master/semantic.min.css">
    <link rel="stylesheet" href="/css/myblog.css">
    <title>后台管理</title>


</head>
<body id="body">
    <!--导航-->
    <nav class="ui inverted attached segment m-padded-tb-mini m-shadow-small">
        <div class="ui container">
            <div class="ui inverted secondary menu stackable">
                <h2 class="ui teal header item">管理后台</h2>
                <a href="/admin/blogs" class="m-item active item m-mobile-hide"><i class="home icon"></i>博客</a>
                <a href="/admin/types" class="m-item item m-mobile-hide"><i class="idea icon"></i>分类</a>
                <a href="/admin/tags" class="m-item item m-mobile-hide"><i class="tags icon"></i>标签</a>
                <a href="/admin/comments" class="m-item item m-mobile-hide"><i class="comment icon"></i>评论管理</a>
                <div class="right menu">
                    <div class="ui dropdown item m-item m-mobile-hide">
                        <img src="/images/头像.jpg" class="ui avatar image">
                        &nbsp;&nbsp;金昊霖
                        <i class="dropdown icon"></i>
                        <div class="menu ">
                            <a class="item " href="/user/logout">注销</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <a id="b1" href="#" class="ui menu toggle black icon button m-right-top m-mobile-show">
            <i class="sidebar icon"></i>
        </a>
    </nav>

    <!--二级导航-->
    <div class="ui menu attached inverted ">
        <div class="ui container" >
            <a href="/admin/blog-input" class="item" >发布</a>
            <a href="/admin/blogs" class="active item">列表</a>
        </div>
    </div>
    <!--中间内容-->
    <div class="m-container-small m-padded-tb-big">
        <div class="ui container">
            <div  class="ui form segment inverted" >
                <div class="fields inline">
                    <div class="field">
                        <input type="text" name="title" placeholder="标题">
                    </div>
                    <input type="hidden" name="begin" value="0">
                    <input type="hidden" name="size" value="6">
                    <div class="field">
                        <div class="ui selection dropdown">
                            <input type="hidden" name="type" >
                            <i class="ui dropdown icon"></i>
                            <div class="default text">分类</div>
                            <div class="menu" >
                                <div class="item" th:each="type,iterStat:${types}" th:data-value="${type.getId()}"  th:text="${type.getName()}"></div>
                            </div>
                        </div>
                    </div>

                    <div class="field right aligned">
                        <button class="ui small teal basic button" onclick="initialization()"><i class="search icon"></i>搜索</button>
                    </div>
                </div>
            </div>
            <div id="table-container">
                <table th:fragment="table_refresh" th:id="id_table_refresh"  class="ui table inverted celled center aligned">
                    <thread>
                        <tr>
                            <th></th>
                            <th>标题</th>
                            <th>分类</th>
                            <th>更新时间</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                    </thread>
                    <tbody  >
                    <tr th:each="blog,iter:${blogs}">
                        <td th:text="(${iter.index}+1)">1</td>
                        <td th:text="${blog.getTitle()}">【一年总结】记我的大一生活</td>
                        <td th:text="${blog.getType().getName()}">一年总结</td>
                        <td th:text="${#dates.format(blog.getDate(),'yyyy-MM-dd')}">2020-7-04 15:12</td>
                        <td th:text="${blog.getState()==0}?'草稿':'已发布'">草稿</td>
                        <td>
                            <a class="ui button  teal basic mini " th:href="@{'/admin/blog-input/'+${blog.getId()}}" >编辑</a>
                            <button class="ui button  red basic mini " th:attr="data-id=${blog.getId()}" onclick="deleteBlog(this)">删除</button>

                        </td>

                    </tr>


                    </tbody>
                    <tfoot>
                    <tr >
                        <th colspan="6">
                            <div class="ui pagination menu mini">
                                <a onclick="pre()"  class="ui item ">上一页</a>
                                <a onclick="next()" class="ui item ">下一页</a>
                            </div>
                            <a href="/admin/blog-input" class="ui mini right floated teal basic button">新增</a>
                        </th>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
    <div class="ui divider "></div>
    <!--底部footer-->
    <footer class="ui inverted vertical segment m-opacity-tiny">
        <div class="ui center aligned container">
            <div class="ui inverted divided stackable grid">
                <div class="two wide column ">
                    <h4 class="ui inverted header item m-text-thin m-text-spaced m-opacity-mini" >QQ讨论群</h4>
                    <div class="ui inverted link list">
                        <div class="item">
                            <img src="/images/QRcode.png" class="ui rounded image item" style="width: 100px">
                        </div>
                    </div>

                </div>
                <div class="five wide column">
                    <h4 class="ui inverted header m-text-thin m-text-spaced ">最新博客</h4>
                    <div class="ui inverted link list">
                        <a class="item m-text-lined" th:each="newBlog,iter:${newBlogs}" th:href="@{'/page_blog/'+${newBlog.getId()}}" th:text="${newBlog.getTitle()}">博客1</a>
                    </div>
                </div>
                <div class="three wide column">
                    <h4 class="ui inverted header m-text-thin m-text-spaced ">联系我</h4>
                    <div class="ui inverted link list">
                        <p class="item m-text-lined" href="#">QQ:767564319</p>
                        <p class="item m-text-lined" href="#">email:767564319@qq.com</p>
                        <a class="item m-text-lined" href="https://blog.csdn.net/qq_46101869">CSDN博客</a>
                    </div>
                </div>
                <div class="six wide column">
                    <h4 class="ui inverted header m-text-thin m-text-spaced">博客简介</h4>
                    <p class="m-text-small m-text-thin m-text-spaced m-opacity-mini" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;此博客为金昊霖的个人博客。在这里，记录了我的技术博客，记录了我的经
                        验分享，也记录了我生活的点滴，记录了我的成长。我特别喜欢一个词，那就是"追梦"，这也是我昵称的由来，同时也是我和我的团队筹备的一款app的名字
                        。人生在世，必然会有自己的梦想，不论这个梦想是大是小，是遥不可及还是触手可得，你所要坚信的便只有一件事——有梦便一定要去追，我们都该是追梦人！不论现在处境如何，我们都要去拼一拼，不试怎么知道你会不会成功呢？愿大家都能以梦为马，不负青春韶华！</p>
                </div>
            </div>
            <div class="ui divider "></div>
            <p class="m-text-thin m-text-spaced m-opacity-tiny m-text-lined">Copyright © 2020 Dreamchaser追梦 </p>
        </div>
    </footer>


    <script src="/js/jquery-3.5.1.min.js"></script>
    <script src="/Semantic-UI-CSS-master/semantic.min.js"></script>
    <script  type="text/javascript">

        $("#b1").click(function (){
            $(".m-item").toggleClass("m-mobile-hide");
        });



        $('.ui.dropdown').dropdown({
            on: 'hover'
        })


        var currentPage=1;
        var size=6;
        var begin=0;

        function initialization() {
            begin=0;
            loadData();
        }
        function next() {
            currentPage++;
            begin+=size;
            loadData();
        }
        function pre() {
            if (begin>0){
                begin-=size;
                loadData();
            }
        }
        function loadData(){
            $.ajax({
                url:"/blogCombination_blogs",
                data:{"begin":begin,"size":size,title:$("[name='title']").val(),type: $("[name='type']").val(),},
                type:"get",
                success:function (result) {
                    $("#table-container").html(result);
                }
            })
        }

        function deleteBlog(button) {
            $.ajax({
                url: "/blog",
                data:{"id":$(button).attr("data-id")},
                type:"delete",
                success:function(result){
                    $("body").html(result);
                }
            })
        }



    </script>

</body>
</html>
```
## 八.部分测试结果及效果展示
这部分其实我不想写的，因为前言里提到了，全部展示出来又太费空间，这里就展示一部分前言里没提到过的效果图

### 登录页
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726173954273.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

登录失败效果
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726174033895.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
### 博客管理页
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726174211168.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
### 评论管理
#### 列表页
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726174311880.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
#### 详情页
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726174404308.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
### 归档页
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200726174544957.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
## 九、博客部署
这个部分我从租服务器开始讲，直至部署完成！
### 1、租服务器
这里我选择阿里云的服务器来进行演示
首先把你的账号注册完后打开活动页面，找到云翼计划（因为我是学生，有学生优惠），选择你需要的服务器，我这里选择的是ecs云服务器。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200807151040954.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
购买支付后打开实例详情
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200807151655763.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
### 2、连接服务器
点击更多设置你的密码，然后复制公网ip，打开远程桌面连接
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200807151815714.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)输入你的用户名（windows用户名默认是administrator，linux默认是root）和密码即可远程连接至服务器。

### 3、配置服务器环境
开始安装mysql数据库，以下是下载地址
https://dev.mysql.com/downloads/file/?id=497106

具体操作看这篇博文
https://blog.csdn.net/NOWSHUT/article/details/107722623

安装Navicat，创建myblog数据库，在此数据库中运行sql文件
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200807152410985.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

把你的jdk复制粘贴至服务器，然后配上环境变量

### 4、把项目打成jar包发布至服务器
在pom.xml中把打包方式设置为jar（`<packaging>jar</packaging>`
），使用package命令，然后你的target目录下就会出现一个jar文件
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200807152549638.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
将其复制粘贴至服务器上，选择你想要的存储的文件夹下，这里我直接选择c盘（不过建议大家还是创建个文件夹比较好）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200807152745642.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
在上面地址栏中输入cmd打开命令行，
输入：java -jar blog.jar

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200807152946507.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
启动成功！

### 5、设置服务器安全组
其实就是设置外网能访问的端口，
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020080715311658.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200807153121357.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

不知道怎么打开这个界面的可以看这里https://developer.aliyun.com/article/702814

### 6、访问项目
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200807153336115.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
博客部署成功了！


## 十、总结和收获
这个人博客系统总计耗时半个月，前端页面花了3天，后端设计编写花了12天。总计好多行代码QAQ

这次项目让我收获良多，原先我SpringBoot和SSM虽然学了，但是远没有到掌握的程度，真正做起项目来的时候还是要去看别人的博客。真正自己经历过设计，编写之后，我的工程能力有了很大的提升，对于架构方面也有了新的理解。

其实做过项目和没做过项目完全是两个层次的。

就算你理论学的再好，不实践，不去做项目，你的知识永远是在纸上谈兵，很多问题是你在设计编写的时候才能发现的，有些理解是你只有亲身经历才能懂得。

所以做项目真的很重要，这是成长最快的一种方式！

这也算是我正式写app后端之前的一种锻炼吧！


也希望未来的我能不忘初心，砥砺前行！

谨以此记，共勉！

该项目源码已上传至码云，[项目地址](https://gitee.com/dreamchasers/myblog)，需要的可以自行下载，对Java学习感兴趣的也可以加入q群1028457867，我们一起交流学习！

最后，欢迎访问[我的博客](http://dreamchaser.net.cn)！

如果对此项目有什么疑惑或者建议，欢迎大家在评论区评论指正。

<hr style=" border:solid; width:100px; height:1px;" color=#000000 size=1">

### 项目更新日志
2020.8.7 修复路径错误引发的bug，优化了配置属性，新增运行环境配置，添加了博客介绍

2020.8.14 修复添加标签分类时博客数量为空的bug 

2020.8.21 优化展示效果，完善浏览数功能 

2020.8.22  修复更新博客后浏览量归零的bug,修复无法删除博客的bug