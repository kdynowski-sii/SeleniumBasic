package Pages;

import Utils.Commands;
import Utils.Continent;
import Utils.Gender;
import Utils.Professions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ModernTesterFormPage {
    private final WebDriver driver;

    @FindBy(id = "inputFirstName3")
    private WebElement firstnameInput;

    @FindBy(id = "inputLastName3")
    private WebElement lastnameInput;

    @FindBy(id = "inputEmail3")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='gridRadiosSex']")
    private List<WebElement> genderRadios;

    @FindBy(id = "inputAge3")
    private WebElement ageInput;

    @FindBy(xpath = "//input[@name='gridRadiosExperience']")
    private List<WebElement> yearsOfExperienceRadios;

    @FindBy(xpath = "//input[@name='gridCheckboxProfession']")
    private List<WebElement> professionCheckboxes;

    @FindBy(id = "selectContinents")
    private WebElement continentSelector;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumCommandsSelect;

    @FindBy(id = "chooseFile")
    private WebElement selectFileInput;

    @FindBy(id = "additionalInformations")
    private WebElement additionalInfoInput;

    @FindBy(partialLinkText = "File")
    private WebElement downloadFileLink;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public ModernTesterFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public ModernTesterFormPage fillFirstName(String name){
        firstnameInput.clear();
        firstnameInput.sendKeys(name);
        return this;
    }

    public ModernTesterFormPage fillLastName(String name){
        lastnameInput.clear();
        lastnameInput.sendKeys(name);
        return this;
    }

    public ModernTesterFormPage fillEmail(String mail){
        emailInput.clear();
        emailInput.sendKeys(mail);
        return this;
    }

    public ModernTesterFormPage pickGender(Gender gender){
        switch(gender){
            case MALE:
                genderRadios.get(0).click();
                break;
            case FEMALE:
                genderRadios.get(1).click();
                break;
            case OTHER:
                genderRadios.get(2).click();
                break;
            default:
                pickGender(Gender.FEMALE);
        }
        return this;
    }

    public ModernTesterFormPage sendAge(int age){
        ageInput.clear();
        ageInput.sendKeys(String.valueOf(age));
        return this;
    }

    public ModernTesterFormPage pickYearsOfExperience(int value){
        switch(value){
            case 1:
                yearsOfExperienceRadios.get(0).click();
                break;
            case 2:
                yearsOfExperienceRadios.get(1).click();
                break;
            case 3:
                yearsOfExperienceRadios.get(2).click();
                break;
            case 4:
                yearsOfExperienceRadios.get(3).click();
                break;
            case 5:
                yearsOfExperienceRadios.get(4).click();
                break;
            case 6:
                yearsOfExperienceRadios.get(5).click();
                break;
            default:
                yearsOfExperienceRadios.get(6).click();
                break;
        }
        return this;
    }

    public ModernTesterFormPage pickProfession(Professions professions){
        if(professions.isManual())
            professionCheckboxes.get(0).click();
        if(professions.isAutomation())
            professionCheckboxes.get(1).click();
        if(professions.isOther())
            professionCheckboxes.get(2).click();
        if(!professions.isOther() && !professions.isAutomation() && !professions.isManual())
            professionCheckboxes.get(0).click();
        return this;
    }

    public ModernTesterFormPage selectContinent(Continent continent){
        Select continentSelect = new Select(continentSelector);
        switch(continent){
            case ASIA:
                continentSelect.selectByValue("asia");
                break;
            case EUROPE:
                continentSelect.selectByValue("europe");
                break;
            case AFRICA:
                continentSelect.selectByValue("africa");
                break;
            case ANTARCTICA:
                continentSelect.selectByValue("antarctica");
                break;
            case NORTH_AMERICA:
                continentSelect.selectByValue("north-america");
                break;
            case SOUTH_AMERICA:
                continentSelect.selectByValue("south-america");
                break;
            case AUSTRALIA:
                continentSelect.selectByValue("australia");
                break;
            default:
                return selectContinent(Continent.SOUTH_AMERICA);
        }
        return this;
    }

    public ModernTesterFormPage selectCommands(Commands commands){
        Select seleniumCommandsSelect = new Select((WebElement) this.seleniumCommandsSelect);
        if(commands.allFalse())
            seleniumCommandsSelect.selectByIndex(1);
        if(commands.isBrowserCommands())
            seleniumCommandsSelect.selectByValue("browser-commands");
        if(commands.isWaitCommands())
            seleniumCommandsSelect.selectByValue("wait-commands");
        if(commands.isSwitchCommands())
            seleniumCommandsSelect.selectByValue("switch-commands");
        if(commands.isNavigationCommands())
            seleniumCommandsSelect.selectByValue("navigation-commands");
        if(commands.isWebelementCommands())
            seleniumCommandsSelect.selectByValue("webelement-commands");
        return this;
    }

    public ModernTesterFormPage fillAdditionalInfoInput(String info){
        additionalInfoInput.clear();
        additionalInfoInput.sendKeys(info);
        return this;
    }

    public ModernTesterFormPage downloadTestFile(){
        downloadFileLink.click();
        return this;
    }

    public ModernTesterFormPage submit(){
        submitButton.click();
        return this;
    }

    public String getMessage(){
        String message = driver.findElement(By.id("validator-message")).getText();
        return message;
    }

    public ModernTesterFormPage uploadFile(String fileUrl){
        selectFileInput.sendKeys(fileUrl);
        return this;
    }
}
