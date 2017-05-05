# DAndroidUtils

DAndroidUtils是我在Android开发中的一些常用功能封装。

其中功能包括多种，如：多种实现loading等待框。你只需引入library之后一行代码

实现此功能。引入依赖非常简单支持导入library,gradle和maven等多种方式。

- **其中常用工具类utils包括:**

1,正则提供验证邮箱、手机号、电话号码、身份证号码、数字等方法

2,log打印日志的工具类

3，Toast封装工具类

4，Activity的管理工具类

5，通过url获取Json数据 // 通过url获取网络Bitmap数据 （httpClient所完成）

6,网络状态的判断（是否有网络，以及网络是3G,WIFI等状况）

7,多种loading等待框的介绍与使用。

8,sharepreference的完美封装。

- **使用Gradle构建时添加依赖代码如下:**

```compile 'com.david.dandroidlibrary:dandroidlibrary:1.0.0'
```

- **使用Maven构建时添加依赖代码如下:**


```
<dependency>
   <groupId>com.david.dandroidlibrary</groupId>
   <artifactId>dandroidlibrary</artifactId>
   <version>1.0.0</version>
   <type>pom</type>
 </dependency>
```

使用介绍以及功能介绍请参考示例项目的配置与使用。

项目里面有library源代码，你只需导入library即可查看和引用里面的功能。

你也可以直接将项目导入自己的开发工具中。这样项目默认已经引用了library。

## ##


[作者：程序员小冰](http://blog.csdn.net/qq_21376985)

[欢迎点击关注我的微博](http://weibo.com/mcxiaobing)

更多功能会持续封装添加。提高我们的开发速度，欢迎star。fork。
