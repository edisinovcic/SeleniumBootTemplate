package selector;

import org.openqa.selenium.WebElement;

public interface SelectorInterface {

    public boolean elementExists(WebElement element);
    public boolean click(WebElement element);
    public boolean setText(WebElement element, String text);
    public WebElement findElement(WebElement element);
}
