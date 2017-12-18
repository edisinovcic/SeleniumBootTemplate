import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


public class Starter {

    public static RemoteWebDriver driver;

    public static final String startURL = "https://www.packtpub.com/packt/offers/free-learning?from=block";
    public static final String loginURL = "https://www.packtpub.com/packt/offers/free-learning?from=block";
    public static final String openLoginScreenXPATHSelector = "id(\"account-bar-login-register\")/a[1]/div[1]";
    public static final String emailFieldXPATHSelector = "id(\"email\")";
    public static final String passwordFieldXPATHSelector = "id(\"password\")";
    public static final String submitButtonXPATHSelector = "id(\"edit-submit-1\")";
    public static final String claimBookButtonXPATHSelector = "id(\"free-learning-claim\")";

    public static final String expandBookButton = "id(\"product-account-list\")/div[1]/div[1]/div[3]";
    public static final String afterClaimBookButtonURL = "https://www.packtpub.com/account/my-ebooks";
    public static final String PDFBookButton = "id(\"product-account-list\")/div[1]/div[2]/div[2]/a[1]/div[1]";
    public static final String codeFilesBookButton = "id(\"product-account-list\")/div[1]/div[2]/div[2]/a[4]/div[1]/div[3]";

    public static final String email = "edi.sinovcic@eestec-zg.hr";
    public static final String password = "Mandrilo@7612";

    public static selector.XPATHSelector XPATHSelector;
    public static selector.CSSSelector CSSSelector;

    public static void main(String[] args) {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Common.openBrowser(startURL);

        try {
            logIn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Claim book button
        XPATHSelector.click(claimBookButtonXPATHSelector);
        XPATHSelector.click(expandBookButton);
        if((driver.getCurrentUrl().compareTo(afterClaimBookButtonURL) == 0)){
            System.out.println("We're on a good path!!");
        }
        XPATHSelector.click(PDFBookButton);
        XPATHSelector.click(codeFilesBookButton);

    }

    static void logIn() throws InterruptedException {
        XPATHSelector.click(openLoginScreenXPATHSelector);
        sleep(1000);
        XPATHSelector.setText(emailFieldXPATHSelector, email);
        XPATHSelector.setText(passwordFieldXPATHSelector, password);
        XPATHSelector.click(submitButtonXPATHSelector);

        //TODO: check if successfully logged in

    }


}
