package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchResultsPage extends PageObject {

    @FindBy(xpath = "//*[@class='bui-link']")
    private List<WebElement> location;

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    public List<WebElement> getSearchResultsLocationList(){
        return location;
    }
}
