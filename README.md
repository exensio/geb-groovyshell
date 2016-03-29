# Interactive GEB shell

Starts Firefox and provides a shell to execute [Geb](http://www.gebish.org) commands.

## Usage

### Unix

    ./gradlew geb-interactive -q

## Firefox version

If you have multiple versions of firefox installed, you can specify which is used with the `webdriver.firefox.bin`
system property:

    ./gradlew geb-interactive -q -Dwebdriver.firefox.bin="/Applications/Firefox ESR.app/Contents/MacOS/firefox-bin"

All system properties are passed to the shell. See https://github.com/SeleniumHQ/selenium/wiki/FirefoxDriver for
additional webdriver settings.