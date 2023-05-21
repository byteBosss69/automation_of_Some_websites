package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class name_links {
    ChromeDriver driver;

    public void googleNameLinks() throws InterruptedException{
        this.driver = TestCases.TestCasesInitializer();
        System.out.println("Start of the test case : automate_google_name_links");
        // Navigate to URL https://google.com
        driver.get("https://google.com");
        // Locate the search bar and send the word "vikash" Using Locator "XPath"
        // //textarea[@type='search']
        driver.findElement(By.xpath("//textarea[@type='search']")).sendKeys("vikash");
        // click on the google search button Using Locator "XPath"
        // (//input[@value='Google Search'])[2]
        WebElement searchTab = driver.findElement(By.xpath("(//input[@value='Google Search'])[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", searchTab);
        Thread.sleep(3000);

        // Print the count of links in the search result with your name in it Using
        // Locator "XPath" //a[contains(text(),'Vikash')]
        List<WebElement> count = driver.findElements(By.xpath("//a[contains(@href,'vikash')]"));
        Thread.sleep(3000);
        System.out.println("Count of link contains word 'vikash' is " + count.size());
    }
}
