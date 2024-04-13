package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import testdata.JsonDataReader;

import java.io.IOException;

import static stepdefinitions.Hooks.driver;

public class SD_AddToCart {

    HomePage homePage = new HomePage(driver);
    JsonDataReader Reader = new JsonDataReader();
    LoginPage loginPage = new LoginPage(driver);

    SoftAssert soft = new SoftAssert();

    @Given("user go to eshop home page")
    public void user_go_to_eshop_home_page() {
    }

    @When("user login to his account")
    public void user_login_to_his_account() throws IOException, ParseException, InterruptedException {
        homePage.navigateToLoginPage();
        Reader.jsonReader();
        loginPage.login(Reader.username, Reader.password);
    }

    @When("user add first item from homepage to the cart")
    public void userAddFirstItemFromHomepageToTheCart() {
        homePage.addFirstItemToTheCart();
    }

    @When("navigate to the home page")
    public void navigateToTheHomePage() {
        homePage.goBackToHomePage();
    }

    @When("user add second item from homepage to the cart")
    public void userAddSecondItemFromHomepageToTheCart() throws InterruptedException {
        homePage.addSecondItemToTheCart();
    }


    @When("user search for a Third item")
    public void userSearchForAThirdItem() throws IOException, ParseException, InterruptedException {
        homePage.searchForThirdItem();
    }

    @When("add it to the cart")
    public void AddItToTheCart() throws InterruptedException {
        homePage.addThirdItemToTheCart();
    }

    @When("go to his cart")
    public void goToHisCart() throws InterruptedException {
        homePage.goToCart();
    }

    @Then("user will find all three items he added in his cart")
    public void userWillFindAllThreeItemsHeAddedInHisCart() {
        soft.assertTrue(homePage.isFirstItemDisplayed());
        soft.assertTrue(homePage.isSecondItemDisplayed());
        soft.assertTrue(homePage.isThirdItemDisplayed());
        soft.assertAll();
    }
}
