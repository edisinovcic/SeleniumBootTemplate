package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static main.Starter.driver;

abstract public class IFrame {

    private static List<WebElement> iframes = new ArrayList<>();

    public static String getCurrentFrame() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String currentFrame = (String) jsExecutor.executeScript("return self.name");
        return currentFrame;
    }


    public static WebElement returnFacebookFrame() {
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

    public static void updateFrameList() {
        iframes = driver.findElements(By.tagName("iframe"));
    }


    public static void printFrameListByClassName() {
        System.out.println("Iframes id list:");
        for (WebElement iframe : iframes) {
            System.out.println(iframe.getAttribute("class"));
        }
    }


}
