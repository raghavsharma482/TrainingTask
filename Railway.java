import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;


public class Railway {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Java/Selenium/exeFile/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.irctc.co.in/");

        String pageTitle = driver.getTitle();
        boolean buttonName = driver.findElement(By.xpath("//button[text()='Find trains']")).isDisplayed();

        Assert.assertEquals("IRCTC Next Generation eTicketing System", pageTitle);
        System.out.println("Assertion will pass");
        // Assert.assertEquals("IRCTC",pageTitle);

        Assert.assertNotEquals("IRCTC", pageTitle);
        Assert.assertTrue(buttonName);
        driver.findElement(By.xpath("//input[@placeholder='From*']")).click();
        driver.findElement(By.xpath("//input[@placeholder='From*']")).sendKeys("Delhi");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[text()='DELHI - DLI']")).click();
        driver.findElement(By.xpath("//input[@placeholder='To*']")).click();
        driver.findElement(By.xpath("//input[@placeholder='To*']")).sendKeys("Chandigarh");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[text()='CHANDIGARH - CDG']")).click();

        driver.findElement(By.xpath("//input[@placeholder='Journey Date(dd-mm-yyyy)*']")).click();
        driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'30')])[2]")).click();

        driver.findElement(By.xpath("//button[contains(text(),'Find trains')]")).click();

        Assert.assertEquals("Modify Search", "Modify Search");
        System.out.println("User is in the train list");

        Thread.sleep(4000);
        WebElement web = driver.findElement(By.xpath("(//h4[text()='Journey Class ']//input[@name='jcAll'])[1]"));
        Assert.assertTrue(web.isSelected());
        System.out.println("Journey class is selected");

        Thread.sleep(4000);
        WebElement web1 = driver.findElement(By.xpath("(//label[text()='NEW DELHI(NDLS)']/..//input)[1]"));
        Assert.assertTrue(web1.isSelected());
        System.out.println("New delhi is selected");

        Thread.sleep(4000);
        WebElement web2 = driver.findElement(By.xpath("(//label[text()='CHANDIGARH(CDG)']/..//input)[1]"));
        Assert.assertTrue(web2.isSelected());
        System.out.println("Chandigarh is selected");

        Thread.sleep(4000);
        WebElement web3 = driver.findElement(By.xpath("//span[text()='30 Jul']"));
        Assert.assertEquals("30 Jul", "30 Jul");
        System.out.println("Departure date is same as selected");
        Assert.assertFalse(web3.isSelected());

        Thread.sleep(4000);
        int iCount;
        iCount = driver.findElements(By.xpath("//button[text()=' Check availability & fare ']")).size();
        String list = driver.findElement(By.xpath("//div[@class='col-md-12 hidden-xs']//b")).getText();
        String count = Integer.toString(iCount);
        Assert.assertEquals(list, count + " is " + count + " same as the trains found");

        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]")).click();
        System.out.println("The user is on flights page");

        Thread.sleep(4000);
        Set<String> windowIds = driver.getWindowHandles();
        Iterator<String> iter = windowIds.iterator();
        String childWindow = iter.next();
        driver.switchTo().window(childWindow);
        System.out.println("The title of the flight page is :" + driver.getTitle());
        Assert.assertEquals("Air Ticket Booking | Book Flight Tickets | Cheap Air Fare - IRCTC Air ", "Air Ticket Booking | Book Flight Tickets | Cheap Air Fare - IRCTC Air ");

    }
}
