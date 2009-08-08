package no.hartmann.javazone.arbeid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static junit.framework.Assert.assertTrue;
import static no.hartmann.javazone.arbeid.ArbeidPageMother.PAGE_MOTHER;

public class ArbeidLoginTest {
    private WebDriver driver;

    @Test
    public void shouldGoToDinSideAfterSuccessfulLogin() {
        LoginPage loginPage = PAGE_MOTHER.createLoginPage();
        DinSidePage dinSidePage = loginPage.loginAs("gyldigbruker", "gyldigpassord");
        assertTrue(dinSidePage.isCurrentPage());
    }

    @Test
    public void shouldDisplayErrorWhenEnteringWrongUserPasswordCombination() {
        LoginPage loginPage = PAGE_MOTHER.createLoginPage();
        loginPage = loginPage.loginAsExpectingError("ugyldigbruker", "ugyldigpassord");
        assertTrue(loginPage.isErrorDisplayed());
    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        PAGE_MOTHER.initialize(driver);
        driver.get("https://www.nav.no/sbl/loginBoks.do");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
