# DEPRECATED
This library has been deprecated and is no longer in use at Hudl.
If you've been using this library, please consider adopting [ReactFragment](https://github.com/facebook/react-native/blob/master/ReactAndroid/src/main/java/com/facebook/react/ReactFragment.java) in the main react-native repo.

# react-native-android-fragment
A utility library for facilitating React Native development with Android Fragments.

## Getting started

`$ npm install react-native-android-fragment --save`

or

`$ yarn add react-native-android-fragment`

### Mostly automatic installation

`$ react-native link react-native-android-fragment`

### Manual installation

#### Android

1. Append the following lines to `android/settings.gradle`:
      ```
      include ':react-native-android-fragment'
      project(':react-native-android-fragment').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-android-fragment/android')
      ```
2. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
      ```
      compile project(':react-native-android-fragment')
      ```
3. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.hudl.oss.react.fragment.ReactFragment;` to the imports at the top of the file

## Usage
The primary component in this library is [ReactFragment](https://github.com/hudl/react-native-android-fragment/blob/master/react-native-android-fragment/src/main/java/com/hudl/oss/react/fragment/ReactFragment.java)
You can use this class directly if you wish, or you can extend from it to simplify your code.

A Builder pattern is provided out of the box for easy usage:
```java
Fragment messagingFragment = new ReactFragment.Builder()
       .setComponentName("HelloWorld")
       .setLaunchOptions(launchOptions) // A Bundle of launch options
       .build();
```

In your Activity make sure to override `onKeyUp()` in order to access the In-App Developer menu:

```java
@Override
public boolean onKeyUp(int keyCode, KeyEvent event) {
    boolean handled = false;
    Fragment activeFragment = getSupportFragmentManager().findFragmentById(R.id.container_main);
    if (activeFragment instanceof ReactFragment) {
        handled = ((ReactFragment) activeFragment).onKeyUp(keyCode, event);
    }
    return handled || super.onKeyUp(keyCode, event);
}
```

## Running Sample App

NOTE: Make sure your environment is set up for [React Native](https://facebook.github.io/react-native/docs/getting-started.html) and [Android](https://developer.android.com/training/index.html) development.

- Clone the repo
- Open a terminal and navigate to the root directory of your checkout
- `yarn link`
- `cd example`
- `yarn link react-native-android-fragment`
- `react-native link react-native-android-fragment`
- `react-native run-android`
