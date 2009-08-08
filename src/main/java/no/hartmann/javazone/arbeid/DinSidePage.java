package no.hartmann.javazone.arbeid;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DinSidePage {

    @FindBy(how = How.CLASS_NAME, using = "tittelheader")
    private WebElement tittelheader;

    public boolean isCurrentPage() {
        return null != tittelheader;
    }
}
