import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.*;

/**
 * Created by grace.kim on 06/08/2014.
 */
public class AttributesOfParentElem {
    public static void main(String[] argv){

        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.asp.net/AjaxLibrary/AjaxControlToolkitSampleSite/CascadingDropDown/CascadingDropDown.aspx");

        WebElement element = driver.findElement(By.xpath(".//*[@id='ctl00_SampleContent_DropDownList1']"));
        WebElement parent = driver.findElement(By.xpath(".//*[@id='ctl00_SampleContent_DropDownList1']" + "/../../../../.."));
        ArrayList parentAttributes = (ArrayList) ((JavascriptExecutor)driver).executeScript(
                "var s = []; var attrs = arguments[0].attributes; for (var l = 0; l < attrs.length; ++l) { var a = attrs[l]; s.push(a.name + ':' + a.value); } ; return s;", parent);

        for (Object o : parentAttributes) {
            System.out.println(o);
        }
        driver.close();
    }
}
