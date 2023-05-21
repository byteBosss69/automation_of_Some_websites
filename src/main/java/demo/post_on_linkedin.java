package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class post_on_linkedin {
    ChromeDriver driver;

    public void postOnLinkedIn(){
        this.driver = TestCases.TestCasesInitializer();
        System.out.println("Start test case: testCase04(LinkedIn automation)");
        // Navigate to the URL https://www.linkedin.com/
        driver.get("https://www.linkedin.com/");
        // Locate the email text field and send the emailId Using Locator "ID"
        // "session_key"
        driver.findElement(By.id("session_key")).sendKeys("mailtovikashsingh1@gmail.com");
        // Locate the Password text field and send the Password Using Locator "ID"
        // "session_password"
        driver.findElementById("session_password").sendKeys("*********");//here put your password
        // click on the sign in button Using Locator "XPath"
        // //button[contains(text(),'Sign in')]
        driver.findElementByXPath("//button[contains(text(),'Sign in')]").click();
        // Click on the analytics and tools tab Using Locator "xpath"
        // //a[@href='/dashboard/']
        driver.findElementByXPath("//a[@href='/dashboard/']").click();
        // Locate the numeric figure of "who viewed your profile" and print the value of
        // it Using Locator "XPath" (//p[text()='75'])[2]
        WebElement profileViews = driver.findElementByXPath("(//p[@class='text-body-large-bold t-black'])[3]");
        System.out.println("Number of views on the profile is " +
                profileViews.getText());
        // Locate the Impression on post and print it Using Locator "XPath"
        // //p[text()='72']
        WebElement impression = driver.findElementByXPath("(//p[@class='text-body-large-bold t-black'])[1]");
        System.out.println("Number of impression given on profile " +
                impression.getText());
        // Go back driver.back()
        driver.navigate().back();
        // Click on the share post field and then send the Thoughts you want to share
        // Using Locator "XPath" //span[text()='Start a post']
        WebElement textField = driver.findElementByXPath("//span[text()='Start a post']");
        textField.click();
        if (driver.findElement(By.xpath("//div[@class='share-box']")).isDisplayed()) {
            // click on the link to select the connection only option Using Locator "XPath"
            // (//span[contains(@class,'share-state')])[1]
            WebElement linkToClick = driver.findElementByXPath("(//span[contains(@class,'share-state')])[1]");
            if (!linkToClick.getText().equalsIgnoreCase("Connections only")) {
                linkToClick.click();

                // Iterate over the options and Click to select the option "connection only"
                // Using Locator "XPath"
                // //div[@class='share-generic-list__description-single-line']
                List<WebElement> options = driver
                        .findElementsByXPath("//div[@class='share-generic-list__description-single-line']");
                for (WebElement option : options) {
                    if (option.getText().equalsIgnoreCase("Connections only")) {
                        // driver.findElement(By.xpath("//span[text()='Back']")).click();
                        option.click();
                    }
                }
                // Click to save button to save the setting which is being made Using Locator
                // "ID" ember739
                driver.findElementByXPath("//span[text()='Save']").click();
            }
            WebElement field = driver.findElementByXPath("(//div[contains(@class,'editor-content')])[1]");
            Actions action = new Actions(driver);
            action.moveToElement(field).click(field).sendKeys("this post is done by automation").build().perform();
            // Click to the post button to post the post Using Locator "xpath" //span[text()='Post']
            driver.findElementByXPath("//span[text()='Post']").click();
        }
        // Check the post is been made or not Using Locator "XPath"
        // span[text()='this
        // post is done by automation']
        boolean isPostMade = driver.findElement(By.xpath("//span[text()='this post is done by automation']"))
                .isDisplayed();
        System.out.println("Post is made " + isPostMade);
    }
}
