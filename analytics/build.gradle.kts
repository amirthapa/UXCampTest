import java.util.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("maven-publish")
}
//fun getLocalProperty(key: String): String? {
//    val propertiesFile = rootProject.file("github.properties")
//    if (!propertiesFile.exists()) {
//        return null
//    }
//    val properties = Properties()
//    properties.load(propertiesFile.inputStream())
//    return properties.getProperty(key)
//}
//val githubUser: String? = getLocalProperty("gpr.user") ?: System.getenv("USERNAME")
//val githubToken: String? = getLocalProperty("gpr.token") ?: System.getenv("TOKEN")
//
//val getVersionName = { "1.0.1" }
//val getArtifactId = { "uxTestAnalytics" }



android {
    namespace = "com.uxcamp.analytics"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
       release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildToolsVersion = "29.0.2"
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    //kotpref
    implementation ("com.chibatching.kotpref:kotpref:2.4.0")
    implementation ("com.chibatching.kotpref:initializer:2.4.0") // optional
    implementation ("com.chibatching.kotpref:gson-support:2.4.0")
    implementation ("com.chibatching.kotpref:enum-support:2.4.0")
    //room database
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")

}



//publishing{
//    publications{
//        create<MavenPublication>("bar") {
//            groupId = "com.ux.analytics"
//            version = getVersionName()
//            artifactId = getArtifactId()
//
//            artifact("$buildDir/outputs/aar/${artifactId}-release.aar")
//
//            pom {
//                name.set("Sample Android Library for analytics")
//                description.set("A sample Android library.")
//                url.set("https://github.com/amirthapa/UXCampTest.git")
//
//                licenses {
//                    license {
//                        name.set("The Apache License, Version 2.0")
//                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
//                    }
//                }
//
//                developers {
//                    developer {
//                        id.set("amirthapa")
//                        name.set("Amir Thapa")
//                        email.set("aameer.thapa1@gmail.com")
//                    }
//                }
//
//                scm {
//                    connection.set("scm:git:https://github.com/amirthapa/UXCampTest.git")
//                    developerConnection.set("scm:git:https://github.com/amirthapa/UXCampTest.git")
//                    url.set("https://github.com/amirthapa/UXCampTest")
//                }
//            }
//        }
//            }
//
//    }
//repositories {
//    maven {
//        name = "GitHubPackages"
//        url = uri("https://maven.pkg.github.com/amirthapa/UXCampTest")
//        credentials {
//            username = githubUser
//            password = githubToken
//        }
//    }
//}







