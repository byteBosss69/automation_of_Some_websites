package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frames {
    ChromeDriver driver;

    public void automateNestedFrames(){
        this.driver = TestCases.TestCasesInitializer();
            // Launch Chrome browser
        // Go to the URL https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // Go to the upper frame by using driver.switchTo() method Using Locator "XPath"
        // //frame[@name='frame-top']
        WebElement topframe = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(topframe);
        // Go to the 1st frame of top frame Using Locator "XPath"
        // //frame[@name='frame-left'] or using index
        driver.switchTo().frame(0);
        // Locate and print the word written in 1st frame of upper frame Using Locator
        // "XPath" //body[contains(text(),'LEFT')]
        WebElement textUpper1 = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println("Text written in the 1st frame of the top frame is : " + textUpper1.getText());
        // go to the parent frame which is upper frame
        driver.switchTo().parentFrame();
        // go to the second frame of upper frame Using Locator "XPath"
        // //frame[@name='frame-middle'] or using index
        driver.switchTo().frame(1);
        // Locate and print the word written in 2nd frame of upper frame Using Locator
        // "XPath" //div[contains(text(),'MIDDLE')]
        WebElement textUpper2 = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        System.out.println("Text Written in the 2nd frame of the top frame is : " + textUpper2.getText());
        // go to the parent frame which is upper frame
        driver.switchTo().parentFrame();
        // go to the 3rd frame of upper frame Using Locator "XPath"
        // //frame[@name='frame-right'] or indexing
        driver.switchTo().frame(2);
        // Locate then print the word written in 3rd frame of upper frame Using Locator
        // "XPath" //body[contains(text(),'RIGHT')]
        WebElement textUpper3 = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println("Text written in the 3rd frame of top frame is : " + textUpper3.getText());
        // go to the extreme parent frame
        driver.switchTo().defaultContent();
        // Go to the Bottom frame using xpath //frame[@name='frame-bottom'] and print
        // the text embedded in it
        WebElement bottomFrame = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
        driver.switchTo().frame(bottomFrame);
        // and print the text embedded in it using xpath //body[contains(text(),'B')]
        System.out.println("Text Written in the Bottom frame is : "
                + driver.findElement(By.xpath("//body[contains(text(),'B')]")).getText());
    }
}
