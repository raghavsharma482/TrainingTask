import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Time {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Java/Selenium/exeFile/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//implicit wait

        driver.get("http://www.amazon.in");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(text(),'Today')]")).click();//click on today's deal

        driver.findElement(By.xpath("//span[@class='a-button-inner']")).click(); //click on view deal
        driver.findElement(By.xpath("//li[@id='result_0']//div[@class='s-item-container']")).click(); //click on the item

        Set<String> sessions = driver.getWindowHandles();
        Iterator<String> itr = sessions.iterator();

        String parentID = itr.next();

        String childID = itr.next();
        driver.switchTo().window(childID);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("native_dropdown_selected_size_name")));
        WebElement ele = driver.findElement(By.id("native_dropdown_selected_size_name"));
        Select sel = new Select(ele);
        sel.selectByIndex(2);
        Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='add-to-cart-button']")));
        WebElement addToCartBtn = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        addToCartBtn.click();
    }
}
