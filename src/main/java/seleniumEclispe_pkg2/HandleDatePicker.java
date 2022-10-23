package seleniumEclispe_pkg3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.List;

public class HandleDatePicker {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        String browser = "chrome";

        if (browser.toUpperCase().equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\morgan.nwaiku\\Downloads\\app\\web Drivers\\chrome driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.toUpperCase().equals("EDGE")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\morgan.nwaiku\\Downloads\\app\\web Drivers\\Edge driver\\msedgedriver.exe");
            driver = new EdgeDriver();
        }

                 //This url is used for a prompt
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();

        String browsertitle = driver.getTitle();
        System.out.println("Page title: " + browsertitle);

                //click on date element
        driver.findElement(By.xpath("//div[@class='fl search-box date-box gtm-onwardCalendar']")).click();
                //using split and array to click on the Day, Month and the Year
        String departureDate = "23 Dec 2022";
                //Departure month and year
        String departureMonthAndYear = departureDate.split(" ")[1] + " " + departureDate.split(" ")[2];
                //departure day
        String departureDay = departureDate.split(" ")[0];
        System.out.println("Departure month and year: " + departureMonthAndYear);
        System.out.println("Departure Day: " + departureDay);

                //Code to Select departure month and year using a while loop
            while (true){
                String MonthAndYear = driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr[1]/td[@class='monthTitle']")).getText();
                if (MonthAndYear.equals(departureMonthAndYear)){
                    break;
                }else {
                    driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td[@class='next']/button")).click();
                    Thread.sleep(1000);
                }
                //Code to Select departure day
                List<WebElement> days = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td[@class='current day' or @class='wd day']"));
                for (WebElement d1 : days){
                    if(d1.getText().equals(departureDay)){
                        d1.click();
                        break;
                    }
                }
            }

            driver.quit();
    }
}
// I had issues with 'chrome' version on clicking next button for the project
