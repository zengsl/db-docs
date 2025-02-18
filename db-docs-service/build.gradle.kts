dependencies {
    api(project(":db-docs-dao"))
    api(project(":db-docs-api"))
    implementation(libs.freemarker)
    implementation(libs.dmDriver)
    implementation(libs.mysqlDriver)
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
}