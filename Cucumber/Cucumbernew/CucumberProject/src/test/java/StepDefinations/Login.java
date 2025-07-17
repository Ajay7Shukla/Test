package StepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import static org.testng.Assert.assertEquals;
import java.time.Duration;

public class Login {
	
	private WebDriver driver;
	
	@Before
	public void initialize_driver() {
	    System.out.println("Enter initialize");
		ChromeOptions options = new ChromeOptions();
		// Set the path of ChromeDriver
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashukla1\\Desktop\\AjayCucumber\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--ignore-ssl-errors=yes");
		options.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		System.out.println("User is on login page");
		driver.get("https://mail.google.com/");
      	driver.manage().window().maximize();
	}

	@When("User enter valid username {string} and password {string}")
	public void user_enter_valid_username_and_password(String username, String password) {
		System.out.println("Enter valid credentials");
		WebElement emailField = driver.findElement(By.id("identifierId"));
        emailField.sendKeys(username);
        WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
        nextButton.click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));
        
        WebElement passwordField = driver.findElement(By.name("Passwd"));
        passwordField.sendKeys(password);
        
        
	}

	@When("click submit button")
	public void click_submit_button() {
		System.out.println("Click Submit button");
		WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
		nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
        nextButton.click();
		
	}

	@Then("User is able to successfully login")
	public void user_is_able_to_successfully_login() {
		System.out.println("Login validations");
		String actualTitle = driver.getTitle();
        String expectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
        assertEquals(actualTitle, expectedTitle, "Page title does not match the expected value");
	}
	
	@After
	public void closeBrowser() {
		System.out.println("Exit browser");
        driver.quit();
    }


}
