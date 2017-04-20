# DayBook 说明
　　`*DayBook*`——流水账应用服务端。为什么要创建这么个APP呢？很多人肯定都会说记账应用烂大街了。

　　工资不算低，但是每个月下来还是月光，想分析下每个月的流水，钱到底跑那儿去了。下载了几款成熟的记账APP，好家伙，广告、理财乱七八糟的各种推送。算了自己来吧！

# 技术说明
- 开发工具：Eclipse Mars
- 后台：SpringBoot+SpringData JPA
- 数据库：SQLite 数据库访问工具Navicat Premium
- APP：Ionic2  （三种方式 APP 微信 HTML） GitHub托管地址 [DayBookApp](https://github.com/zyqwst/DayBookApp)

# 内容说明
系统默认启动端口是9971，修改端口可以再src/main/resources/application.properties文件中修改 
####server.port=端口

# 系统打包
在项目根目录下直接运行下面的命令
mvn clean package assembly:single -Pprod -Dmaven.test.skip=true
打包成功后在根目录下target/DayBook即为打包的结果。
```
├── conf
├── DayBook-0.0.1-SNAPSHOT.jar
├── lib
├── DB.db （SQLite数据库文件，需要从项目根目录自行拷贝）
```
# 系统启动
上一步打包后，从命令行进入target/DayBook根目录；执行 `java -jar DayBook-0.0.1-SNAPSHOT.jar`即可看到启动过程。




