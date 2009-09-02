package no.hartmann.javazone.google;

import static junit.framework.Assert.assertTrue;
import static no.hartmann.javazone.google.GooglePageMother.PAGE_MOTHER;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchTest {
    private WebDriver driver;

    @Test
    public void whenSearchingForWebDriverUrlShouldBePresentInSearchResults() {
        SearchPage searchPage = PAGE_MOTHER.createSearchPage();
        SearchResultPage resultPage = searchPage.searchFor("webdriver");
        assertTrue(resultPage.isLinkPresentInResults("http://code.google.com/p/webdriver/"));
    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        PAGE_MOTHER.initialize(driver);
        driver.get("http://www.google.com/");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
