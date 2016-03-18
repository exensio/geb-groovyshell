import geb.Browser
import org.openqa.selenium.firefox.FirefoxBinary
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.firefox.internal.ProfilesIni
import geb.binding.BindingUpdater

pathToFirefox = new File("C:\\Program Files (x86)\\Mozilla Firefox ESR 38\\firefox.exe")
firefoxBinary = new FirefoxBinary(pathToFirefox)
profilesIni = new ProfilesIni()
firefoxProfile = profilesIni.getProfile("Firefox38ESRDEV")
firefoxDriver = new FirefoxDriver(firefoxBinary, firefoxProfile)

browser = new Browser(driver: firefoxDriver)

binding = new Binding()
updater = new BindingUpdater(binding, browser)

updater.initialize()