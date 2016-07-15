:set interpreterMode true

// Workaround: we can't call this directly:
String script = "import geb.Browser\n" +
        "import geb.binding.BindingUpdater\n" +
        "import org.openqa.selenium.firefox.FirefoxDriver\n" +
        "new BindingUpdater(new Binding(), new Browser(driver: new FirefoxDriver()))"

Binding sharedData = new Binding()
GroovyShell shell = new GroovyShell(sharedData)

def updater = shell.evaluate(script).initialize()
def browser = updater.browser
def firefoxDriver = updater.browser.driver

println("You now can use the <<browser>> object to drive your browser.")