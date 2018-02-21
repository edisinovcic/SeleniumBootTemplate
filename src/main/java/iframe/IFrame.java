package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class IFrame {

    RemoteWebDriver driver;
    private List<WebElement> iframes = new ArrayList<>();

    public IFrame(RemoteWebDriver driver) {
        this.driver = driver;
        updateFrameList();
    }


    public String getCurrentFrame() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String currentFrame = (String) jsExecutor.executeScript("return self.name");
        return currentFrame;
    }


    public WebElement returnFacebookFrame() {
        final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

        int i = 0;
        for (WebElement iframe : iframes) {
            System.out.println(iframe.getAttribute("class"));
            if (iframe.getAttribute("class").equals("fb_ltr")) {
                return iframe;
            }
        }
        return null;
    }

    public void updateFrameList() {
        iframes = driver.findElements(By.tagName("iframe"));
    }


    public void printFrameListByClassName() {
        System.out.println("Iframes id list:");
        for (WebElement iframe : iframes) {
            System.out.println(iframe.getAttribute("class"));
        }
    }


}
