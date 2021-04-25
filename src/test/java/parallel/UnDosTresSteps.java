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
}
