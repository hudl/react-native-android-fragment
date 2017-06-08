# react-native-android-fragment
A utility library for facilitating React Native development with Android Fragments.

## Download
React Native Android Fragment isn't available via npm. This is intended to be used solely in an Android Project and therefore we are shipping this over jcenter (maven/gradle).
You can download via Gradle:

```gradle
repositories {
  jcenter()
}

dependencies {
  // Version will correspond to its dependnecy on React Native
  compile 'com.hudl.oss:react-native-android-fragment:0.44.0'
}
```

Or Maven:

```xml
<dependency>
  <groupId>com.hudl.oss</groupId>
  <artifactId>react-native-android-fragment</artifactId>
  <version>0.44.0</version>
</dependency>
```

## Usage
The primary component in this library is [ReactFragment](https://github.com/hudl/react-native-android-fragment/blob/master/react-native-android-fragment/src/main/java/com/hudl/react/fragment/ReactFragment.java)
You can use this class directly if you wish, or you can extend from it to simplify your code.

A Builder pattern is provided out of the box for easy usage:
```java
Fragment messagingFragment = new ReactFragment.Builder()
       .setComponentName("HelloWorld")
       .setLaunchOptions(launchOptions) // A Bundle of launch options
       .build();
```