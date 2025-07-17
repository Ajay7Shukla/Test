package StepDefinations;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class AppiumTest {
	
private AppiumDriver driver;
	
	@Before
	public void initialize_driver() {
	    System.out.println("Enter initialize");
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("deviceName", "My Phone");
	    caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome"); // Example: Chrome package
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main"); // Example: Chrome activity
	    try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Given("User open application")
	public void user_open_application() {
		System.out.println("User open application");
		 driver.get("https://www.google.com");
	}

	@When("User search in application  searchQuery {string}")
	public void user_search_in_application_search_query(String query) {
		System.out.println("User open application");
		WebElement searchBar = new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.presenceOfElementLocated(By.name("q"))
        );
        // Enter the search query
        searchBar.sendKeys(query);
        searchBar.sendKeys(Keys.ENTER);
	}


	@Then("User validate Title")
	public void user_validate_title() {
			driver.findElement(By.xpath("//[contains(text(),'Virtusa']"));
	}

}
