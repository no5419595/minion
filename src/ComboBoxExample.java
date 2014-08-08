import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class ComboBoxExample {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.asp.net/AjaxLibrary/AjaxControlToolkitSampleSite/CascadingDropDown/CascadingDropDown.aspx");

       // Select select = new Select(driver.findElement(By.className("btn_nctg")));
        //select.getOptions();

        WebElement sel = driver.findElement(By.xpath(".//*[@id='ctl00_SampleContent_DropDownList1']"));
        List<WebElement> lists = sel.findElements(By.tagName("option"));
        for(WebElement element: lists)
        {
            String var2 = element.getText();
            System.out.println(var2);
        }


        driver.close();
    }

}
