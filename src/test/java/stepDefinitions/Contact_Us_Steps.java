package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ConfigurationsReader;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public class Contact_Us_Steps {

    @Before
    public void setup(){
        Driver.getDriver();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }


    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        Driver.getDriver().get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        Driver.getDriver().findElement(By.xpath("//input[@name='first_name']")).sendKeys("Muhammed");
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        Driver.getDriver().findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys("Turfan");
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        Driver.getDriver().findElement(By.xpath("//input[@name=\"email\"]")).sendKeys( "ms@gmail.com");
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        Driver.getDriver().findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("Hi Elon Musk");
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        Driver.getDriver().findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
    }

    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        Driver.getDriver().findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys(lastName);
    }

    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        Driver.getDriver().findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(email);
    }

    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        Driver.getDriver().findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys(comment);
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        Driver.getDriver().findElement(By.xpath("//input[@value=\"SUBMIT\"]")).click();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement contactUs_Submission_Message = Driver.getDriver().findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Thank You for your Message!");
    }
}
