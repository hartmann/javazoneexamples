package no.hartmann.javazone.arbeid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ArbeidLoginTest {

    public void shouldGoToXXXAfterSuccessfulLogin() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.nav.no/sbl/loginBoks.do");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("user", "password");
    }

}
