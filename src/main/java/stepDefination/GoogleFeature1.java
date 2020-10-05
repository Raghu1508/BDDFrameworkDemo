package stepDefination;



import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleFeature1 {

	static WebDriver driver;

@Given("Launch Chrome Browser")
public void launch_chrome_browser() {
	
	WebDriverManager.chromedriver().setup();
	//System.setProperty("webdriver.chrome.driver","D:\\Personal\\Selenium\\chromedriver_win321\\chromedriver.exe");

    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
}

@When("Navigate to Google")
public void navigate_to_google() throws InterruptedException {
    driver.navigate().to("https://www.google.com");
    Thread.sleep(5000);
}

@And("Search for facebook")
public void search_for_facebook() {

	driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).click();
	driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Facebook");
	driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.RETURN);
	
}

@Then("Result displays facebook")
public void result_displays_facebook() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'www.facebook.com')]")));
    
    String str = driver.findElement(By.xpath("//*[contains(text(),'www.facebook.com')]")).getText();
    
   
    
    assertEquals("Did not match ", "www.facebook.com/",str);   
    
    
    driver.quit();
}

	
	
}
