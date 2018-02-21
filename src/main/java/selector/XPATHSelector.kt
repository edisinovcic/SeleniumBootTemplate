package selector

import org.openqa.selenium.By.xpath
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver

class XPATHSelector(driver: RemoteWebDriver) : Selector(driver) {

    fun elementExists(selector: String): Boolean {
        val element: WebElement = driver.findElement(xpath(selector))
        return super.elementExists(element)
    }

    fun click(selector: String): Boolean {
        val element: WebElement = driver.findElement(xpath(selector))
        return super.click(element)
    }

    fun setText(selector: String, text: String): Boolean {
        val element: WebElement = driver.findElement(xpath(selector))
        return super.setText(element, text)
    }

    fun waitForElement(selector: String): Boolean {
        val element: WebElement = driver.findElement(xpath(selector))
        return super.waitForElement(element)
    }

}