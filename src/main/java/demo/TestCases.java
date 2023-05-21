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

    public static ChromeDriver TestCases() {
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

    public void testCase01() throws InterruptedException {
        System.out.println("start test case: search on amazon");
        search_amazon amazon = new search_amazon();
        amazon.search_amazon_on_google();
        
        // System.out.println("Start test case: count of hyperlinks");
        // count_hyperlink link = new count_hyperlink();
        // link.hyperlink();
    }


    public void testCase03() throws InterruptedException {
        // Navigate to the url https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // Search for all the links present and have them count and print Using Locator
        // "XPath" //a
        List<WebElement> links = driver.findElementsByXPath("//a");
        Thread.sleep(2000);
        int count = links.size();
        System.out.println("Number of links present in the given page is:" + count);
    }

    public void testCase04() {
        System.out.println("Start test case: testCase04(LinkedIn automation)");
        // Navigate to the URL https://www.linkedin.com/
        driver.get("https://www.linkedin.com/");
        // Locate the email text field and send the emailId Using Locator "ID"
        // "session_key"
        driver.findElement(By.id("session_key")).sendKeys("mailtovikashsingh1@gmail.com");
        // Locate the Password text field and send the Password Using Locator "ID"
        // "session_password"
        driver.findElementById("session_password").sendKeys("vikash@78904");
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
            // Click to the post button to post the post Using Locator "ID" ember877
            driver.findElementByXPath("//span[text()='Post']").click();
        }
        // Check the post is been made or not Using Locator "XPath"
        // span[text()='this
        // post is done by automation']
        boolean isPostMade = driver.findElement(By.xpath("//span[text()='this post is done by automation']"))
                .isDisplayed();
        System.out.println("Post is made " + isPostMade);
    }

    public void testCase05() throws InterruptedException {
        System.out.println("Start of the test case : testcase05");
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

    public void testCase06() throws InterruptedException {
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

    public void testCase07() throws InterruptedException, AWTException {
        System.out.println("start testcase07: Linkedin photo and video post");
        // navigate to the LInkedIN url https://www.linkedin.com/home
        driver.get("https://www.linkedin.com/");
        // Enter the email address Using Locator "XPath" //input[@id='session_key']
        driver.findElement(By.xpath("//input[@id='session_key']")).sendKeys("mailtovikashsingh1@gmail.com");
        // Enter the password Using Locator "XPath" //input[@id='session_password']
        driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys("vikash@78904");
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

    public void testCase08() {

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

    public void testCase09() {
        // navigate to url "https://www.imdb.com/chart/top"
        driver.get("https://www.imdb.com/chart/top");
        // print the highest rated movies of the list
        List<WebElement> highestRated = driver
                .findElements(By.xpath("//strong[text()='9.2']//parent::td//preceding-sibling::td[1]/a"));
        System.out.println("Highest rated movies are as follows :-");
        for (WebElement movie : highestRated) {
            System.out.println(movie.getText());
        }
        // print how many movies are included in the list
        List<WebElement> movies = driver.findElements(By.xpath("//tbody[@class='lister-list']/tr"));
        System.out.println("Number of movies included in the list is : " + movies.size());
        // print the oldest movie of the list
        WebElement oldest = driver.findElement(By.xpath("//span[text()='(1921)']/preceding-sibling::a"));
        System.out.println("Oldest movie of the list is : " + oldest.getText());
        // print the most recent movies of the list
        List<WebElement> recentMovies = driver.findElements(By.xpath("//span[text()='(2023)']/preceding-sibling::a"));
        System.out.println("Most recent movies are as follows :-");
        for (WebElement film : recentMovies) {
            System.out.println(film.getText());
        }
        // print the highest user rating in figure
        WebElement rating = driver
                .findElement(By.xpath("(//tbody[@class='lister-list']/tr//td[3]/strong[text()='9.2'])[1]"));
        System.out.println("Highest user ratings are : " + rating.getAttribute("title"));
        // Print the movie with most user rating
        WebElement mostRated = driver.findElement(By.xpath(
                "(//tbody[@class='lister-list']/tr//td[3]/strong[text()='9.2'])[1]/parent::td/preceding-sibling::td[1]/a"));
        System.out.println("Most user rated movie name is : " + mostRated.getText());
    }

    public void testCase10() throws InterruptedException {
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

    public void testCase11() throws InterruptedException {
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
