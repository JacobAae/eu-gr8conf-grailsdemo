import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.firefox.FirefoxDriver

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point

/*
driver = {
    FirefoxProfile profile = new FirefoxProfile()
    profile.setPreference("browser.download.folderList", 2)
    profile.setPreference("browser.download.dir", "/tmp")
    profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv")

    def driverInstance = new FirefoxDriver(profile)
    driverInstance.manage().window().maximize()
    driverInstance
}
*/

def chromeDriver = new File('build/drivers/chrome/chromedriver')
downloadDriver(chromeDriver, driverLocationDependingOnOperatingSystem())
System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)

driver = {
    def driverInstance = new ChromeDriver()

    def browserWindow = driverInstance.manage().window()

    // width, height
    browserWindow.size = new Dimension(1000, 2500)
    browserWindow.position = new Point(0, 0)

    driverInstance
}

private void downloadDriver(File file, String path) {
    if (!file.exists()) {
        println "Downloading chrome driver: ${path}"
        def ant = new AntBuilder()
        ant.get(src: path, dest: 'driver.zip')
        ant.unzip(src: 'driver.zip', dest: file.parent)
        ant.delete(file: 'driver.zip')
        ant.chmod(file: file, perm: '700')
    }
}

private String driverLocationDependingOnOperatingSystem() {
    String os = System.getProperty("os.name").toLowerCase();
    def loc = "http://chromedriver.storage.googleapis.com/2.15"
    if( os.contains('mac')) {
        return "${loc}/chromedriver_mac32.zip"
    }
    if( os.contains('win')) {
        return "${loc}/chromedriver_win32.zip"
    }
    return "${loc}/chromedriver_linux64.zip"
}

reportsDir = new File("build/geb-reports")
