package no.hartmann.javazone.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Vegard Hartmann
 * Date: 02.aug.2009
 * Time: 15:24:36
 * To change this template use File | Settings | File Templates.
 */
public class GoogleSearchTest {

    @Test
    public void whenSearcingForWebDriverUrlShouldBePresentInSearchResults() {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.google.com/");
        SearchPage searchPage = createSearchPage(driver);
        searchPage.searchFor("webdriver");
    }

    private SearchPage createSearchPage(WebDriver driver) {
        SearchPage searchPage = new SearchPage(driver);
        PageFactory.initElements(driver, searchPage);
        return searchPage;
    }
}
