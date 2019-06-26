import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Chrome {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:/Java/Selenium/exeFile/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        driver.navigate().to("http://www.amazon.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        String title=driver.getTitle();
        System.out.println("Title :"+title);
        String CurrentUrl= driver.getCurrentUrl();
        System.out.println("Current URL :"+CurrentUrl);
        String PageSource= driver.getPageSource();
        System.out.println("PageSource"+PageSource);
       // String WindowHandle= driver.getWindowHandle();
       // System.out.println("WindowHandle :"+WindowHandle);
        driver.close();


//for pause of time

        Thread.sleep(01750);

//to minimize
        Dimension dimension = new Dimension(500, 500);
        driver.manage().window().setSize(dimension);
        driver.quit();


    }
}