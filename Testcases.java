package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Testcases {
	
	public ChromeDriver driver;

	
	@Given("Launch the browser and load the url")
	public void launch_the_browser_and_load_the_url() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://login.salesforce.com/");

}
	
	@When("Enter the username as {string}")
	public void enter_the_username_as(String string) {
	    driver.findElement(By.id("username")).sendKeys(string);
	}
	@When("Enter the password as {string}")
	public void enter_the_password_as(String string) {
	    driver.findElement(By.id("password")).sendKeys(string);
	}
	@When("Click on login button")
	public void click_on_login_button() {
	    driver.findElement(By.id("Login")).click();
	}
	@Then("Salesforce home page should be displayed")
	public void salesforce_home_page_should_be_displayed() {
	   WebElement homepage = driver.findElement(By.xpath("(//span[text()='Home'])[3]"));
	   String hom = homepage.getText();
	   System.out.println(hom);
	   if (hom.equalsIgnoreCase("Home")) {
		   System.out.println("Home page is displayed");
		
	} else {
		System.out.println("Home page is not displayed");

	}
	   
	}
	
	@When("Click on toggle button")
	public void click_on_toggle_button() {
	    driver.findElement(By.xpath("//div[@class = 'slds-icon-waffle']")).click();;

	}
	@When("Click on View all")
	public void click_on_view_all() {
	    driver.findElement(By.xpath("(//button[@class = \"slds-button\"])[2]")).click();

	}
	@When("Select Sales from the App Launcher.")
	public void select_sales_from_the_app_launcher() {
		driver.findElement(By.xpath("//p[text()='Manage your sales process with accounts, leads, opportunities, and more']")).click();

	}
	@When("Click on the Opportunity tab")
	public void click_on_the_opportunity_tab() {
		WebElement Opp = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
		  JavascriptExecutor Executer = (JavascriptExecutor) driver;  
		  Executer.executeScript("arguments[0].click();", Opp);
	}
	@When("Click on the New button.")
	public void click_on_the_new_button() {
	    driver.findElement(By.xpath("//div[@title ='New']")).click();

	}
	@Then("New Opportunity page should be displayed")
	public void new_opportunity_page_should_be_displayed() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("line 24");
			e.printStackTrace();
		}
		WebElement opp = driver.findElement(By.xpath("//span[text()='Opportunity Information']"));
		String OI = opp.getText();
		System.out.println(OI);
		if (OI.equalsIgnoreCase("Opportunity Information")) {
			
			System.out.println("New Opportunity page is displayed");
			
		} else {
			System.out.println("New Opportunity page is not displayed");
		}
		
		
	}
	@When("Enter the Opportunity name as {string}.")
	public void enter_the_opportunity_name_as(String string) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(string);

	}
	@When("Enter Amount as {double}")
	public void enter_amount_as(Double double1) {
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys("75,000");

	}
	@When("Choose the close date as Today.")
	public void choose_the_close_date_as_today() {

		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//button[@name='today']")).click();
	}
	@When("Select Stage as Need Analysis.")
	public void select_stage_as_need_analysis() {
		driver.findElement(By.xpath("//button[@aria-required='true']")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
	}
	@When("Click on the Save button and verify the Opportunity Name.")
	public void click_on_the_save_button_and_verify_the_opportunity_name() {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

	}
	@Then("Opportunity name should be displayed")
	public void opportunity_name_should_be_displayed() {
		WebElement Sfpage = driver.findElement(By.xpath("//span[@value='NewTask']"));
		String text = Sfpage.getText();
		System.out.println(text);
		if (text.equalsIgnoreCase("New Task")) {
			System.out.println("Opportunity created");
		} else {
			System.out.println("Opportunity not created");
		}
		
	}

		
}