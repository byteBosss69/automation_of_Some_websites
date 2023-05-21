package demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedInPost {
    ChromeDriver driver;

    public void postImageAndVideo() throws InterruptedException, AWTException{
        this.driver = TestCases.TestCasesInitializer();
        System.out.println("start testcase07: Linkedin photo and video post");
        // navigate to the LInkedIN url https://www.linkedin.com/home
        driver.get("https://www.linkedin.com/");
        // Enter the email address Using Locator "XPath" //input[@id='session_key']
        driver.findElement(By.xpath("//input[@id='session_key']")).sendKeys("mailtovikashsingh1@gmail.com");
        // Enter the password Using Locator "XPath" //input[@id='session_password']
        driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys("********"); //here put your password
        // click on the sign in button Using Locator "XPath"
        // //button[@data-id='sign-in-form__submit-btn']
        driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();
        // Click on the "start a post" field Using Locator "XPath" //span[text()='Start
        // a post']
        WebElement startPostField = driver.findElement(By.xpath("//span[text()='Start a post']"));
        startPostField.click();
        // Locate "add a photo" button Using Locator "XPath" (//li-icon[@type='image'
        // and @class='artdeco-button__icon'])[1]
        WebElement addPhotoButton = driver
                .findElement(By.xpath("//div[contains(@class,'share-creation-state__d')]/span[1]"));
        // // add a photo using robot class
        addPhotoButton.click();

        // creating object of Robot class
        Robot rb = new Robot();
        // copying File path to Clipboard
        StringSelection str = new StringSelection("C:\\Users\\hp\\Desktop\\picture\\cubs.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(3000);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        Thread.sleep(3000);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        Thread.sleep(3000);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        // Click on the "done" button Using Locator "XPath" //span[text()='Done']
        WebElement doneButton = driver.findElement(By.xpath("//span[text()='Done']"));
        doneButton.click();
        // click on the "What do you want to talk about" field and send text "This image
        // is uploaded through selenium script"
        WebElement field = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
        field.sendKeys("This image is uploaded through selenium script using Robot class");

        // Click on the "post" button Using Locator "XPath" //span[text()='Post']
        WebElement postBttn = driver.findElement(By.xpath("//span[text()='Post']"));
        postBttn.click();
        // click on dismiss the post successfull notification popup using locator xpath
        // //button[contains(@class,'artdeco-toast')]
        WebElement dismiss = driver.findElement(By.xpath("//button[contains(@class,'artdeco-toast')]"));
        dismiss.click();
        // Click on the "start a post" field Using Locator "XPath" //span[text()='Start
        // a post']
        startPostField.click();
        // Click on "add a video" button Using Locator "XPath"
        // //div[contains(@class,'share-creation-state__d')]/span[2]
        WebElement addVideoBttn = driver
                .findElement(By.xpath("//div[contains(@class,'share-creation-state__d')]/span[2]"));
        addVideoBttn.click();
        // Add a video using robot class
        // Robot robo = new Robot();
        // copying File path to Clipboard
        StringSelection video = new StringSelection("C:\\Users\\hp\\Desktop\\video\\video.mp4");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(video, null);
        Thread.sleep(3000);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        Thread.sleep(3000);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        Thread.sleep(3000);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        // Click on the "done" button Using Locator "XPath" //span[text()='Done']
        // done button locator value is different than image share's done button
        driver.findElement(By.xpath("//button[contains(@class,'share-box-fo')]")).click();
        // doneButton.click();

        // click on the "What do you want to talk about" field and send text "This image
        // is uploaded through selenium script"
        driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"))
                .sendKeys("This Video is uploaded through selenium script using robot class");

        // Click on the "post" button Using Locator "XPath" Click on the "post" button
        driver.findElement(By.xpath("//button[contains(@class,'share-actions__p')]")).click();
    }
}
