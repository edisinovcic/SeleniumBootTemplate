package main

import main.Common.openBrowser
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.RemoteWebDriver
import selector.CSSSelector
import selector.XPATHSelector
import java.util.concurrent.TimeUnit

var driver: RemoteWebDriver? = null
var XPATHSelector: XPATHSelector = selector.XPATHSelector.getInstance()
var CSSSelector: CSSSelector = selector.CSSSelector.getInstance()
const val startURL: String = "https://www.instagram.com/"
const val logInBtnSelector: String = "id(\"react-root\")/section[1]/main[1]/article[1]/div[2]/div[2]"

fun main(args: Array<String>) {
    val driver = FirefoxDriver()

    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
    openBrowser(driver, startURL)

    XPATHSelector.click(driver, logInBtnSelector)

}