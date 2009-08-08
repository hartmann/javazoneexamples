package no.hartmann.javazone.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertNotNull;

public class GoogleSearchTest {
    private WebDriver driver;

    @Test
    public void whenSearchingForWebDriverUrlShouldBePresentInSearchResults() {
        SearchPage searchPage = createSearchPage(driver);
        SearchResultPage resultPage = searchPage.searchFor("webdriver");
        assertTrue(resultPage.isLinkPresentInResults("http://code.google.com/p/webdriver/"));
    }

    @Test
    public void searchForWebDriverResultShouldContainLinkWithWordWebDriver() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://www.google.com/");
        WebElement searchField = webDriver.findElement(By.name("q"));
        searchField.sendKeys("webdriver");
        searchField.submit();
        assertNotNull(webDriver.findElement(By.partialLinkText("webdriver")));
    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://www.google.com/");
    }

    @After
    public void teardown() {
        driver.quit();
    }

    private SearchPage createSearchPage(WebDriver driver) {
        SearchPage searchPage = new SearchPage(driver);
        PageFactory.initElements(driver, searchPage);
        return searchPage;
    }
}
