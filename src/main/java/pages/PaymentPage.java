package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    private WebDriver driver;

    @FindBy(id = "order-summary-container")
    WebElement orderSummary;

    public PaymentPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkForOrderSummary(){
        return orderSummary.isDisplayed();
    }

}
