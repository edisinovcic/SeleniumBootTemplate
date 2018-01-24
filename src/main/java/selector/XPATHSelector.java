package selector;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static main.Starter.driver;
import static org.openqa.selenium.By.xpath;

public class XPATHSelector extends Selector {

    private static final XPATHSelector instance = new XPATHSelector();

    private XPATHSelector() {
    }

    public static XPATHSelector getInstance() {
        return instance;
    }

    public boolean elementExists(String selector) {
        return elementExists(driver, selector);
    }

    public boolean elementExists(RemoteWebDriver driver, String selector) {
        WebElement element = driver.findElement(xpath(selector));
        return super.elementExists(element);
    }

    public boolean click(String selector) {
        return click(driver, selector);
    }

    public boolean click(RemoteWebDriver driver, String selector) {
        WebElement element = driver.findElement(xpath(selector));
        return super.click(element);
    }


    public boolean setText(RemoteWebDriver driver, String selector, String text) {
        WebElement element = driver.findElement(xpath(selector));
        return super.setText(element, text);
    }

    public boolean setText(String selector, String text) {
        return setText(driver, selector, text);
    }

    public WebElement findElement(String selector) {
        return findElement(driver, selector);
    }

    public WebElement findElement(RemoteWebDriver driver, String selector) {
        WebElement element = driver.findElement(xpath(selector));
        return super.findElement(element);
    }

    //---------------------------------------------------------

    public RemoteWebDriver setFirefoxDriver(FirefoxDriver driver) {
        return super.setFirefoxDriver(driver);
    }

    public RemoteWebDriver setChromeDriver(ChromeDriver driver) {
        return super.setChromeDriver(driver);
    }

}
