plugins {
//    id("io.micronaut.openapi") version "4.5.3"
    id("groovy")
    id("io.micronaut.application") version "4.5.3"
    id("com.gradleup.shadow") version "8.3.6"
    id("org.asciidoctor.jvm.convert") version "3.3.2"
    id("io.micronaut.aot") version "4.5.3"
}

version = project.properties["zendesk4jVersion"]!!
group = "lol.pbu"

apply(from = "gradle/asciidoc.gradle")
val kotlinVersion = project.properties["kotlinVersion"]
repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("io.micronaut.validation:micronaut-validation-processor")
    implementation("io.micronaut.reactor:micronaut-reactor-http-client")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut.data:micronaut-data-jdbc")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("org.slf4j:jul-to-slf4j")
    implementation("io.micronaut.validation:micronaut-validation")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.yaml:snakeyaml")
    testImplementation("org.testcontainers:spock")
    testImplementation("org.testcontainers:testcontainers")
    testImplementation("net.datafaker:datafaker:2.4.3")
}


application {
    mainClass = "lol.pbu.Application"
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
}


graalvmNative.toolchainDetection = false

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
//    openapi {
//        client(file("src/docs/asciidoc/oas.yaml")) {
//            apiPackageName = "lol.pbu.zendesk.api"
//            modelPackageName = "lol.pbu.zendesk.model"
//        }
//    }
}


tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("dockerfileNative") {
    jdkVersion = "17"
}


