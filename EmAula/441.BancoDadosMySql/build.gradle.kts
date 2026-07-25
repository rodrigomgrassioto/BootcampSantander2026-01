plugins {
    id("java")
}

group = "com.devrodrigo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // BANCO DE DADOS
    // Source: https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
    implementation("com.mysql:mysql-connector-j:9.7.0")

    // Source: https://mvnrepository.com/artifact/org.flywaydb/flyway-core
    implementation("org.flywaydb:flyway-core:12.10.0")

    // Source: https://mvnrepository.com/artifact/org.flywaydb/flyway-mysql
    implementation("org.flywaydb:flyway-mysql:12.10.0")


    // OUTROS
    // Source: https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly("org.projectlombok:lombok:1.18.46")
    annotationProcessor("org.projectlombok:lombok:1.18.46")
    // @Data             // Gera todos os Getters, Setters, toString, equals e hashCode automaticamente
    // @NoArgsConstructor // Gera um construtor vazio automático
    // @AllArgsConstructor // Gera um construtor com todos os atributos automático
}

tasks.test {
}