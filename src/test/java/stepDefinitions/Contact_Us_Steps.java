package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Base_PO;

public class Contact_Us_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        navigateToURL("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(generateRandomString(15));
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(generateRandomString(15));
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(generateRandomString(15) + "@google.com");
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(generateRandomString(200));
    }

    @When("I enter a specific first name: {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
    }

    @When("I enter a specific last name: {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
    }

    @When("I enter a specific email address: {word}")
    public void i_enter_a_specific_email_address(String emailAddress) {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailAddress);
    }

    @When("I enter a specific comment: {string}")
    public void i_enter_a_specific_comment(String comment) {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }

    @Then("I am presented with a successful contact us submission message")
    public void i_am_presented_with_a_successful_contact_us_submission_message() {
        WebElement contactUs_SubmissionMessage = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_SubmissionMessage.getText(), "Thank You for your Message!");
    }
}
