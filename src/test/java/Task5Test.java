import Pages.ModernTesterFormPage;
import Utils.Commands;
import Utils.Continent;
import Utils.Gender;
import Utils.Professions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Task5Test extends TestBase {
    @Test
    public void fillUpForm1(){
        // Open the site
        driver.get("https://seleniumui.moderntester.pl/form.php");

        ModernTesterFormPage modernTesterFormPage = new ModernTesterFormPage(driver);

        modernTesterFormPage.fillFirstName("FnameTest")
                .fillLastName("LnameTest")
                .fillEmail("email@test.test")
                .pickGender(Gender.MALE)
                .sendAge(50)
                .pickYearsOfExperience(4)
                .pickProfession(new Professions(true, true, false))
                .selectContinent(Continent.ASIA)
                .selectCommands(
                        new Commands(
                                true,
                                true,
                                false,
                                true,
                                false))
                .uploadFile("C:\\Users\\kdynowski\\Downloads\\test-file-to-download.xlsx")
                .fillAdditionalInfoInput("Some additional information")
                .submit();
        Assert.assertEquals(modernTesterFormPage.getMessage(), "Form send with success");
    }

    @Test
    public void downloadFile(){
        // Open the site
//        driver.get("https://seleniumui.moderntester.pl/form.php");
//
//        ModernTesterFormPage modernTesterFormPage = new ModernTesterFormPage(driver);
//        int lengthBefore = downloadFolder.listFiles().length;
//        modernTesterFormPage.downloadTestFile();
//        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        webDriverWait.until(len -> downloadFolder.listFiles().length > lengthBefore);
//        int lengthAfter = downloadFolder.listFiles().length;
//        Assert.assertEquals(lengthAfter, lengthBefore + 1);
//
//        File [] fileList = downloadFolder.listFiles();
//        List<String> fileNames = new ArrayList<>();
//        for(File file: fileList) fileNames.add(file.getName());
//        Assert.assertTrue(fileNames.contains("test-file-to-download.xlsx"));
    }
}
