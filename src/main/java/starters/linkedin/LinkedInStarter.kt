package starters.linkedin

import common.Helpers
import common.LinkedInConstants
import common.LinkedInConstants.Companion.linkedInAddCount
import common.LinkedInConstants.Companion.linkedInPassword
import common.LinkedInConstants.Companion.linkedInUsername
import driver.DriverType
import org.openqa.selenium.WebElement
import selector.SelectorType


fun main(args: Array<String>) {

    linkedInUsername = args[0]
    linkedInPassword = args[1]
    linkedInAddCount = args[2].toInt()

    val helper = Helpers(SelectorType.XPATH, DriverType.FIREFOX)
    helper.logInToLinkedIn(linkedInUsername, linkedInPassword)

    helper.selector.openURL(LinkedInConstants.myNetwork)


    //first find selected number of people to add
    lateinit var personTab: List<WebElement>
    lateinit var addButtons: List<WebElement>
    while (linkedInAddCount > 0) {
        helper.setExplicitTimetout(3)
        //personTab = helper.selector.findAll(LinkedInConstants.personTabXPATH)
        //helper.selector.clickLastInList(personTab) //This should expand list

        //addButtons = helper.selector.findAll(LinkedInConstants.personInviteBtnXPATH)
        try {
            helper.selector.click("(" + LinkedInConstants.personInviteBtnXPATH + ")[1]")
        } catch (e: Exception){
            helper.selector.openURL(LinkedInConstants.myNetwork)
            helper.selector.randomSleep(2000)
        }
        helper.selector.randomSleep(500)
        linkedInAddCount--
    }

    helper.setExplicitTimetout(60)

    helper.driver.close()
}