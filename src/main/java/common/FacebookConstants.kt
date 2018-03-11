package common

abstract class FacebookConstants {
    companion object {
        const val facebookURL = "https://www.facebook.com/"
        lateinit var facebookLoginEmail: String
        lateinit var facebookLoginPassword: String
        const val emailFacebookXPATHSelector = "//*[contains(@id, 'email')]"
        const val passswordFacebookXPATHSelector = "//*[contains(@id, 'pass')]"
        const val loginButtonFacebookXPATHSelector = "//*[contains(@id, 'loginbutton')]"

        val startURL = "https://www.packtpub.com/packt/offers/free-learning?from=block"
        val loginURL = "https://www.packtpub.com/packt/offers/free-learning?from=block"
        val openLoginScreenXPATHSelector = "id(\"account-bar-login-register\")/a[1]/div[1]"
        val emailFieldXPATHSelector = "id(\"email\")"
        val passwordFieldXPATHSelector = "id(\"instagramPassword\")"
        val submitButtonXPATHSelector = "id(\"edit-submit-1\")"
        val claimBookButtonXPATHSelector = "id(\"free-learning-claim\")"

        val expandBookButton = "id(\"product-account-list\")/div[1]/div[1]/div[3]"
        val afterClaimBookButtonURL = "https://www.packtpub.com/account/my-ebooks"
        val PDFBookButton = "id(\"product-account-list\")/div[1]/div[2]/div[2]/a[1]/div[1]"
        val codeFilesBookButton = "id(\"product-account-list\")/div[1]/div[2]/div[2]/a[4]/div[1]/div[3]"

        var XPATHSelector: selector.XPATHSelector? = null
        var CSSSelector: selector.CSSSelector? = null
    }
}