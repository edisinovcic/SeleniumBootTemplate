package starters.facebook

import common.FacebookConstants.Companion.facebookLoginEmail
import common.FacebookConstants.Companion.facebookLoginPassword
import common.Helpers
import driver.DriverType.FIREFOX
import selector.SelectorType.XPATH

fun main(args: Array<String>) {
    facebookLoginEmail = args[0]
    facebookLoginPassword = args[1]
    print("Facebook login data:\n")
    print("Email: $facebookLoginEmail\n")
    print("Password: $facebookLoginPassword\n")

    val helper = Helpers(XPATH, FIREFOX)
    helper.logInToFacebook(facebookLoginEmail, facebookLoginPassword)

}