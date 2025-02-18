/*pluginManagement {
    repositories {
//        maven { url = uri("https://mirrors.cloud.tencent.com/repository/gradle-plugins/") }
//        maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
        gradlePluginPortal()  // 保留官方 Gradle 插件门户
    }
}*/
pluginManagement {
    repositories {
        mavenLocal()
        /*maven {  url = uri("https://maven.aliyun.com/repository/central") }
        maven { url "https://maven.aliyun.com/repository/public" }
        maven {  url "https://maven.aliyun.com/repository/google" }
        maven { url "https://maven.aliyun.com/repository/gradle-plugin" }
        maven { name "Alibaba spring"; url "https://maven.aliyun.com/repository/spring" }
        maven { name "Alibaba spring-plugin"; url "https://maven.aliyun.com/repository/spring-plugin" }
        maven { name "Alibaba grails-core"; url "https://maven.aliyun.com/repository/grails-core" }
        maven { name "Alibaba apache-snapshots"; url "https://maven.aliyun.com/repository/apache-snapshots" }
        maven {
            url "https://mirrors.huaweicloud.com/repository/maven/"
            name = "华为开源镜像库"
        }
        maven { url "https://repo.spring.io/libs-release" }*/
        mavenCentral()
        gradlePluginPortal()
    }
}


rootProject.name = "db-docs"

include("db-docs-api", "db-docs-dao", "db-docs-service", "db-docs-base")