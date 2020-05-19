import Pages.BasePage;
import Pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestStarter {
    static WebDriver driver;
    static BasePage basePage;
    static SearchResultsPage searchResultsPage;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");

        String browser = System.getProperty("browser");
        System.out.println(browser);

        if (browser.equals("chrome")){
            driver = new ChromeDriver();
        }else if (browser.equals("firefox")){
            driver = new FirefoxDriver();
        }

        basePage = new BasePage(driver);
        searchResultsPage = new SearchResultsPage(driver);

        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
