plugins {
    id("groovy")
    id("io.micronaut.application") version "4.5.3"
    id("it.nicolasfarabegoli.conventional-commits") version "3.1.3"
    id("org.asciidoctor.jvm.convert") version "3.3.2"
    id("io.micronaut.aot") version "4.5.3"
}

version = project.properties["z4jVersion"]!!
group = "lol.pbu"

apply(from = "gradle/asciidoc.gradle")
repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("io.micronaut.validation:micronaut-validation-processor")
    implementation("io.micronaut.reactor:micronaut-reactor-http-client")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("org.slf4j:jul-to-slf4j")
    implementation("io.micronaut.validation:micronaut-validation")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    runtimeOnly("org.yaml:snakeyaml")
    testImplementation("org.testcontainers:spock")
    testImplementation("org.testcontainers:testcontainers")
    testImplementation("net.datafaker:datafaker:2.4.3")
}


application {
    mainClass = "lol.pbu.Application"
}
java {
    sourceCompatibility = JavaVersion.toVersion("17") // graalvm-ce
}

fun loadEnv() {
    if (file(".env").exists())
        file(".env").readLines().forEach {
            val (key, value) = it.split("=", limit = 2)
            System.setProperty(key.trim(), value.trim())
        }
}

tasks.withType<Test> {
    loadEnv()
    useJUnitPlatform()
}

micronaut {
    runtime("netty")
    testRuntime("spock2")
    processing {
        incremental(true)
        annotations("lol.pbu.*")
    }
    aot {
        // Please review carefully the optimizations enabled below
        // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading = false
        convertYamlToJava = false
        precomputeOperations = true
        cacheEnvironment = true
        optimizeClassLoading = true
        deduceEnvironment = true
        optimizeNetty = true
        replaceLogbackXml = true
    }
}
