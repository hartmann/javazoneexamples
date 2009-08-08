package no.hartmann.javazone.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertNotNull;

public class GoogleSearchTest {

    @Test
    public void whenSearchingForWebDriverUrlShouldBePresentInSearchResults() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com/");
        SearchPage searchPage = createSearchPage(driver);
        SearchResultPage resultPage = searchPage.searchFor("webdriver");
        assertTrue(resultPage.isLinkPresentInResults("http://code.google.com/p/webdriver/"));
    }

    @Test
    public void whenSearchingForWebDriverResultPageShouldContainLinkWithWordWebDriver() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com/");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("webdriver");
        searchField.submit();
        assertNotNull(driver.findElement(By.partialLinkText("webdriver")));
    }

    private SearchPage createSearchPage(WebDriver driver) {
        SearchPage searchPage = new SearchPage(driver);
        PageFactory.initElements(driver, searchPage);
        return searchPage;
    }
}
