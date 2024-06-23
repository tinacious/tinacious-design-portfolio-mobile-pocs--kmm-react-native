# Portfolio React Native

- [Build Android](#build-android)
- [Build iOS](#build-ios)


## Build Android

Add Android (shouldn't be necessary since the `./android` directory exists):

    expo prebuild -p android

Build everything:

    npx react-native build-android --interactive

Install the built APK:

    adb install android/app/build/outputs/apk/release/app-release.apk


## Build iOS

Add iOS (shouldn't be necessary since the `./ios` directory exists):

    expo prebuild -p android

With Cocoapods version 1.15:

    pod install --repo-update
