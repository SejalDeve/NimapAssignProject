package StepDefinition;


	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.When;
	import io.cucumber.java.en.Then;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;

	public class LoginStepDefinition {
	    WebDriver driver = new ChromeDriver();

	    @Given("I navigate to the login page")
	    public void navigateToLoginPage() {
	        driver.get("https://testffc.nimapinfotech.com/");
	    }

	    @When("I enter valid username {string} and password {string}")
	    public void enterLoginCredentials(String username, String password) {
	        WebElement usernameField = driver.findElement(By.id("username"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.id("loginButton"));
	        
	        usernameField.sendKeys(username);
	        passwordField.sendKeys(password);
	        loginButton.click();
	    }

	    @Then("I should be logged in successfully")
	    public void validateLogin() {
	        WebElement dashboardElement = driver.findElement(By.id("dashboard"));
	        Assert.assertTrue(dashboardElement.isDisplayed(), "Login Failed");
	    }

	    @Given("I am logged in")
	    public void alreadyLoggedIn() {
	        // Perform login steps or reuse steps from the previous method
	        navigateToLoginPage();
	        enterLoginCredentials("sejalgd2019@gmail.com", "Betafield@456");
	        validateLogin();
	    }

	    @When("I perform PunchIn")
	    public void performPunchIn() {
	        WebElement punchInButton = driver.findElement(By.id("punchInButton"));
	        punchInButton.click();
	    }

	    @Then("I should see a toast message {string}")
	    public void validateToastMessage(String expectedMessage) {
	        Alert alert = driver.switchTo().alert();
	        String actualMessage = alert.getText();
	        Assert.assertEquals(actualMessage, expectedMessage, "Toast message mismatch");
	        alert.accept();
	    }

	    @When("I add a customer with name {string} and email {string}")
	    public void addCustomer(String customerName, String customerEmail) {
	        WebElement addCustomerButton = driver.findElement(By.id("addCustomerButton"));
	        WebElement nameField = driver.findElement(By.id("customerName"));
	        WebElement emailField = driver.findElement(By.id("customerEmail"));
	        WebElement submitButton = driver.findElement(By.id("submitButton"));

	        addCustomerButton.click();
	        nameField.sendKeys();
	        emailField.sendKeys(customerEmail);
	        submitButton.click();
	    }

	    @Then("the customer should be added successfully")
	    public void validateCustomerAddition() {
	        WebElement successMessage = driver.findElement(By.id("successMessage"));
	        Assert.assertTrue(successMessage.isDisplayed(), "Customer not added successfully");
	    }
	}


