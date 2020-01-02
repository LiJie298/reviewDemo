# designpattern
<p>java设计模式整理</p>
<p>1、创建型</p>
    <p>工厂模式（Factory Pattern）
    <p>抽象工厂模式（Abstract Factory Pattern）
    <p>单例模式（Singleton Pattern）
    <p>建造者模式（Builder Pattern）
    <p>原型模式（Prototype Pattern）
<p>2、结构型模式</p>
    <p> 适配器模式（Adapter Pattern）
    <p> 桥接模式（Bridge Pattern）
    <p> 过滤器模式（Filter、Criteria Pattern）
    <p> 组合模式（Composite Pattern）
    <p> 装饰器模式（Decorator Pattern）
    <p> 外观模式（Facade Pattern）
    <p> 享元模式（Flyweight Pattern）
    <p> 代理模式（Proxy Pattern）
<p>3、行为型模式</p>
    <p>责任链模式（Chain of Responsibility Pattern）
    <p>命令模式（Command Pattern）
    <p>解释器模式（Interpreter Pattern）
    <p>迭代器模式（Iterator Pattern）
    <p>中介者模式（Mediator Pattern）
    <p>备忘录模式（Memento Pattern）
    <p>观察者模式（Observer Pattern）
    <p>状态模式（State Pattern）
    <p>空对象模式（Null Object Pattern）
    <p>策略模式（Strategy Pattern）
    <p>模板模式（Template Pattern）
    <p>访问者模式（Visitor Pattern）
<p>4、j2EE 模式</p>
    <p>MVC 模式（MVC Pattern）
    <p>业务代表模式（Business Delegate Pattern）
    <p>组合实体模式（Composite Entity Pattern）
    <p>数据访问对象模式（Data Access Object Pattern）
    <p>前端控制器模式（Front Controller Pattern）
    <p>拦截过滤器模式（Intercepting Filter Pattern）
    <p>服务定位器模式（Service Locator Pattern）
    <p>传输对象模式（Transfer Object Pattern）


# Java面试复习

## java基础

### jvm相关

- 内存结构

	- 1、方法区

		- 类信息，静态属性，常量信息
		- 线程共享
		- 运行时常量池

	- 2、堆区

		- 类实例，线程共享

	- 3、程序计数器

		- 线程私有
		- 没有OOM
		- JVM多线程是通过线程轮流切换并分配处理器执行时间的方式实现的，当线程切换后需要恢复到正确的执行位置(处理器)时，就是通过程序计数器来实现的

	- 4、本地方法栈

		- 异常

			- a.如果线程请求的栈深度大于JVM所允许的深度，将抛出StackOverflowError异常；
			- b.如果虚拟机栈可以动态扩容(大部分JVM都可以动态扩容),如果扩展时无法申请到足够的内存，就会抛出OutOfMemoryError异常。

	- 5、虚拟机栈

		- 线程私有
		- 局部变量表、操作数栈、动态链表、方法出口
		- 异常

			- a.如果线程请求的栈深度大于JVM所允许的深度，将抛出StackOverflowError异常；
			- b.如果虚拟机栈可以动态扩容(大部分JVM都可以动态扩容),如果扩展时无法申请到足够的内存，就会抛出OutOfMemoryError异常。

- 垃圾收集

	- 哪些内存需要回收？

		- 引用计数
		- 可达性分析

			- 为了解决对象之间互相引用的问题
			- GCRoot

				- 虚拟机栈（栈帧中的本地变量表）中引用的对象
				- 方法区中静态属性引用的对象
				- 方法区中常量引用的对象
				- 本地方法栈中JNI（Native方法）引用的对象

	- 什么时候回收？

		- 引用计数为0
		- 可达性分析 到达不了GCRoot

	- 如何回收？（垃圾收集算法）

		- 标记-清除算法

			- 缺点：产生内存碎片

		- 标记-整理算法

			- 缺点：效率问题

		- 复制算法

			- 缺点：内存使用大

		- 分代收集算法

	- jdk垃圾收集实现

		- 枚举根结点

			- 准确式GC
			- 类加载时 ，记录类内类型信息，JIT编译时，记录引用信息
			- OOPMap数据结构存储根结点

		- 安全点

			- 特定指令上记录OOPmap，特定指令 就是 安全点
			- GC时停止线程

				- 抢断式中断

					- 判断线程是不是运行到了安全点，没有：继续执行到安全点； 有：停止线程

				- 主动式中断

					- 设计标志，所有线程轮询这个标志。标识为真，自己挂起。标志 和 安全点重合

		- 安全区域

			- 该区域内对象的引用关系不会发生变化
			- 线程进入时，设计标示已进入了安全区域，gc时就不用考虑该线程了；
线程离开时，检查系统是否已经完成了根结点枚举，如果完成 继续执行，否则 等待执行完毕

	- JVM垃圾收集器

		- serial

			- 单线程
			- 复制算法

		- parNew

			- 多线程
			- 复制算法
			- 可以与CMS老年代 联合使用

		- parallel Scavenge

			- 多线程
			- 复制算法
			- 关注吞吐量，CPU用于用户的代码运行时间 与 CPU总消耗时间的比值

		- Serial old

			- 单线程
			- 标记-整理算法

		- parallel Old

			- 多线程
			- 标记-整理算法

		- CMS

			- 标记-清除算法
			- 过程

				- 初始标记

					- 标记一下GC Roots能直接关联的对象

				- 并发标记

					- 进行GC roots Tracing过程

				- 重新标记

					- 修正标记期间因用户程序继续运行而导致标记发生变动的对象

				- 并发清除

			- 简述

				- 初始标记和 并发标记 仍需要停止所有线程（STOP-The-World）。

			- 线程数：（cpu数量+3）/4

		- G1

- 启动参数
- 对象分配

	- 1、优先Eden分配
	- 2、对象晋升老年代的两种途径

		- 年龄超过16
		- 相同年龄的对象的大小占总容量大小的50%

### 数据类型

- boolean 1字节
- byte型  字节型  1字节
- char 字符型  2字节
- short 短整型  2字节
- int 整型  4字节
- long  长整型  8字节
- float 浮点型   4字节
- double 双精度浮点数 8字节

### io

- NIO

	- 主要元素

		- Channel

			- 表示到实体，如硬件设备、文件、网络套接字或可以执行一个或多个不同 I/O 操作（如读取或写入）的程序组件的开放的连接。Channel接口的常用实现类有FileChannel（对应文件IO）、DatagramChannel（对应UDP）、SocketChannel和ServerSocketChannel（对应TCP的客户端和服务器端）

		- Select

			- 用于监听多个通道的事件（比如：连接打开，数据到达）。因此，单个的线程可以监听多个数据通道。即用选择器，借助单一线程，就可对数量庞大的活动I/O通道实施监控和维护。

		- Buffer

			- 是一个用于存储特定基本类型数据的容器。除了boolean外，其余每种基本类型都有一个对应的buffer类。Buffer类的子类有ByteBuffer, CharBuffer, DoubleBuffer, FloatBuffer, IntBuffer, LongBuffer, ShortBuffer 

- IO

### 多线程

- 实现方式

	- 实现 Runnable
	- 实现 callable
	- 继承 Thread

- 锁

	- 状态

		- 新建

			- new

		- 就绪

			- start

		- 运行

			- 线程开始执行

		- 阻塞
		- 挂起

			- wait

		- 停止

			- stop

	- 类型

		- 自旋锁
		- 可重入锁

			- ReentrantLock

		- 偏向锁/轻量级锁/重量级锁
		- 互斥锁/读写锁
		- 公平锁/非公平锁
		- 乐观锁/悲观锁

			- actomic

- 线程池

	- 参数

		- 主线程数量
		- 最大线程数
		- 空闲线程存活时间
		- 存活时间单位
		- 工作线程队列
		- 拒绝策略

			- AbortPolicy：被拒绝后直接报错
			- CallerRunsPolicy：会在线程池当前正在运行的Thread线程池中处理被拒绝的任务。
			- DiscardOldestPolicy：线程池会放弃等待队列中最旧的未处理任务，然后将被拒绝的任务添加到等待队列中
			- DiscardPolicy：线程池将丢弃被拒绝的任务。

		- 线程工厂

	- 常用线程池

		- Executors.newFixedThreadPool

			- new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>(),
                                      threadFactory)

		- Executors.newScheduledThreadPool

			- new ScheduledThreadPoolExecutor(corePoolSize, threadFactory)

		- Executors.newCachedThreadPool

			- new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>())

		- Executors.newSingleThreadExecutor

			- new ThreadPoolExecutor(1, 1,0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>(), 
                                    threadFactory))

### 语法

### 关键字

## 数据结构

### tree

- 平衡二叉树
- 二叉查找书
- 红黑数
- B-数
- B+数

### list

- ArrayList
- LinkedList
- Vector

### set

- hashSet
- TreeSet
- LinkedHashSet

### queue

- 队列 先进先出

### stack

- 栈 先进后出

### heap

- 大顶堆
- 小顶堆

## 开发框架

### Spring

### Hibernate

### mybatis

### Dubbo

## 数据存储

### Mysql

### Mongo

### Redis

### ES

## 消息同步

### Kafka

## 算法

### 排序算法

- 冒泡排序
- 快速排序
- 插入排序
- 归并排序
- 希尔排序
- 堆排序

	- priorityQueue

### 查找算法

- 二分查找
- hash
- 顺序查找
- 二叉树查找
  
