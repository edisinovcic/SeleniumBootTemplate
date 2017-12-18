package selector;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.openqa.selenium.By.cssSelector;

public class CSSSelector extends Selector {

    private RemoteWebDriver driver;

    public CSSSelector(RemoteWebDriver driver) {
        this.driver = driver;
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
}
