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

        //Navigating to the base page
        driver.get(TestData.BASE_PAGE_URL);

        //Getting base page title
        String actualPageTitle = driver.getTitle();

        //Checking if actual page title is equal to the expected
        assertTrue(actualPageTitle.contains("Booking.com"));
    }

    @Test(priority = 2)
    public void selectDestinationAndDate(){

        // Filling the search form with the city name "New York"
        basePage.fillDestinationField(TestData.CITY_NAME);

        // Clicking on the date picker element
        basePage.clickTheDatePicker();

        // Picking the 'current' date on the calendar
        basePage.pickTheDate(TestData.currentDate);

        // Picking the 'current + 7 days' date on the calendar
        basePage.pickTheDate(TestData.currentPlusSeven);

        // Clicking submit button
        basePage.clickSubmitButton();
    }

    @Test(priority = 3)
    public void checkSearchResults(){
        //The 'search results location elements with the same 'XPath' locators are stored in List
        List<WebElement> locationList = searchResultsPage.getSearchResultsLocationList();

        //Checking if there's at least one search result with location 'New York'
        for (WebElement location: locationList){
            assertTrue(location.getText().contains(TestData.CITY_NAME) && locationList.size() >= 1);
        }
    }
}
