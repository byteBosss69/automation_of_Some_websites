package demo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class count_hyperlink {
    ChromeDriver driver;

    public void hyperlink() throws InterruptedException{
            this.driver = TestCases.TestCasesInitializer();
            // Navigate to the url https://in.bookmyshow.com/explore/home/chennai
            driver.get("https://in.bookmyshow.com/explore/home/chennai");
            // Search for all the links present and have them count and print Using Locator
            // "XPath" //a
            List<WebElement> links = driver.findElementsByXPath("//a");
            Thread.sleep(2000);
            int count = links.size();
            System.out.println("Number of links present in the given page is:" + count);
    }    
}
