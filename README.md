# Toolkit

[![](https://jitpack.io/v/hankli0130/Toolkit.svg)](https://jitpack.io/#hankli0130/Toolkit)

Basic Kotlin constants, functions and classes to help building Android Apps efficiently.

## How to install?

1. If you're using Gradle 7 or above, add it in your root `settings.gradle` at the end of
   repositories:

``` gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

Otherwise, add it in your root `build.gradle` at the end of repositories:

``` gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
	}
}
```

2. Add the dependency in your app `build.gradle`

``` gradle
dependencies {
    implementation 'com.github.hankli0130:toolkit:Tag'
}
```

That's it and enjoy!