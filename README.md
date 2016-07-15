# Interactive Geb shell

Starts Firefox and provides a [groovy shell](http://www.groovy-lang.org/groovysh.html) to execute [geb](http://www.gebish.org) commands.

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

    browser.drive("http://www.test.example") // protocol is needed
    def heading = browser.find(".heading") // finds the element with class 'heading'
    heading.text() // get the heading's text
    
### Shutting down

Use the provided ```stopGeb.groovy``` to close the browser:

Inside groovy shell:

    :load src/main/groovy/stopGeb.groovy // loads commands from file
    :exit // exit the groovy shell

## Config

If you have multiple versions of firefox installed, you can specify which is used with the `webdriver.firefox.bin`
system property:

    ./gradlew geb-groovyshell -q -Dwebdriver.firefox.bin="/Applications/Firefox ESR.app/Contents/MacOS/firefox-bin"
    
Alternatively you can use ```gradle.properties``` to do the same.
An example is already included but commented out.

All system properties are passed to the shell. See https://github.com/SeleniumHQ/selenium/wiki/FirefoxDriver for
additional webdriver settings.