package common

import org.openqa.selenium.remote.RemoteWebDriver
import selector.Selector

interface HelpersInterface {

    var selector: Selector
    var driver: RemoteWebDriver

}