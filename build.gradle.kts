plugins {
    id("java-library")
    id("maven-publish")
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")

    description = "Updates Minecraft: Bedrock Edition block & item states to the latest revision"

    repositories {
        mavenCentral()
        maven("https://www.jitpack.io/")
    }

    dependencies {
        implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
        implementation("org.allaymc:NBT:3.0.9")

        compileOnly("org.projectlombok:lombok:1.18.34")
        annotationProcessor("org.projectlombok:lombok:1.18.34")

        testImplementation(platform("org.junit:junit-bom:5.10.3"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }

    publishing {
        repositories {
            // Jitpack requires us to publish artifacts to local maven repo
            mavenLocal()
        }

        publications {
            create<MavenPublication>("maven") {
                from(components["java"])

                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()

                pom {
                    inceptionYear.set("2024")
                    packaging = "jar"
                    url.set("https://github.com/AllayMC/StateUpdater")

                    scm {
                        connection.set("scm:git:git://github.com/AllayMC/StateUpdater.git")
                        developerConnection.set("scm:git:ssh://github.com/AllayMC/StateUpdater.git")
                        url.set("https://github.com/AllayMC/StateUpdater")
                    }

                    licenses {
                        license {
                            name.set("LGPL 3.0")
                            url.set("https://www.gnu.org/licenses/lgpl-3.0.en.html")
                        }
                    }

                    developers {
                        developer {
                            name.set("CloudburstMC Team")
                            organization.set("CloudburstMC")
                            organizationUrl.set("https://github.com/CloudburstMC")
                        }
                        developer {
                            name.set("AllayMC Team")
                            organization.set("AllayMC")
                            organizationUrl.set("https://github.com/AllayMC")
                        }
                    }
                }
            }
        }
    }

    tasks {
        withType<JavaCompile> {
            options.encoding = "UTF-8"
        }

        withType<Test> {
            useJUnitPlatform()
        }
    }
}