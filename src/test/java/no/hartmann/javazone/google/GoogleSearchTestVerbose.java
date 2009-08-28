package no.hartmann.javazone.google;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import static junit.framework.Assert.assertNotNull;

public class GoogleSearchTestVerbose {

    @Test
    public void searchForWebDriverResultShouldContainLinkWithWordWebDriver() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://www.google.com/");
        WebElement searchField = webDriver.findElement(By.name("q"));
        searchField.sendKeys("webdriver");
        searchField.submit();
        assertNotNull(webDriver.findElement(By.partialLinkText("webdriver")));
        webDriver.quit();
    }
}


