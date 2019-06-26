import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionMouse {

    public Integer makeInt(String test) {
        StringBuilder sb = new StringBuilder();
        String[] splitted = test.split(",");
        for (int i = 0; i < splitted.length; i++) {
            sb.append(splitted[i]);
        }
        String withoutComma = sb.toString();
        return Integer.parseInt(withoutComma);
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Java/Selenium/exeFile/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.goibibo.com/");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]")).click();
        Actions act = new Actions(driver);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]")).sendKeys("Delhi");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Delhi, India']")).click();
        //destination
        driver.findElement(By.xpath("//*[@id=\"gosuggest_inputDest\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"gosuggest_inputDest\"]")).sendKeys("Mumbai");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Mumbai, India']")).click();
        Thread.sleep(2000);
        //date
        driver.findElement(By.xpath("//div[@id='fare_20190621']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Return']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
        driver.findElement(By.xpath("//div[@id='fare_20190622']")).click();
        driver.findElement(By.xpath("//div[@id='pax_link_common']")).click();
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//button[@id='adultPaxPlus']")).click();
            Thread.sleep(2000);
        }
        for (int j = 0; j < 3; j++) {
            driver.findElement(By.xpath("//button[@id='childPaxPlus']")).click();
        }
        driver.findElement(By.xpath("//select[@id='gi_class']")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Business')]")).click();
        // click on search button
        driver.findElement(By.xpath("//button[@id='gi_search_btn']")).click();
        Thread.sleep(2000);

        WebElement e = driver.findElement(By.xpath("//span[text()='Price']"));
        act.moveToElement(e).perform();
        WebElement slider = driver.findElement(By.xpath("//div[@id=\"sliderFO\"]//div[@class=\"fltSld-handle fltSld-handle-1 \"]"));
        act.clickAndHold(slider);
        act.dragAndDropBy(slider, -75, 0).perform();
        WebElement slider2 = driver.findElement(By.xpath("//div[@id=\"sliderFR\"]//div[@class=\"fltSld-handle fltSld-handle-1 \"]"));
        act.clickAndHold(slider2);
        act.dragAndDropBy(slider2, -55, 0).perform();

       /* for(int i= 0;i<=500;i++)
        {
            act.dragAndDropBy(slider,-i,0).perform();
            String s1=driver.findElement(By.xpath("")).getText();
            Integer value
        }*/


    }

}