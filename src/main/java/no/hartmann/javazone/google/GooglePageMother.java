package no.hartmann.javazone.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public enum GooglePageMother {

    PAGE_MOTHER();

    private WebDriver driver;

    public void initialize(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage createSearchPage() {
        return PageFactory.initElements(driver, SearchPage.class);
    }

    public SearchResultPage createSearchResultPage() {
        return new SearchResultPage(driver);
    }
}
