package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webpages.MessengerPage;
import org.testng.Assert;

public class MessengerSD {

    private MessengerPage messengerPage = new MessengerPage();

    @Given("^I am on messenger page$")
    public void setMessengerPage() {
        messengerPage.clickOnMessengerLink();
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://www.messenger.com/");
    }

    @When("^I enter (.+) into (username|password) field on the messenger page$")
    public void enterDataIntoTextFiels(String value, String textField) {
        switch ((textField)) {
            case "username":
                messengerPage.enterEmail(value);
                break;

            case "password":
                messengerPage.enterPassword(value);
        }

    }

    @And("^I click on login button on messenger page$")
    public void clickOnLoginButton() {
        messengerPage.clickOnSignInButton();
    }
    @Then("^I verify invalid login message on sign in page$")
    public void verifySignUpErrorMessenger(){
        Assert.assertEquals(messengerPage.getErrorMessage(),"Incorrect Email");
    }

}