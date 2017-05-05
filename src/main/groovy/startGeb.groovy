import geb.Browser
import geb.binding.BindingUpdater
import org.openqa.selenium.Platform
import org.openqa.selenium.chrome.ChromeDriver

import java.awt.*

chromeDriverVersion = "2.29"

File downloadDriver(String currentPlatformName,
        String driverDownloadFullPath,
        String driverFilePath,
        String archiveFileExtension,
        String name,
        String version) {
    File destinationDirectory = new File("drivers/${name}-${version}-${currentPlatformName}")
    if (!destinationDirectory.exists()) {
        destinationDirectory.mkdirs()
    }
    File driverFile = new File("${destinationDirectory.absolutePath}/${driverFilePath}")
    String localArchivePath = "driver.${archiveFileExtension}"

    if (!driverFile.exists()) {
        def ant = new AntBuilder()
        ant.get(src: driverDownloadFullPath, dest: localArchivePath)

        switch (archiveFileExtension) {
            case "zip":
                ant.unzip(src: localArchivePath, dest: destinationDirectory)
                break
            case "tar.gz":
                ant.untar(src: localArchivePath, dest: destinationDirectory, compression: 'gzip')
                break
            case "tar.bz2":
                ant.untar(src: localArchivePath, dest: destinationDirectory, compression: 'bzip2')
                break
            default:
                ant.untar(src: localArchivePath, dest: destinationDirectory)
        }

        ant.delete(file: localArchivePath)
        ant.chmod(file: driverFile, perm: '700')
    }
    return driverFile
}

if (Platform.current.is(Platform.WINDOWS)) {
    currentPlatformName = Platform.WINDOWS.name()
    chromeDriverZipFileName = "chromedriver_win32.zip"
    chromeDriverExecFileName = "chromedriver.exe"
} else if (Platform.current.is(Platform.MAC)) {
    currentPlatformName = Platform.MAC.name()
    chromeDriverZipFileName = "chromedriver_mac64.zip"
    chromeDriverExecFileName = "chromedriver"
} else if (Platform.current.is(Platform.LINUX)) {
    currentPlatformName = Platform.LINUX.name()
    chromeDriverZipFileName = "chromedriver_linux64.zip"
    chromeDriverExecFileName = "chromedriver"
} else {
    throw new RuntimeException("Unsupported operating system [${Platform.current}]")
}

chromeDriverDownloadFullPath = "https://chromedriver.storage.googleapis.com/${chromeDriverVersion}/${chromeDriverZipFileName}"
chromeDriverLocalFile = downloadDriver(
        currentPlatformName,
        chromeDriverDownloadFullPath,
        chromeDriverExecFileName,
        'zip',
        "chrome",
        chromeDriverVersion)

System.setProperty('webdriver.chrome.driver', chromeDriverLocalFile.absolutePath)

chromeDriver = new ChromeDriver()


browser = new Browser(driver: chromeDriver)

binding = new Binding()
updater = new BindingUpdater(binding, browser)

updater.initialize()
