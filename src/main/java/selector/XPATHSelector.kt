package selector

import org.openqa.selenium.By.xpath
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver

class XPATHSelector(driver: RemoteWebDriver) : Selector(driver) {
    override fun findElement(selector: String): WebElement {
        return driver.findElement(xpath(selector))
    }

    override fun findAll(selector: String): List<WebElement> {
        val webElements = arrayListOf<WebElement>()
        var i = 1
        try {
            while (elementExists("""$selector[${i}]""")) {
                webElements.add(findElement("""$selector[${i}]"""))
                i++
                print("""Number of elements:""" + webElements.size + "\n")
            }
        } catch (e: Exception) {
            return webElements
        }
        return webElements
    }


    override fun elementExists(selector: String): Boolean {
        val element: WebElement = driver.findElement(xpath(selector))
        return super.elementExists(element)
    }

    override fun click(selector: String): Boolean {
        val element: WebElement = driver.findElement(xpath(selector))
        return super.click(element)
    }

    override fun setText(selector: String, text: String): Boolean {
        val element: WebElement = driver.findElement(xpath(selector))
        return super.setText(element, text)
    }

    override fun waitForElement(selector: String): Boolean {
        val element: WebElement = driver.findElement(xpath(selector))
        return super.waitForElement(element)
    }

}