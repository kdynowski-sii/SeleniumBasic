import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3Test extends TestBase{
    @Test
    public void getUrlTest(){
        final String url = "https://seleniumui.moderntester.pl/";
        driver.get(url);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, url);
    }


}
