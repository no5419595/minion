import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

/**
 * Created by grace.kim on 05/08/2014.
 */
public class GoogleTestScript {

    static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public static void setUp(String browser) {

        System.out.println("browser: " + browser);

        if(browser.equalsIgnoreCase("FF")){
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("CH")){
            //            driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());
            System.setProperty("webdriver.chrome.driver","C:/Users/grace.kim/Downloads/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "C:/Users/grace.kim/Downloads/IEDriverServer_Win32_2.42.0/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
      //  driver = new HtmlUnitDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
           driver.get("http://www.google.com");
           System.out.println("Page title is: " + driver.getTitle());


    }
    @Test(groups= "group1")
    public void testCase(){
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("TestNG");

        element.submit();
        System.out.println("Page title is2: " + driver.getTitle());

    }
    @Test(groups= "group2")
    public void testCase2(){
        System.out.println("Page title is3: " + driver.getTitle());

        // Find the text input element by its name
        WebElement element = driver.findElement(By.id("gb_70"));
        element.click();
        System.out.println("Page title is4: " + driver.getTitle());
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }

}
