import geb.Browser
import geb.binding.BindingUpdater
import org.openqa.selenium.firefox.FirefoxDriver

firefoxDriver = new FirefoxDriver()

browser = new Browser(driver: firefoxDriver)

binding = new Binding()
updater = new BindingUpdater(binding, browser)

updater.initialize()
