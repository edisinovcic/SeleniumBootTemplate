package selector

import common.Constants.Companion.randomSleepMaxTime
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver
import selectordriver.SelectorInterface
import java.util.*

abstract class Selector(var driver: RemoteWebDriver) : SelectorInterface {

    override fun elementExists(element: WebElement): Boolean {
        if (element.isDisplayed && element.isEnabled) {
            return true
        }
        return false
    }

    override fun clickLastInList(selectorList: List<WebElement>) {
        click(selectorList[selectorList.size - 1])
    }

    override fun waitForElement(element: WebElement): Boolean {
        while (!element.isDisplayed || !element.isEnabled) {
        }
        return true
    }

    override fun click(element: WebElement): Boolean {
        waitForElement(element)
        element.click()
        return true
    }

    override fun setText(element: WebElement, text: String): Boolean {
        waitForElement(element)
        element.sendKeys(text)
        return true
    }

    override fun openURL(url: String) {
        driver.get(url)
    }

    override fun randomSleep() {
        Thread.sleep(Random().nextInt(randomSleepMaxTime).toLong())
    }

    override fun randomSleep(sleep: Long) {
        Thread.sleep(sleep)
    }


}
