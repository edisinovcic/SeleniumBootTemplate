package starters.facebookcomment

import common.FacebookCommentConstants
import common.FacebookConstants
import common.Helpers
import driver.DriverType
import org.openqa.selenium.WebElement
import selector.SelectorType

fun main(args: Array<String>) {

    FacebookConstants.facebookLoginEmail = args[0]
    FacebookConstants.facebookLoginPassword = args[1]
    print("Facebook login data:\n")
    print("Email: ${FacebookConstants.facebookLoginEmail}\n")
    print("Password: ${FacebookConstants.facebookLoginPassword}\n")

    val helper = Helpers(SelectorType.XPATH, DriverType.FIREFOX)
    helper.logInToFacebook(FacebookConstants.facebookLoginEmail, FacebookConstants.facebookLoginPassword)

    //Now do what you want :)

    //start spamming index

    helper.selector.openURL(FacebookCommentConstants.startURL)


    val clanci :List<WebElement> = helper.selector.findAll(FacebookCommentConstants.selectAllClanakXPATH)
    val urls = mutableListOf<String>()
    clanci.forEach {
        urls.add(it.getAttribute("href"))
    }

    print(urls)

    urls.forEach { helper.selector.openURL(it) }




}