import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


class Wait {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Java/Selenium/exeFile/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/");
        driver.findElement(By.linkText("Today's Deals")).click();

        driver.findElement(By.xpath("//a[contains(text(),'View Deal')]")).click();
        System.out.println("deal clicked");
        driver.findElement(By.xpath("//a[@class='a-link-normal s-access-detail-page s-color-twister-title-link a-text-normal']")).click();
        Set<String> sessions=driver.getWindowHandles();
        Iterator<String> itr=sessions.iterator();

        String parentID=itr.next();
        System.out.println(parentID);
        String childID=itr.next();
        System.out.println(childID);
        driver.switchTo().window(childID);

        System.out.println("windows handled");
        WebElement ele=driver.findElement(By.id("native_dropdown_selected_size_name"));
        Select sel=new Select(ele);
        sel.selectByIndex(2);
        System.out.println("size selected");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();


    }

}