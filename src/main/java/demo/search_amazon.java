package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class search_amazon {
    ChromeDriver driver;

    public void search_amazon_on_google() {
        System.out.println("Start test case: search amazon on google test");
        this.driver = TestCases.TestCases();
        // Navigate to the URL https://google.com
        driver.get("https://google.com");
        // Locate the search bar and click Using Locator "XPath" //*[@name='q']
        WebElement searchBar = driver.findElement(By.xpath("//*[@name='q']"));
        searchBar.click();
        // send "amazon" word to search in the seaarch bar Using Locator "XPath"
        // *[@name='q']
        searchBar.sendKeys("amazon");
        // click on the google search button using locator "xpath"
        // (//input[@value='Google Search'])[2]
        WebElement button = driver.findElement(By.xpath("(//input[@value='Google Search'])[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", button);
        // button.click();
        // check if "amazon.in" is displayed or not Using Locator "XPath"
        // (//span[text()='Amazon.in'])[1]
        boolean itsVisible = driver.findElement(By.xpath("(//span[text()='Amazon.in'])[1]")).isDisplayed();
        System.out.println(itsVisible);
    }
}
