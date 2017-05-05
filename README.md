# Interactive Geb shell

Starts Chrome and provides a [groovy shell](http://www.groovy-lang.org/groovysh.html) to execute [geb](http://www.gebish.org) commands.

When starting to learn geb I wished to have a simple environment to try out some code snippets
before using them in my functional tests.
Especially when starting to learn geb it can be painful (and time-consuming) to restart your tests (including the whole application under test)
if you just want to try something out.

## Requirements

* Java 8
* ```JAVA_HOME``` has been set up

A [gradle wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html) is already included so their is 
no need to install gradle.

## Usage

### Starting the shell

####  Unix

    ./gradlew geb-groovyshell -q
    
#### Windows

    gradlew.bat geb-groovyshell -q
    
### Example

Inside groovy shell:

    browser.go("http://www.test.example") // protocol is needed
    def heading = browser.find(".heading") // finds the element with class 'heading'
    heading.text() // get the heading's text

## Config

All system properties are passed to the shell.

Example:
    ./gradlew geb-groovyshell -q -Dwebdriver.firefox.bin="/Applications/Firefox ESR.app/Contents/MacOS/firefox-bin"

## Troubleshooting

* After starting the browser you should be passed back to the groovy shell and be able to start typing your commands. If not: Most problems are caused by mismatching selenium and chrome version. You could try another combination by modifing `gebVersion` and `webdriverVersion` in `build.gradle` and the chrome driver version in `startGeb.groovy`.

	
See the offical selenium and geb docs for more information.
