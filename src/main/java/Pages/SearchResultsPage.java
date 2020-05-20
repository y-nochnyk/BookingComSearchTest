package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage extends PageObject {

    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='searchresultsTmpl']/header")
    private WebElement destinationHeader;

    @FindBy(xpath = "//*[@class='bui-link']")
    private List<WebElement> location;

    public SearchResultsPage(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver, 20);
    }

    public WebElement getDestinationHeader() {
        WebElement header = wait.until(ExpectedConditions.visibilityOf(destinationHeader));
        return header;
    }

    public List<WebElement> getSearchResultsLocationList(){
        return location;
    }
}
