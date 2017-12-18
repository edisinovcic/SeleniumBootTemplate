package selector;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

class Selector implements SelectorInterface {

    private FirefoxDriver firefoxDriver = null;
    private ChromeDriver chromeDriver = null;

    public boolean elementExists(WebElement element) {
        while (!element.isDisplayed() || !element.isEnabled());
        return true;
    }

    public boolean click(WebElement element) {
        while (!element.isDisplayed() || !element.isEnabled()) {}
        element.click();
        return true;
    }

    public boolean setText(WebElement element, String text) {
        while (!element.isDisplayed() || !element.isEnabled()) {}
        element.sendKeys(text);
        return true;
    }

    public WebElement findElement(WebElement element) {
        if (!elementExists(element)){
            return null;
        }
        while (!element.isDisplayed() || !element.isEnabled()) {}
        return element;
    }

    //----------------------------------------------------------------

    public RemoteWebDriver setFirefoxDriver(FirefoxDriver driver) {
        return this.firefoxDriver = driver;
    }

    public RemoteWebDriver setChromeDriver(ChromeDriver driver) {
        return this.chromeDriver = driver;
    }

    public RemoteWebDriver getDriver() {
        if (firefoxDriver != null) {
            return firefoxDriver;
        }
        return chromeDriver;
    }

}