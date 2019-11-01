import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.util.List;

/**
 * All tests are performed for the website: https://www.booking.com/
 * To execute the tests for different browsers just uncomment specific WebDriver instance on the lines 36, 37 or 38.
 */

public class BookingTest {

    private WebDriver webDriver;
    private Page page;
    private LocalDate currentDate = LocalDate.now();
    private LocalDate datePlus7Days = currentDate.plusDays(7L);
    private static final Logger log = Logger.getLogger(BookingTest.class);

    @BeforeClass
    public void setUp(){
        //Setting properties for three different WebDriver instances
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");

        //Setting up WebDriver instances
//        webDriver = new ChromeDriver();
//        webDriver = new FirefoxDriver();
        webDriver = new InternetExplorerDriver();

        //Setting up Page instance
        page = new Page(webDriver);

        //Maximizing the browser window
        webDriver.manage().window().maximize();
        log.info("PRE CONDITION: Start the browser and maximize the window - DONE");
    }

    @Test(priority = 1)
    public void navigateToBasePageTest() {
        //Navigation to the base page
        page.navigateToBasePage("https://www.booking.com/index.en-gb.html");

        //Getting base page title
        String actualPageTitle = webDriver.getTitle();

        //Checking if actual page title is equal to the expected
        String BASE_PAGE_TITLE = "Booking.com | Official site | The best hotels & accommodation";
        Assert.assertEquals(actualPageTitle, BASE_PAGE_TITLE);
        log.info("TEST 1: Navigate to base page and verify - DONE");
    }

    @Test(priority = 2)
    public void fillTheFormTest(){
        //Filling 'destination' field with relevant city name
        page.fillDestinationField("New York");

        //Clicking on 'date picker' element
        page.datePickerClick();

        //Using selectDate method to click on the relevant dates
        page.selectDate(webDriver, currentDate);
        page.selectDate(webDriver, datePlus7Days);

        //Clicking on 'submit button' element
        page.submitButtonClick();
        log.info("TEST 2: Fill in the form and submit - DONE");
    }

    @Test(priority = 3)
    public void checkSearchResults(){
        //The 'search results location' elements with the same 'class name' locators are stored in List
        List<WebElement> list = webDriver.findElements(By.className("bui-link"));

        //Checking if there's at least one search result with location 'New York'
        for (WebElement location: list){
            Assert.assertTrue(location.getText().contains("New York") && list.size() >= 1);
        }
        log.info("TEST 3: Check the search results - DONE");
    }

    @AfterClass
    public void tearDown(){
        //Closing the browser
        if (webDriver != null)
            log.info("POST CONDITION: Close the browser - DONE");
            webDriver.close();
    }
}
