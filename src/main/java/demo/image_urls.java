package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class image_urls {
    ChromeDriver driver;

    public void automateImageUrls() throws InterruptedException{
        this.driver = TestCases.TestCasesInitializer();
        System.out.println("Start testCase: testCase06");
        // Navigate to URL https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // Locate the recommended movies list Using Locator "XPath"
        // //div[@class='sc-lnhrs7-2 eQezya']/div//img
        List<WebElement> moviesList = driver.findElements(By.xpath("//div[@class='sc-lnhrs7-2 eQezya']/div//img"));
        System.out.println("Number of movie images " + moviesList.size());
        // use for loop to iterate over each img and print the src attribute value
        for (WebElement movieUrl : moviesList) {
            String attribute = movieUrl.getAttribute("src");
            System.out.println("image urls of recommended movie lists " + attribute);
            Thread.sleep(2000);
        }
        // Scroll down into the viewport where "PREMIERE" heading is been seen
        // WebElement heading = driver.findElement(By.xpath("//img[@alt='Tvod
        // Offer']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "null");
        // Print the name of the 2nd item of premiere list Using Locator "XPath"
        // (//div[@class='sc-7o7nez-0 fyTNyu'])[2]
        WebElement name = driver.findElement(By.xpath("(//div[@class='sc-7o7nez-0 fyTNyu'])[2]"));
        System.out.println("Name of movie which come 2nd in the premiere list is " + name.getText());
        // Print the language of the 2nd item of premiere list Using Locator "XPath"
        // (//div[@class='sc-7o7nez-0 eeVqLW'])[2]
        WebElement lang = driver.findElement(By.xpath("(//div[@class='sc-7o7nez-0 eeVqLW'])[2]"));
        System.out.println("Language of the movie which comes 2nd in the premiere list " + lang.getText());
    }
}
