package common

abstract class LinkedInConstants {
    companion object {
        lateinit var linkedInUsername: String
        lateinit var linkedInPassword: String
        var linkedInAddCount: Int = 0
        val startURL = "https://www.linkedin.com/"
        val emailXPATHSelector = "//input[@id='login-email']"
        val passwordXPATHSelector = "//input[@id='login-password']"
        val signInBtnXPATH = "//input[@id='login-submit']"
        val email: String = ""
        val password: String = ""
        val myNetwork = "https://www.linkedin.com/mynetwork/"
        val personTabXPATH = "//li[contains(@class, 'mn-pymk-list')] //div[contains(@class, 'action')]"
        val personInviteBtnXPATH = "//button[contains(@data-control-name, 'invite')]/span[contains(text(), 'Connect')]"
    }
}