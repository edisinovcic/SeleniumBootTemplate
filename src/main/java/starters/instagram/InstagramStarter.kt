package starters.instagram

import common.CommonMethods.openURL
import common.CommonMethods.randomSleep
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.RemoteWebDriver
import selector.CSSSelector
import selector.XPATHSelector
import starters.Constants.Companion.addNewPeopleURL
import starters.Constants.Companion.followBtnXPATHSelector
import starters.Constants.Companion.instagramStart
import starters.Constants.Companion.logInBtnSelector
import starters.Constants.Companion.logInToInstagramBtnXPATHSelector
import starters.Constants.Companion.instagramPassword
import starters.Constants.Companion.passwordXPATHSelector
import starters.Constants.Companion.instagramUsername
import starters.Constants.Companion.usernameXPATHSelector
import java.util.concurrent.TimeUnit


var driver: RemoteWebDriver? = null
lateinit var XPATHSelector: XPATHSelector
lateinit var CSSSelector: CSSSelector


fun main(args: Array<String>) {
    val driver = FirefoxDriver()

    instagramUsername = args?.get(0)
    instagramPassword = args?.get(1)

    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
    openURL(driver, instagramStart)

    XPATHSelector.click(logInBtnSelector)
    randomSleep()
    XPATHSelector.click(usernameXPATHSelector)
    XPATHSelector.setText(usernameXPATHSelector, instagramUsername)
    randomSleep()
    XPATHSelector.click(passwordXPATHSelector)
    XPATHSelector.setText(passwordXPATHSelector, instagramPassword)
    randomSleep()


    XPATHSelector.click(logInToInstagramBtnXPATHSelector)

    randomSleep()
    openURL(driver, addNewPeopleURL)

    randomSleep()
    for (i in 1..20) {
        XPATHSelector.click(followBtnXPATHSelector + """[${i}]""")
        randomSleep()
    }


}