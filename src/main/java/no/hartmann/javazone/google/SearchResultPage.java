package no.hartmann.javazone.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLinkPresentInResults(String url) {
        try {
            WebElement urlElement = driver.findElement(By.xpath("//a[@href='" + url + "']"));
            return null != urlElement;
        } catch (Exception e) {
            return false;
        }
    }
}
