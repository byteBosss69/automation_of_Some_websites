package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class imdb {
    ChromeDriver driver;

    public void automateImdb(){
        this.driver = TestCases.TestCasesInitializer();
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
}
