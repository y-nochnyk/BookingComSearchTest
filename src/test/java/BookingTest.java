import TestData.TestData;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.*;

/**
 * All tests are performed for the website: https://www.booking.com/
 */

public class BookingTest extends TestStarter {

    @Test(priority = 1)
    public void navigateToBasePageTest() {

        driver.get(TestData.BASE_PAGE_URL);

        //Getting base page title
        String actualPageTitle = driver.getTitle();

        //Checking if actual page title is equal to the expected
        assertTrue(actualPageTitle.contains("Booking.com"), "ACTUAL BASE PAGE TITLE IS NOT VALID!");
    }

    @Test(priority = 2)
    public void selectDestinationAndDate(){

        basePage.fillDestinationField(TestData.CITY_NAME);

        basePage.clickTheDatePicker();

        basePage.pickTheDate(TestData.currentDate);

        basePage.pickTheDate(TestData.currentPlusSeven);

        basePage.clickSubmitButton();

        // Checking if the destination header element of the results page contains 'New York'
        String actualDestinationHeader = searchResultsPage.getDestinationHeader().getText();
        assertTrue(actualDestinationHeader.contains(TestData.CITY_NAME), "DESTINATION HEADER INFO IS NOT VALID");
    }

    @Test(priority = 3)
    public void checkSearchResults(){
        // The 'search results location elements with the same 'XPath' locators are stored in List
        List<WebElement> locationList = searchResultsPage.getSearchResultsLocationList();

        // Checking if there's at least one search result with location 'New York'
        for (WebElement location: locationList){
            assertTrue(location.getText().contains(TestData.CITY_NAME)
                    && locationList.size() >= 1, "LOCATION OR AMOUNT OF RESULTS AT THE RESULTS PAGE IS NOT VALID");
        }
    }
}
