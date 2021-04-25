package parallel;

import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.PaymentPage;

public class UnDosTresSteps {

    HomePage homePage = new HomePage(DriverFactory.getDriver());
    PaymentPage paymentPage= new PaymentPage(DriverFactory.getDriver());

    @Given("Go to {string} under recarga celular select operator as {string} from Operador field")
    public void userIsOnFlipkartSite(String url, String operator) {
            homePage.goTo(url);
            homePage.clickOnOperator();
            homePage.selectOperator(operator);
    }

    @And("Give this number {string} under Numero de celular field")
    public void giveThisNumberUnderNumeroDeCelularField(String number) {
        homePage.enterPhoneNumber(number);
    }

    @And("under  Monto de Recarga select {int} dollar normal recharge")
    public void underMontoDeRecargaSelectDollarNormalRecharge(int amount) {
        homePage.selectRechargeAmount(amount);
    }

    @When("click on siguiente")
    public void clickOnSiguiente() {
        homePage.clickOnPaymentButton();
    }

    @Then("Verify if the user able to reach to the next screen\\(Payment screen) or not")
    public void verifyIfTheUserAbleToReachToTheNextScreenPaymentScreenOrNot() {
        Assert.assertTrue(paymentPage.checkForOrderSummary());
    }

    @And("On payment screen click on tarjeta")
    public void onPaymentScreenClickOnTarjeta() {
        paymentPage.clickOnTarjeta();

        paymentPage.clickOnUsarNuevaTarjeta();
    }

    @And("enter the following details under card name:Test ,Card number:{string} ,month={string},date={string},cvv={string}")
    public void enterTheFollowingDetailsUnderCardNameTestCardNumberMonthDateCvv(String cardNumber, String month, String year, String cvv) {
        paymentPage.enterCardDetails(cardNumber,month,year,cvv);

    }

    @And("under correo electronico field give email id as {string}")
    public void underCorreoElectronicoFieldGiveEmailIdAs(String email) {
        paymentPage.enterEmail(email);
    }

    @And("Click on Pagar con Tarjeta to do the recharge")
    public void clickOnPagarConTarjetaToDoTheRecharge() {
        paymentPage.clickOnPagarConTarjeta();

    }

    @And("on popup Enter the following email {string}  and password {string}")
    public void onPopupEnterTheFollowingEmailAndPassword(String email, String password) {
        paymentPage.enterEmailIdAndPassword(email,password);
        paymentPage.clickOnCapcha();
        paymentPage.clickOnLoginButton();
    }

    @And("Verify if the user gets a success message and recharge gets successful")
    public void verifyIfTheUserGetsASuccessMessageAndRechargeGetsSuccessful() {

        Assert.assertTrue(paymentPage.checkSiteContainsSuccess());
    }
}
