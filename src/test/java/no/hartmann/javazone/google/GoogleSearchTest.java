package no.hartmann.javazone.google;

import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchTest {
    private WebDriver driver;

    @Test
    public void whenSearchingForWebDriverUrlShouldBePresentInSearchResults() {
        SearchPage searchPage = createSearchPage(driver);
        SearchResultPage resultPage = searchPage.searchFor("webdriver");
        assertTrue(resultPage.isLinkPresentInResults("http://code.google.com/p/webdriver/"));
    }

    private SearchPage createSearchPage(WebDriver driver) {
        SearchPage searchPage = new SearchPage(driver);
        PageFactory.initElements(driver, searchPage);
        return searchPage;
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
}
