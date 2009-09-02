package no.hartmann.javazone.google;

import static junit.framework.Assert.assertNotNull;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchTestVerbose {

    @Test
    public void whenSearchingForWebDriverUrlShouldBePresentInSearchResults() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://www.google.com/");
        WebElement searchField = webDriver.findElement(By.name("q"));
        searchField.sendKeys("webdriver");
        searchField.submit();
        assertNotNull(webDriver.findElement(By.xpath("//a[@href='http://code.google.com/p/webdriver/']")));
        webDriver.quit();
    }
}


