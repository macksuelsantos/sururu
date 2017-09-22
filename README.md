# Sururu


It is an open source project with a collection of libraries for iOS platform, written in Kotlin. Its goal is to help programmers with common functionalities needed daily in most projects, making developing mobile apps easier. Basically, it is a result of refactoring on projects that I have worked on. This project is integrated with [Retrofit](https://github.com/square/retrofit), providing some abstraction for methods like: pushActivity; popActivity; overridePendingTransition; There is also view components to deal with type of fonts, dialog builders and auto resize text view. You can also find utility classes for currency, date and number format. There is string validation.

## Installation

### From Gradle

If you are using [Gradle](http://www.gradle.org/) as your dependency manager, you can simply add [Sururu's repository](https://github.com/macksuelsantos/sururu) and its dependency in your `build.gradle` file, as the example below.

```groovy
buildscript {
    ext.kotlin_version = '1.1.50'

    repositories {
        jcenter()
        google()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.0.0-beta6'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        classpath "org.jetbrains.kotlin:kotlin-android-extensions:$kotlin_version"
        classpath "io.realm:realm-gradle-plugin:3.7.2"
    }
}

allprojects {
    repositories {
        maven { url 'https://github.com/macksuelsantos/sururu/raw/master/repo' }
        jcenter()
        google()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
...
```

And in your `app\build.gradle` file, as the example below.
```groovy
dependencies {

    //Sururu
    implementation 'com.sururu.core:library:1.0.0'
    implementation 'com.sururu.restclient:library:1.0.0'
}
...
```

Be aware of the latest version.

### Manually

## Features

## Usage

## Dependencies

## Credits
Sururu was developed from the project [Ocypode](https://github.com/Ocypode/ocypode)

Sururu is brought to you by [Macksuel Santos](https://github.com/macksuelsantos) and [Jairo Barros Junior](https://github.com/jairobjunior), [contributors to the project](https://github.com/macksuelsantos/sururu/graphs/contributors). 

If you have feature suggestions or bug reports, feel free to help out by sending pull requests or by [creating new issues](https://github.com/macksuelsantos/sururu/issues/new). If you're using Sururu in your project, attribution would be nice.

## License
Copyright © 2017 Macksuel Santos

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
