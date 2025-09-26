package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        WebDriverManager.chromedriver().setup();  // Auto-setup ChromeDriver
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
    }

    @When("I enter valid username {string}")
    public void iEnterValidUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter valid password {string}")
    public void iEnterValidPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I enter invalid username {string}")
    public void iEnterInvalidUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter invalid password {string}")
    public void iEnterInvalidPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I enter empty username")
    public void iEnterEmptyUsername() {
        loginPage.enterUsername("");  // Kosong
    }

    @When("I enter very long username {string}")
    public void iEnterVeryLongUsername(String longUsername) {
        loginPage.enterUsername(longUsername);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("I should see success message containing {string}")
    public void iShouldSeeSuccessMessageContaining(String expectedMessage) {
        String actualMessage = loginPage.getFlashMessage();
        Assert.assertTrue("Success message not found", actualMessage.contains(expectedMessage));
    }

    @Then("I should see error message containing {string}")
    public void iShouldSeeErrorMessageContaining(String expectedMessage) {
        String actualMessage = loginPage.getFlashMessage();
        Assert.assertTrue("Error message not found", actualMessage.contains(expectedMessage));
    }

    // Hook untuk close browser setelah test (opsional, di @After)
    // Cucumber punya @After hook, tapi untuk sederhana, tambahkan di runner jika perlu
}
