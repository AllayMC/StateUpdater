plugins {
    id("java-library")
    id("maven-publish")
    id("signing")
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")
    apply(plugin = "signing")

    group = "org.allaymc"
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
            maven {
                name = "maven-deploy"
                url = uri(
                    System.getenv("MAVEN_DEPLOY_URL")
                        ?: "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
                )
                credentials {
                    username = System.getenv("MAVEN_DEPLOY_USERNAME") ?: "username"
                    password = System.getenv("MAVEN_DEPLOY_PASSWORD") ?: "password"
                }
            }
        }

        publications {
            create<MavenPublication>("maven") {
                from(components["java"])
                pom {
                    inceptionYear.set("2022")
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

    signing {
        val secret = System.getenv("PGP_SECRET")
        val passphrase = System.getenv("PGP_PASSPHRASE")
        if (secret != null && passphrase != null) {
            useInMemoryPgpKeys(secret, passphrase)
            sign(publishing.publications["maven"])
        }
    }

    tasks.test {
        useJUnitPlatform()
    }
}