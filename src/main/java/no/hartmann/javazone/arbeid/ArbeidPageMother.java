package no.hartmann.javazone.arbeid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public enum ArbeidPageMother {

    PAGE_MOTHER();

    private WebDriver driver;

    public void initialize(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage createLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        return loginPage;
    }

    public DinSidePage createDinSidePage() {
        return PageFactory.initElements(driver, DinSidePage.class);
    }
}
