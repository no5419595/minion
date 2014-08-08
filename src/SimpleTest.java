//import com.beust.testng.annotations.*;
import org.testng.annotations.*;
//import org.testng.annotations.Test;

public class SimpleTest {
    @Configuration(beforeTestClass = true)
    public void setUp() {
// code that will be invoked when this test is instantiated
    }
    @Test(groups = { "functest" })
    public void itWorks() {
// This method will be invoked if the current run
// includes the group "functest"
    }
}