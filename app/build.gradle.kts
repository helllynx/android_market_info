import java.util.Properties

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlinx-serialization")
    id("de.mannodermaus.android-junit5")
    //id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "org.helllynx.marketstat"
        versionCode = 1
        versionName = "0.0.1"

        minSdkVersion(23)
        targetSdkVersion(29)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArgument(
            "runnerBuilder",
            "de.mannodermaus.junit5.AndroidJUnit5Builder"
        )

        setProperty("archivesBaseName", "${rootProject.name}-$versionName")
    }

    signingConfigs {
        val localProperties = File("${rootDir.path}/local.properties").run {
            if (exists()) Properties().apply { load(inputStream()) } else null
        }
        val environment = System.getenv()
        fun get(env: String, local: String) = environment[env] ?: run {
            project.logger.warn("WARNING: No $env environmental variable")
            localProperties?.getProperty(local) ?: run {
                project.logger.warn("WARNING: No $local local property")
                null
            }
        }

//        data class Keystore(
//            val storeFile: File,
//            val storePassword: String,
//            val keyAlias: String,
//            val keyPassword: String
//        )
//
//        fun getReleaseKeystore(): Keystore? {
//            return Keystore(
//                rootProject.file("signing/release.jks"),
//                get("ANDROID_KEYSTORE_PASSWORD", "signing.keystorePassword") ?: return null,
//                get("ANDROID_KEY_ALIAS", "signing.keyAlias") ?: return null,
//                get("ANDROID_KEY_PASSWORD", "signing.keyPassword") ?: return null
//            )
//        }

        /*getByName("debug") {
            storeFile = rootProject.file("signing/debug.keystore")
            storePassword = "debugdebug"
            keyAlias = "rmkdebug"
            keyPassword = "rmkdebug"
        }*/

//        getReleaseKeystore()?.let { keystore ->
//            create("release") {
//                storeFile = keystore.storeFile
//                storePassword = keystore.storePassword
//                keyAlias = keystore.keyAlias
//                keyPassword = keystore.keyPassword
//            }
//        } ?: project.logger.warn("WARNING: Can't create release signing config")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfigs.findByName("release")?.let { signingConfig = it }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packagingOptions {
        //Needs to resolve conflict with using JUnit5
        exclude("META-INF/LICENSE*")
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")

        productFlavors.forEach { flavor ->
            getByName(flavor.name).java.srcDirs("src/${flavor.name}/kotlin")
            "test${flavor.name.capitalize()}".let { getByName(it).java.srcDirs("src/$it/kotlin") }
            "androidTest${flavor.name.capitalize()}".let { getByName(it).java.srcDirs("src/$it/kotlin") }
        }
    }
}

dependencies {
    // region Language
    implementation(kotlin("stdlib-jdk8"))
    // endregion

    // region AndroidX
    implementation("androidx.core:core-ktx:1.3.0-alpha01")
    implementation("androidx.navigation:navigation-fragment-ktx:2.2.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.2.1")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    // endregion

    // region Core
    debugImplementation("com.readystatesoftware.chuck:library:1.1.0")
    releaseImplementation("com.readystatesoftware.chuck:library-no-op:1.1.0")

    implementation("com.github.RohitSurwase.UCE-Handler:uce_handler:1.4")
    implementation("org.kodein.di:kodein-di-generic-jvm:6.5.1")
    implementation("org.kodein.di:kodein-di-framework-android-x:6.5.1")

    implementation("com.squareup.retrofit2:retrofit:2.6.2")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.14.0")
    // endregion

    // region UI
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.google.android.material:material:1.2.0-alpha04")
    implementation("org.jetbrains.anko:anko-common:0.10.8")
    // endregion

    // region Tests
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")

    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    androidTestImplementation("de.mannodermaus.junit5:android-test-core:1.2.0")
    androidTestRuntimeOnly("de.mannodermaus.junit5:android-test-runner:1.2.0")
    // endregion

}
