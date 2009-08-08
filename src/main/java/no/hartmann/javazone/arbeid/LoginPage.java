package no.hartmann.javazone.arbeid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.RenderedWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static no.hartmann.javazone.arbeid.ArbeidPageMother.PAGE_MOTHER;

public class LoginPage {
    private WebDriver driver;

    @FindBy(how = How.ID, using = "brukernavn")
    private WebElement brukernavnField;

    @FindBy(how = How.ID, using = "passord")
    private WebElement passordField;

    @FindBy(how = How.NAME, using = "login_Form")
    private WebElement loginForm;

    @FindBy(how = How.CLASS_NAME, using = "inputErrorContainer")
    private RenderedWebElement errorContainer;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public DinSidePage loginAs(String username, String password) {
        driver.findElement(By.id("brukernavn")).sendKeys(username);
        driver.findElement(By.id("passord")).sendKeys(password);
        driver.findElement(By.name("login_Form")).submit();
        return PAGE_MOTHER.createDinSidePage();
    }

    public DinSidePage loginAsElementVersion(String username, String password) {
        brukernavnField.sendKeys(username);
        passordField.sendKeys(password);
        loginForm.submit();
        return PAGE_MOTHER.createDinSidePage();
    }

    public LoginPage loginAsExpectingError(String username, String password) {
        driver.findElement(By.id("brukernavn")).sendKeys(username);
        driver.findElement(By.id("passord")).sendKeys(password);
        driver.findElement(By.name("login_Form")).submit();
        return this;
    }

    public boolean isErrorDisplayed() {
        return errorContainer.isDisplayed();
    }
}
