package no.hartmann.javazone.google;

import static no.hartmann.javazone.google.GooglePageMother.PAGE_MOTHER;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage {

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchField;


    public SearchResultPage searchFor(String searchterm) {
        searchField.sendKeys(searchterm);
        searchField.submit();
        return PAGE_MOTHER.createSearchResultPage();
    }
}
