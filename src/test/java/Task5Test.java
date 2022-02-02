import Pages.ModernTesterFormPage;
import Utils.Commands;
import Utils.Continent;
import Utils.Gender;
import Utils.Professions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task5Test extends TestBase {
    @Test
    public void fillupForm1(){
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
}
