package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public class Login_Steps {

    @Before("@login")
    public void setup() {
        Driver.getDriver();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);


    }
    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        Driver.getDriver().get("https://www.webdriveruniversity.com/Login-Portal/index.html?");
    }

    @When("I enter a username {}")
    public void i_enter_a_username(String username) {
        Driver.getDriver().findElement(By.id("text")).sendKeys(username);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        Driver.getDriver().findElement(By.id("password")).sendKeys(password);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        Driver.getDriver().findElement(By.id("login-button")).click();
    }

    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() {
        String login_Message = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(login_Message, "validation succeeded");
        Driver.getDriver().switchTo().alert().accept();
    }

    @Then("I should be presented with the unsuccessful login message")
    public void i_should_be_presented_with_the_unsuccessful_login_message() {
        String login_Message = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(login_Message, "validation failed");
        Driver.getDriver().switchTo().alert().accept();
    }

    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) {
        String login_Message = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(login_Message, expectedMessage);
        Driver.getDriver().switchTo().alert().accept();
    }
}
