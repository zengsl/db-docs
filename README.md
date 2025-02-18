# 说明

生成表描述文档，用于验收文档中使用

## 支持数据库

- [x] 达梦DM8
- [x] MySQL

## 使用方式

### 单元测试执行

- 在application-mu.yml中配置数据源 
```yaml
db-docs:
  template:
    name: dbDoc.ftl
  data-source-map:
    "dm-test-1" :
      db-type: "dm"
      driver-class-name: dm.jdbc.driver.DmDriver
      # 数据库地址及端口号
      url: jdbc:dm://xxx:xx?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=Asia/Shanghai
      # 数据库用户名
      username: xx
      # 数据库密码
      password: xx
    "dm-test-2":
      db-type: "dm"
      driver-class-name: dm.jdbc.driver.DmDriver
      # 数据库地址及端口号
      url: jdbc:dm://xxx:xx?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=Asia/Shanghai
      # 数据库用户名
      username: xxx
      # 数据库密码
      password: xxx
    "mysql-test" :
      db-type: "mysql"
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://xxx:xx/xxx?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=Asia/Shanghai
      username: xx
      password: xx
```

配置文件中的"dm-test-1" ，"dm-test-2" ，"mysql-test" 为对应数据的key值，对应本文中的`dataSourceKey`

- 在ManualDbDocsGenText中通过`dataSourceKey`执行对应方法，文档生成在gen-docs目录下

### 启动项目执行

待完善...

## 配置

- 数据源配置 
```yaml
db-docs:
  data-source-map:
    "dm-test-1" :
      db-type: "dm"
      driver-class-name: dm.jdbc.driver.DmDriver
      # 数据库地址及端口号
      url: jdbc:dm://xxx:xx?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=Asia/Shanghai
      # 数据库用户名
      username: xx
      # 数据库密码
      password: xx
    "dm-test-2":
      ....
```
- 模版生成配置，没特殊需求保持默认即可，文档会在gen-docs目录下生成
```yaml
db-docs:
  template:
    name: xxx
    path: xxx
    outFilePath: xxx
    outFileName: xxx
```

## 开发


### 模版调整
默认模版：templates/dbDoc.ftl

dbDoc.docx 转 dbDoc.ftl
可以直接在ftl上面微调，如果改动较大则需考虑重新生成：
- 编辑dbDoc.docx
- 另存dbDoc.docx为`Word XML文档(*.xml)`
- 将xml格式文件修改模版格式(ftl)，然后加入模版语法进行渲染。

### 新增数据库支持
- 实现`DbDocsService`
- `DbType`增加新类型

## TODO

- [ ] Web界面
- [ ] 支持Oracle
- [ ] 补充UT

## 参考

* [dmdb-document](https://gitee.com/zoolye/dmdb-document)

