package starters.instagram

import common.Helpers
import common.InstagramConstants.Companion.addNewPeopleInstagramPage
import common.InstagramConstants.Companion.instagramFollowBtnXPATHSelector
import common.InstagramConstants.Companion.instagramPassword
import common.InstagramConstants.Companion.instagramUsername
import driver.DriverType
import selector.SelectorType


fun main(args: Array<String>) {

    instagramUsername = args[0]
    instagramPassword = args[1]

    print("Facebook login data:\n")
    print("Email: $instagramUsername\n")
    print("Password: $instagramPassword\n")

    val helpers: Helpers = Helpers(SelectorType.XPATH, DriverType.FIREFOX)

    helpers.logInToInstagram(instagramUsername, instagramPassword)
    helpers.selector.openURL(addNewPeopleInstagramPage)

    val numberOfPeople = 20 //TODO: should be changed to number of people on page

    helpers.clickAllLinksInTheList((1..numberOfPeople).map { instagramFollowBtnXPATHSelector + """[${it}]""" })
    print("Success!!")

}