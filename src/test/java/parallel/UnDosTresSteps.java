package parallel;

import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.HomePage;

public class UnDosTresSteps {

    HomePage homePage = new HomePage(DriverFactory.getDriver());

    @Given("Go to {string} under recarga celular select operator as {string} from Operador field")
    public void userIsOnFlipkartSite() {

    }

    @And("under  Monto de Recarga select 10 dollar normal recharge")
    public void checker(){
        //pass
    }

}
