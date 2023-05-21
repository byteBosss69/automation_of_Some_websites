package demo;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
//Selenium Imports
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.Keys;
// import org.openqa.selenium.remote.BrowserType;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.openqa.selenium.remote.RemoteWebDriver;
// import org.openqa.selenium.support.ui.Select;
///
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class TestCases {
    static ChromeDriver driver;

    public static ChromeDriver TestCasesInitializer() {
        System.out.println("Driver initialization has begun...");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() throws InterruptedException, AWTException {
        // System.out.println("start test case: search on amazon");
        // search_amazon amazon = new search_amazon();
        // amazon.search_amazon_on_google();
        
        // System.out.println("Start test case: count of hyperlinks");
        // count_hyperlink link = new count_hyperlink();
        // link.hyperlink();

        // System.out.println("Start test case: post on linkedin through automation");
        // post_on_linkedin post = new post_on_linkedin();
        // post.postOnLinkedIn();

        // System.out.println("Start test case: Automate_google_name_links");
        // name_links name = new name_links();
        // name.googleNameLinks();

        // System.out.println("start test case: Automate_the Image_urls");
        // image_urls image = new image_urls();
        // image.automateImageUrls();

        // System.out.println("start test case: posting image and video on the LinkedIn");
        // LinkedInPost posting = new LinkedInPost();
        // posting.postImageAndVideo();

        // System.out.println("start test case: automate the frames");
        // frames f = new frames();
        // f.automateNestedFrames();

        System.out.println("start test case: automate the alert prompt");
        alertPrompt p = new alertPrompt();
        p.automateAlertPrompt();
    }


}
