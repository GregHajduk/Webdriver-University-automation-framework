package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Login_Steps {
    private WebDriver driver;

    @Before("@login")
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        this.driver = new ChromeDriver(chromeOptions);
        this.driver.manage().window().maximize();
    }

    @After("@login")
    public void tearDown() {
        this.driver.quit();
    }

    @Given("the user accesses the webdriver university login page")
    public void the_user_accesses_the_webdriver_university_login_page() {
        driver.get("http://www.webdriveruniversity.com/Login-Portal/index.html");
    }

    @When("enters valid username {word}")
    public void enters_valid_username(String username) {
        driver.findElement(By.id("text")).sendKeys(username);
    }

    @And("enters valid password {}")
    public void enters_valid_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("clicks on the login button")
    public void clicks_on_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should be presented with the successful login popup message {string}")
    public void user_should_be_presented_with_the_successful_login_popup_message(String validationMessage) {
        String login_Popup_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Popup_Message, validationMessage);
    }
}
