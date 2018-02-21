package common

import org.openqa.selenium.remote.RemoteWebDriver
import selector.CSSSelector
import selector.XPATHSelector
import starters.Constants
import starters.Constants.Companion.loginButtonFacebookXPATHSelector

class LoginMethods() {

    constructor(driver: RemoteWebDriver, startSelector: XPATHSelector): this(){
        val selector = startSelector
    }

    constructor(driver: RemoteWebDriver, startSelector: CSSSelector): this(){
        val selector = startSelector
    }

    fun logInToFacebook(facebookLoginEmail: String, facebookLoginPassword: String) {
        Constants.facebookLoginEmail = facebookLoginEmail
        Constants.facebookLoginPassword = facebookLoginPassword
        selector.openURL(Constants.facebookURL)
        selector.setText(Constants.emailFacebookXPATHSelector, facebookLoginEmail)
        selector.setText(Constants.passwordXPATHSelector, facebookLoginPassword)
        selector.click(loginButtonFacebookXPATHSelector)
    }





}


