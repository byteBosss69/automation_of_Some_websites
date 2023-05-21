package demo;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class window_handle {
    ChromeDriver driver;

    public void automateWindowHandle() throws InterruptedException{
        this.driver = TestCases.TestCasesInitializer();
            // navigate to the url
        // "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open"
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        // save the current window handle address
        String currWindow = driver.getWindowHandle();
        // Go to the frame where the "try it" button is present
        WebElement iframe = driver.findElement(By.xpath("//iframe[@name='iframeResult']"));
        driver.switchTo().frame(iframe);
        // click on the "try it" button
        WebElement button = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].click();", button);
        Actions act = new Actions(driver);
        act.moveToElement(button).click().build().perform();
        Thread.sleep(3000);
        // save the address of newly open window and switch to it
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(currWindow)) {
                driver.switchTo().window(window);
            }
        }
        // Get the url, title and take screenshot then close the window
        String currUrl = driver.getCurrentUrl();
        System.out.println("current url is : " + currUrl);
        String title = driver.getTitle();
        System.out.println("title of the page is : " + title);
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

            File DestFile = new File("C:\\Users\\hp\\Desktop\\picture\\W3SchoolImage.png");
            Files.copy(SrcFile, DestFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.close();
        // switch back to the original window
        driver.switchTo().window(currWindow);
    }
}
