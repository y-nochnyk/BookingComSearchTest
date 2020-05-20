package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BasePage extends PageObject {

    private WebDriverWait wait;

    @FindBy(id = "ss")
    private WebElement destinationField;

    @FindBy(className = "xp__dates-inner")
    private WebElement checkIn;

    @FindBy(css = ".xp__button")
    private WebElement submitButton;

    public BasePage (WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver, 20);
    }

    public void fillDestinationField (String destination){
        destinationField.sendKeys(destination);
    }

    public void clickTheDatePicker(){
        WebElement calendar = wait.until(ExpectedConditions.visibilityOf(checkIn));
        calendar.click();
    }

    public void pickTheDate (LocalDate date){

        //Looking at the markup the attribute data-date is formatted as an ISO_LOCAL_DATE
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        //Programmatically generate date locator based on date passed in
        By dateLocator = By.xpath(String.format("//td[@data-date='%s']", formatter.format(date)));

        //Wait for 'date' element to be visible, then click on it
        WebElement chosenDate = wait.until(ExpectedConditions.visibilityOfElementLocated(dateLocator));
        chosenDate.click();
    }

    public void clickSubmitButton(){
        WebElement submit = wait.until(ExpectedConditions.visibilityOf(submitButton));
        submit.click();
    }
}
