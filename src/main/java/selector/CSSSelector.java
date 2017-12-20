package selector;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static main.Starter.driver;
import static org.openqa.selenium.By.cssSelector;

public class CSSSelector extends Selector {

    private static final CSSSelector instance = new CSSSelector();

    private CSSSelector() {
    }

    public boolean elementExists(String selector) {
        WebElement element = driver.findElement(cssSelector(selector));
        return super.elementExists(element);
    }

    public boolean click(String selector) {
        WebElement element = driver.findElement(cssSelector(selector));
        return super.click(element);
    }

    public boolean setText(String selector, String text) {
        WebElement element = driver.findElement(cssSelector(selector));
        return super.setText(element, text);
    }


    public WebElement findElement(String selector) {
        WebElement element = driver.findElement(cssSelector(selector));
        return super.findElement(element);
    }

    public static CSSSelector getInstance() {
        return instance;
    }

    //---------------------------------------------------------------------------------------------------------------------------------

    public RemoteWebDriver setFirefoxDriver(FirefoxDriver driver) {
        return super.setFirefoxDriver(driver);
    }

    public RemoteWebDriver setChromeDriver(ChromeDriver driver) {
        return super.setChromeDriver(driver);
    }

}
