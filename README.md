Android Test Analytics SDK
=================


## Description

Basic analytics features are implemented to track events with properties!

# Integrate Test Analytics SDK

Prerequisites

1. To build a project using the Analytics SDK for Android, you need version Android Studio Flamingo |
   2022.2.1 or later of Android Studio.
2. Developers with knowledge of Java and Kotlin

SDK Compiled With

* Android Studio Hedgehog | 2023.1.1
* Target and Compile version 34



## Integration Steps
1. Copy the Analytics module and paste on your root directory

2. Add the following code on setting.gradle file

```
  include(":analytics")   

```
3. Add the following code to your app build.gradle file
```
implementation(project(":analytics"))
```

4. Add below line inside android block in app's build.gradle

```
compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
```
5. Initialize the SDK and start the analytics session 
```
    AnalyticsSDK.Builder().chukkerEnable(false).apiKey("").appVersion("1.0.1").environment(ENVIRONMENT.DEBUG).build().start(this)
```
To add events and properties use the following function
```
val event = Event("AppLaunched", mapOf("action" to "launched", "label" to "launched an app"))
        AnalyticsSingleton.addEvent(event)

//Where Event is a data class from Sdk
data class Event(
    val name: String,
    val properties: Map<String, Any>
)
```
To end the analytics session use the following function.
```
      AnalyticsSingleton.stopSession()
```
Parameters:

1. `apiKey` - Unique key to access SDK but you can use a random string or "" too(String).
2. `appVersion` - Version of your app to track version-related data on analytics(String).
3. `chuckerEnabled` - This is for logging API hits to debug API request response you can set false for now(Boolean).
4. `environment` - Current app environment like UAT,DEBUG etc for now i have added 4 enums value
enum class ENVIRONMENT {
    PRODUCTION, DEBUG, UAT, PREPRODUCTION
}
#Note all the parameters are mandatory for now.
 
