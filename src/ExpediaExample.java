import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class ExpediaExample {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","C:/Users/grace.kim/Downloads/chromedriver_win32/chromedriver.exe");

        driver = new FirefoxDriver();

        System.out.println("************Open Expedia website************");
        driver.get("http://www.expedia.com");

//This will get window ID's
        Set<String> windowIds = driver.getWindowHandles();
        Iterator<String> iter = windowIds.iterator();
        while(iter.hasNext()){
            System.out.println("first window id - " + iter.next());

        }

//Click on Feedback
        driver.findElement(By.id("header-support-menu")).click();
        driver.findElement(By.id("header-support-feedback")).click();

        System.out.println("Page title is1: " + driver.getTitle());

        String winHandleBefore = driver.getWindowHandle();

        System.out.println(driver.getWindowHandles().size());

        for(String winHandle : driver.getWindowHandles()){
            System.out.println("Window Handle: "  + winHandle);
            driver.switchTo().window(winHandle);
            System.out.println("Page title of the pop up window: " + driver.getCurrentUrl());
        }

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[class*='tab']")));
        System.out.println(driver.getTitle());



        driver.findElement(By.className("closeButton")).click();


        System.out.println("switch back to the original window ");
        for(String winHandle : driver.getWindowHandles()){
            System.out.println("Window Handle: "  + winHandle);
            driver.switchTo().window(winHandle);
        }
        System.out.println(driver.getTitle());

        driver.findElement(By.id("primary-header-package")).click();
        driver.close();

    }


}
