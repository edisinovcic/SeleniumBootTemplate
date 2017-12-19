package main;

import selector.XPATHSelector;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static main.Starter.*;

abstract public class Common {

    private static final String facebookURL = "https://www.facebook.com/";
    private static String emailFacebookXPATHSelector = "//*[contains(@id, 'email')]";
    private static String passswordFacebookXPATHSelector = "//*[contains(@id, 'pass')]";
    private static String loginButtonFacebookXPATHSelector = "//*[contains(@id, 'loginbutton')]";

    private static String facebookLoginEmail = "mayanna.apt@gmail.com";
    private static String facebookLoginPassword = "mandrilo";

    //-----------------------------------------------------------------------------------

    /**
     * Selenium common methods
     */

    public static void openBrowser(String URL) {
        driver.get(URL);
    }



    //------------------------------------------------------------------------------------

    /**
     * Login to facebook with email and password or with default ones
     */

    public static void logInToFacebook() {
        logInToFacebook(facebookLoginEmail, facebookLoginPassword);
    }

    public static void logInToFacebook(String facebookLoginEmail, String facebookLoginPassword) {
        XPATHSelector selector = new XPATHSelector();
        openBrowser(facebookURL);
        selector.setText(emailFacebookXPATHSelector, facebookLoginEmail);
        selector.setText(passswordFacebookXPATHSelector, facebookLoginPassword);
        selector.click(loginButtonFacebookXPATHSelector);
    }


    //-------------------------------------------------------------------------------------

    /**
     * File manipulation methods
     */


    public static void createFileIfFileDoesNotExists(String url) throws IOException {
        File file = new File(url);
        if (!file.exists()) {
            file.createNewFile();
        }
    }


    public static List<String> readFromFile(String file) throws IOException {
        createFileIfFileDoesNotExists(file);
        List<String> URLSFromFile = new ArrayList<String>();
        while (true) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                URLSFromFile.add(line);
            }
            return URLSFromFile;
        }
    }


    public static void writeURLSToFile(String urlsFile, List<String> pageURLS)
            throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(urlsFile));
        StringBuilder output = new StringBuilder();
        for (String element : pageURLS) {
            output.append(element).append("\n");
        }
        System.out.println(output);
        pw.write(output.toString());
        pw.close();
    }

    //--------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------


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

    */

    //-----------------------------------------------------------------------------------------------------------------------------------------

    /*

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
}
