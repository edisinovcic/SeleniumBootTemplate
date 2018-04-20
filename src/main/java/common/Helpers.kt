package common

import common.InstagramConstants.Companion.instagramPasswordXPATHSelector
import common.InstagramConstants.Companion.instagramURL
import common.InstagramConstants.Companion.instagramlogInBtnSelector
import driver.DriverType
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import selector.CSSSelector
import selector.SelectorType
import selector.XPATHSelector
import java.io.*
import java.util.*
import java.util.concurrent.TimeUnit


class Helpers(selectorType: SelectorType, driverType: DriverType) : HelpersInterface {


    inline fun <reified T> cast(from: Any): T? = from as? T

    override var driver = if (driverType == DriverType.FIREFOX) FirefoxDriver()
    else ChromeDriver()

    override var selector = if (selectorType == SelectorType.XPATH) {
        XPATHSelector(driver)
    } else {
        CSSSelector(driver)
    }

    init {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
    }

    fun setExplicitTimetout(seconds: Long) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS)
    }

    fun logInToFacebook(facebookLoginEmail: String, facebookLoginPassword: String) {

        //Optional
        FacebookConstants.facebookLoginEmail = facebookLoginEmail
        FacebookConstants.facebookLoginPassword = facebookLoginPassword

        selector.openURL(FacebookConstants.facebookURL)
        selector.setText(FacebookConstants.emailFacebookXPATHSelector, facebookLoginEmail)
        selector.setText(FacebookConstants.passswordFacebookXPATHSelector, facebookLoginPassword)
        selector.click(FacebookConstants.loginButtonFacebookXPATHSelector)
    }

    fun logInToInstagram(instagramUsername: String, instagramPassword: String) {
        InstagramConstants.instagramUsername = instagramUsername
        InstagramConstants.instagramPassword = instagramPassword
        selector.openURL(instagramURL)
        selector.randomSleep()
        selector.click(instagramlogInBtnSelector)
        selector.randomSleep()
        selector.setText(instagramlogInBtnSelector, instagramUsername)
        selector.randomSleep()
        selector.click(instagramPasswordXPATHSelector)
        selector.randomSleep()
        selector.setText(instagramPasswordXPATHSelector, instagramPassword)
        selector.randomSleep()
        selector.click(instagramlogInBtnSelector)
    }


    fun logInToLinkedIn(email: String, password: String) {
        LinkedInConstants.linkedInUsername = email
        LinkedInConstants.linkedInPassword = password
        selector.openURL(LinkedInConstants.startURL)
        selector.randomSleep()
        selector.click(LinkedInConstants.emailXPATHSelector)
        selector.randomSleep()
        selector.setText(LinkedInConstants.emailXPATHSelector, email)
        selector.randomSleep()
        selector.click(LinkedInConstants.passwordXPATHSelector)
        selector.randomSleep()
        selector.setText(LinkedInConstants.passwordXPATHSelector, password)
        selector.randomSleep()
        selector.click(LinkedInConstants.signInBtnXPATH)
        print("Success! You are logged in!")

    }

    fun clickAllLinksInTheList(stringSelectors: List<String>) {
        stringSelectors.forEach {
            selector.click(it)
            selector.randomSleep()
        }
    }

    fun clickAllLinksInTheList(selectors: List<WebElement>): Boolean {
        selectors.forEach {
            selector.click(it)
            selector.randomSleep()
        }
        return true
    }


//----------------------------------------------------------------------------------------------------------------

    fun createFileIfFileDoesNotExist(path: String) {
        val file = File(path)
        if (!file.exists()) {
            file.createNewFile()
        }
    }

    fun readFromFile(file: String): List<String> {
        createFileIfFileDoesNotExist(file)
        val fileContent = ArrayList<String>()
        while (true) {
            var line: String
            val br = BufferedReader(FileReader(file))
            //TODO: check if this will work when EOF is received
            br.readLine().let {
                fileContent.add(it)
            }
            return fileContent
        }
    }

    fun writeToFile(file: String, content: List<String>) {
        val pw = PrintWriter(FileOutputStream(file))
        val output = StringBuilder()
        content.forEach {
            output.append(it).append("\n")
        }
        pw.write(output.toString())
        pw.close()
    }

}


/*

    public static void addOnlyNewURLSToFile(String urlsFile, List<String> oldList,
                                            List<String> newList)
            throws FileNotFoundException {
        for (String newURL : newList) {
            int elementExists = 0;
            for (String oldURL : oldList) {
                if (newURL.compareTo(oldURL) == 0) {
                    elementExists = 1;
                }
            }
            if (elementExists == 0) {
                oldList.add(newURL);
            }
        }
        writeURLSToFile(urlsFile, oldList);
    }


    public static void iterateLinks(List<String> urlLinks) throws InterruptedException {
        for (int i = 0; i < 1; i++) {
            openBrowser(urlLinks.get(i));
            //click("//*[contains(text(),'Komentiraj')]/../../..");
            WebElement facebookFrame = returnFacebookFrame();
            //updateFrameList();
            //printFrameListByClassName();
            System.out.println(facebookFrame.getAttribute("class"));
            main.Starter.driver.switchTo().frame(facebookFrame);
            click("//div[contains(@class, '_1mf _1mj')]");
            click("//*[contains(@class, '_1cb _5yk1')]");
            setText("//*[contains(@class, '_1cb _5yk1')]",
                    "Zelite jeftino i udobno ljetovati u Splitu? \n Mayanna Apartment: https://hr.airbnb.com/rooms/19257413");

            click("//button[contains(@type, 'submit')]");
            main.Starter.driver.switchTo().frame(0);

        }
    }




    public static void writeToCSV() throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter("results.csv"), ';');
        List<String[]> data = new ArrayList<String[]>();
        for (String element : companyURLS) {
            data.add(element.split("žnjo"));
        }

        writer.writeAll(data);
        writer.close();
    }



    //-----------------------------------------------------------------------------------------------------------------------------------------



    public static int getNumberOfLinksOnPageCSSSelector(String CSSSelector) {
        List<WebElement> elements = main.Starter.driver.findElementsByCssSelector(CSSSelector);
        return elements.size();
    }




    public static void crawlAllCompanyDetails() throws IOException {
        for (String companyURL : companyURLS) {
            driver.get(companyURL);
            WebElement about = driver.findElementByCssSelector(companyDetails);
            System.out.println(about.getText());
        }
        writeToCSV();
    }


    public static List<String> getAllURLsFromPageWithCSSSelector(String elementSelector) {
        List<WebElement> elements = main.Starter.driver.findElementsByCssSelector(elementSelector);
        List<String> links = new ArrayList<String>();
        for (WebElement element : elements) {
            links.add(element.getAttribute("href"));
        }
        return links;
    }


    @Deprecated
    public static void crawlCurrentPage(String CSSSelector) throws InterruptedException {
        List<WebElement> elements = main.Starter.driver.findElementsByCssSelector(CSSSelector);
        for (WebElement element : elements) {
            companyURLS.add(element.getAttribute("href"));
        }
        Thread.sleep(1000);
    }

    @Deprecated
    public static List<String> getAllURLsFromPageWithXPATHSelector(String elementSelector) {
        List<WebElement> elements = main.Starter.driver.findElementsByXPath(elementSelector);
        List<String> links = new ArrayList<String>();
        for (WebElement element : elements) {
            links.add(element.getAttribute("href"));
        }
        return links;
    }


*/