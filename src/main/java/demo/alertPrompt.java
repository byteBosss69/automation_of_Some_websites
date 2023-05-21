package demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alertPrompt {
    ChromeDriver driver;

    public void automateAlertPrompt() throws InterruptedException{
        this.driver = TestCases.TestCasesInitializer();
              // navigate to the url
        // https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
        // Go to the iframe where "try it" button is present
        WebElement framess = driver.findElement(By.xpath("//iframe[@name='iframeResult']"));
        driver.switchTo().frame(framess);
        // click on the "try it" button
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        // switch to the javascript alert
        Alert alert = driver.switchTo().alert();
        // print the text on the alert
        String text = alert.getText();
        System.out.println("The text message written in the alert is : " + text);
        // send your name to alert text field and accept it
        alert.sendKeys("Vikash kumar");
        Thread.sleep(2000);
        alert.accept();
        // check if your name is get printed or not
        WebElement validation = driver.findElement(By.xpath("//p[@id='demo']"));
        if (validation.getText().equals("Hello Vikash Kumar! How are you today?")) {
            System.out.println("Yes the name is getting printed");
        } else {
            System.out.println("Name is not getting printed");
        }
    }
}
