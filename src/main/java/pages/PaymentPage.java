package pages;

import com.qa.util.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    private WebDriver driver;

    @FindBy(id = "order-summary-container")
    WebElement orderSummary;

    @FindBy(xpath = "//p[@data-qa='tarjeta-tab']")
    WebElement tarjetaTab;

    @FindBy(xpath = "//span[text()='Usar nueva tarjeta']")
    WebElement UsarNuevaTarjetaRadioButton;

    @FindBy(xpath = "//input[@placeholder='Mes']")
    WebElement enterMonth;

    @FindBy(xpath = "//input[@placeholder='Año']")
    WebElement enterYear;

    @FindBy(xpath = "//input[@placeholder='CVV']")
    WebElement enterCVV;

    @FindBy(id = "cardnumberunique")
    WebElement enterCardNumber;

    @FindBy(xpath = "//input[@name='txtEmail']")
    WebElement enterEmailId;

    @FindBy(id = "paylimit")
    WebElement pagarConTarjeta;

    @FindBy(name = "email")
    WebElement enterEmailIdOnPopUp;

    @FindBy(name = "password")
    WebElement enterPassword;

    @FindBy(className = "g-recaptcha")
    WebElement capcha;

    @FindBy(id = "loginBtn")
    WebElement loginButton;

    @FindBy(xpath = "//div[text()='¡Recarga Exitosa!']")
    WebElement successMessage;

    public PaymentPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkForOrderSummary(){
        return orderSummary.isDisplayed();
    }

    public void clickOnTarjeta() {
        tarjetaTab.click();
    }

    public void clickOnUsarNuevaTarjeta() {

        while(!enterCardNumber.isDisplayed()){
            UsarNuevaTarjetaRadioButton.click();
        }
    }

    public void enterCardDetails(String cardNumber, String month, String year, String cvv) {

        WaitUtility.waitForConditions(driver,enterCardNumber);
        enterCardNumber.sendKeys(cardNumber);
        enterMonth.sendKeys(month);
        enterYear.sendKeys(year);
        enterCVV.sendKeys(cvv);
    }

    public void enterEmail(String email) {
        enterEmailId.sendKeys(email);
    }

    public void clickOnPagarConTarjeta() {
        pagarConTarjeta.click();
    }

    public void enterEmailIdAndPassword(String email, String password) {
        enterEmailIdOnPopUp.sendKeys(email);
        enterPassword.sendKeys(password);
    }

    public void clickOnCapcha(){
        capcha.click();
    }

    public void clickOnLoginButton() {
        WaitUtility.waitForConditions(driver,loginButton);
        loginButton.click();
    }

    public boolean checkSiteContainsSuccess() {
        WaitUtility.apply(driver);
        WaitUtility.waitForConditions(driver,successMessage);
        return successMessage.isDisplayed();
    }
}
