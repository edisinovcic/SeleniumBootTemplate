package main

import common.CommonMethods.openURL
import common.CommonMethods.randomSleep
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.RemoteWebDriver
import selector.CSSSelector
import selector.XPATHSelector
import java.util.concurrent.TimeUnit

var driver: RemoteWebDriver? = null
var XPATHSelector: XPATHSelector = selector.XPATHSelector.getInstance()
var CSSSelector: CSSSelector = selector.CSSSelector.getInstance()
var username: String = ""
var password: String = ""

const val startURL: String = "https://www.instagram.com/"
const val logInBtnSelector: String = "/html/body/span/section/main/article/div[2]/div[2]/p/a"
const val usernameXPATHSelector: String = "//input[contains(@name, 'username')]"
const val passwordXPATHSelector: String = "//input[contains(@name, 'password')]"
const val logInToInstagramBtnXPATHSelector: String = "/html/body/span/section/main/article/div[2]/div[1]/div/form/span/button"
const val addNewPeopleURL: String = "https://www.instagram.com/explore/people"
const val followBtnXPATHSelector: String = "(//button)"

fun main(args: Array<String>) {
    val driver = FirefoxDriver()

    username = args?.get(0)
    password = args?.get(1)

    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
    openURL(driver, startURL)

    XPATHSelector.click(driver, logInBtnSelector)
    randomSleep()
    XPATHSelector.click(driver, usernameXPATHSelector)
    XPATHSelector.setText(driver, usernameXPATHSelector, username)
    randomSleep()
    XPATHSelector.click(driver, passwordXPATHSelector)
    XPATHSelector.setText(driver, passwordXPATHSelector, password)
    randomSleep()


    XPATHSelector.click(driver, logInToInstagramBtnXPATHSelector)

    randomSleep()
    openURL(driver, addNewPeopleURL)

    randomSleep()
    for (i in 1..20) {
        XPATHSelector.click(driver, followBtnXPATHSelector + """[${i}]""")
        randomSleep()
    }


}