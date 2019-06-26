import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class Assignment
{
    public static void main(String[] args)

    {
        System.setProperty("webdriver.chrome.driver", "C:/Java/Selenium/exeFile/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/raghavs/Downloads/webpage.html");
        driver.manage().window().maximize();
        Select listbox = new Select(driver.findElement(By.xpath("//select[@name='girls']")));
        listbox.selectByIndex(0);

     //   Select listbox = new Select(driver.findElement(By.xpath("//select[@name='FromLB']")));
        listbox.selectByValue("Italy");
    }
}