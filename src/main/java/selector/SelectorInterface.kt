package selectordriver

import org.openqa.selenium.WebElement

interface SelectorInterface {

    fun elementExists(element: WebElement): Boolean
    fun elementExists(element: String): Boolean
    fun click(element: WebElement): Boolean
    fun click(element: String): Boolean
    fun setText(element: WebElement, text: String): Boolean
    fun setText(element: String, text: String): Boolean
    fun waitForElement(element: WebElement): Boolean
    fun waitForElement(element: String): Boolean
    fun openURL(url: String)
    fun randomSleep()
    fun randomSleep(sleep: Long)
    fun clickLastInList(selectorList: List<WebElement>)
    fun findAll(selector: String): List<WebElement>
    fun findElement(selector: String): WebElement
}