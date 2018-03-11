package common

abstract class InstagramConstants {

    companion object {

        const val instagramlogInBtnSelector: String = "/html/body/span/section/main/article/div[2]/div[2]/p/a"
        const val instagramFollowBtnXPATHSelector: String = "(//button)"
        const val instagramURL: String = "https://www.instagram.com/"

        lateinit var instagramUsername: String
        lateinit var instagramPassword: String
        const val instagramUsernameXPATHSelector: String = "//input[contains(@name, 'instagramUsername')]"
        const val instagramPasswordXPATHSelector: String = "//input[contains(@name, 'instagramPassword')]"
        const val instagramLogInBtnXPATHSelector: String = "/html/body/span/section/main/article/div[2]/div[1]/div/form/span/button"
        const val addNewPeopleInstagramPage: String = "https://www.instagram.com/explore/people"

    }

}