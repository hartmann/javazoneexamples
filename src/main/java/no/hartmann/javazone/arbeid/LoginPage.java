package no.hartmann.javazone.arbeid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAs(String username, String password) {
        driver.findElement(By.id("brukernavn")).sendKeys(username);
        driver.findElement(By.id("passord")).sendKeys(password);
        driver.findElement(By.name("login_Form")).submit();
    }
}
