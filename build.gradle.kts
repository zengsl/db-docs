plugins {
    java
    alias(libs.plugins.springboot)
    alias(libs.plugins.springDependencyManagement)
}


dependencyManagement {

}

allprojects {
    group = "com.zzz.dbdocs"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenLocal()
        maven { url = uri("https://mirrors.cloud.tencent.com/repository/maven") }
//        maven { url = uri("https://maven.aliyun.com/repository/public") }
        mavenCentral()
    }

    apply(plugin = "java")
    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
        }
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")

        /*mapstruct*/
        implementation("org.mapstruct:mapstruct:1.6.3")
        annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")

        /*lombok*/
        compileOnly("org.projectlombok:lombok")
        testCompileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")
        testAnnotationProcessor("org.projectlombok:lombok")
        /*lombok兼容mapstruct*/
        annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")

    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

/*dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}*/

