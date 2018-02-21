package selectordriver

import org.openqa.selenium.WebElement

interface SelectorInterface {

    fun elementExists(element: WebElement): Boolean
    fun click(element: WebElement): Boolean
    fun setText(element: WebElement, text: String): Boolean
    fun waitForElement(element: WebElement): Boolean
    fun openURL(url: String)
    fun randomSleep()
}