# DAndroidUtils

DAndroidUtils是(程序员小冰)david在Android开发中的一些常用功能封装。

其中功能包括多种，如：多种实现loading等待框。你只需引入library之后一行代码

实现此功能。引入依赖非常简单支持导入library,gradle和maven等多种方式。

- **其中常用工具类utils包括:**

1,log打印日志的工具类

2,Toast封装工具类

3,Activity的管理工具类

4,网络状态的判断（是否有网络，以及网络是3G,WIFI等状况）

5,多种loading等待框的介绍与使用。

更多丰富的功能。后续会抽时间尽快更新。

- **使用Gradle构建时添加依赖代码如下:**

`compile 'com.david.dandroidlibrary:dandroidlibrary:1.0.2'`

- **使用Maven构建时添加依赖代码如下:**


```
<dependency>
   <groupId>com.david.dandroidlibrary</groupId>
   <artifactId>dandroidlibrary</artifactId>
   <version>1.0.2</version>
   <type>pom</type>
 </dependency>
```

- **使用Ivy构建时添加依赖代码如下:**


```
<dependency org='com.david.dandroidlibrary' name='dandroidlibrary' rev='1.0.2'>
  <artifact name='dandroidlibrary' ext='pom' ></artifact>
</dependency>
```

如果使用eclipse可以 [点击这里下载aar文件](https://dl.bintray.com/davidzheng/dandroidlibrary/com/david/dandroidlibrary/dandroidlibrary/), 然后用zip解压, 取出jar文件.

使用介绍以及功能介绍请参考示例项目的配置与使用。

项目里面有library源代码，你只需导入library即可查看和引用里面的功能。

你也可以直接将项目导入自己的开发工具中。这样项目默认已经引用了library。

## ##


[作者：程序员小冰](http://blog.csdn.net/qq_21376985)

[欢迎点击关注我的微博](http://weibo.com/mcxiaobing)

更多功能会持续封装添加。提高我们的开发速度，欢迎star。fork。


- **[version版本功能简单介绍:](https://github.com/QQ986945193/DAndroidUtils/wiki)**

1.0.0版本功能：只有loading

1.0.1版本添加功能：网络判断，日志等工具类。并可以自定义设置是否可按返回键取消。

1.0.2版本：再次添加一些工具类。并新增功能刷新以及加载更多的自定义View.


当然如果我的项目帮到了你，欢迎进行打赏，请作者喝杯茶。谢谢支持。

![支付宝](http://img.blog.csdn.net/20170824172803870?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjEzNzY5ODU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![微信](http://img.blog.csdn.net/20170824172832927?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjEzNzY5ODU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

