package pages;

import com.qa.util.WaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(name = "operator")
    WebElement operator;

    @FindBy(name = "mobile")
    WebElement phoneNumberField;

    @FindBy(name = "amount")
    WebElement amountField;

    @FindBy(xpath = "//button[@perform='payment']")
    WebElement paymentButton;

//    @FindBy(xpath = "//li[@data-show='Telcel']")
//    WebElement TelcelOperator;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    public void goTo(String url) {
        driver.get(url);
    }

    public void clickOnOperator(){
        WaitUtility.waitForConditions(driver,operator);
        operator.click();
    }

    public void selectOperator(String operator){
        driver.findElement(By.xpath("//li[@data-show='"+operator+"']")).click();
    }


    public void enterPhoneNumber(String number) {
        phoneNumberField.clear();
        phoneNumberField.sendKeys(number);
    }

    public void selectRechargeAmount(int amount) {
        amountField.click();
        driver.findElement(By.xpath("//li[@data-name='"+amount+"']")).click();
    }

    public void clickOnPaymentButton() {
        paymentButton.click();
    }
}
