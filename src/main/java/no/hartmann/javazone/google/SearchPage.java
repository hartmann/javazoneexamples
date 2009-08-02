package no.hartmann.javazone.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by IntelliJ IDEA.
 * User: Vegard Hartmann
 * Date: 02.aug.2009
 * Time: 15:26:02
 * To change this template use File | Settings | File Templates.
 */
public class SearchPage {
    private WebDriver driver;

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchField;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultPage searchFor(String searchterm) {
        searchField.sendKeys(searchterm);
        searchField.submit();
        return new SearchResultPage(driver);
    }
}
