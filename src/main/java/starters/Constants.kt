package starters

abstract class Constants {
    companion object {
        const val randomSleepMaxTime = 2000
        lateinit var instagramUsername: String
        lateinit var instagramPassword: String
        lateinit var facebookLoginEmail: String
        lateinit var facebookLoginPassword: String

        const val instagramStart: String = "https://www.instagram.com/"
        const val logInBtnSelector: String = "/html/body/span/section/main/article/div[2]/div[2]/p/a"
        const val usernameXPATHSelector: String = "//input[contains(@name, 'instagramUsername')]"
        const val passwordXPATHSelector: String = "//input[contains(@name, 'instagramPassword')]"
        const val logInToInstagramBtnXPATHSelector: String = "/html/body/span/section/main/article/div[2]/div[1]/div/form/span/button"
        const val addNewPeopleURL: String = "https://www.instagram.com/explore/people"
        const val followBtnXPATHSelector: String = "(//button)"

        const val facebookURL = "https://www.facebook.com/"
        const val emailFacebookXPATHSelector = "//*[contains(@id, 'email')]"
        const val passswordFacebookXPATHSelector = "//*[contains(@id, 'pass')]"
        const val loginButtonFacebookXPATHSelector = "//*[contains(@id, 'loginbutton')]"
    }
}