package no.hartmann.javazone.google;

import static junit.framework.Assert.assertTrue;
import static no.hartmann.javazone.google.GooglePageMother.PAGE_MOTHER;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GoogleSearchBrowserTest {

    private WebDriver driver;


    public void whenSearchingForWebDriverUrlShouldBePresentInSearchResults() {
        SearchPage searchPage = PAGE_MOTHER.createSearchPage();
        SearchResultPage resultPage = searchPage.searchFor("webdriver");
        assertTrue(resultPage.isLinkPresentInResults("http://code.google.com/p/webdriver/"));
    }

    @Test
    public void firefox() {
        firefoxSetup();
        whenSearchingForWebDriverUrlShouldBePresentInSearchResults();
    }

    @Test
    public void ie() {
        ieSetup();
        whenSearchingForWebDriverUrlShouldBePresentInSearchResults();
    }

    @Test
    public void htmlunit() {
        htmlUnitSetup();
        whenSearchingForWebDriverUrlShouldBePresentInSearchResults();
    }

    public void firefoxSetup() {
        driver = new FirefoxDriver();
        commonSetup();
    }

    public void ieSetup() {
        driver = new InternetExplorerDriver();
        commonSetup();
    }

    public void htmlUnitSetup() {
        driver = new HtmlUnitDriver();
        commonSetup();
    }

    private void commonSetup() {
        PAGE_MOTHER.initialize(driver);
        driver.get("http://www.google.com/");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
