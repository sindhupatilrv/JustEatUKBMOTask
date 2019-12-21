package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Sindhu Patil R.V 
 * Before running this software user suppose to install Chrome software which is most updated one
 *
 */
public class JustEatUK_stepdefinition {
	
	public static WebDriver driver;
	public static String url = "https://www.just-eat.co.uk/";
	//public static String ChromeDriverPath = "C:\\Users\\sindhuganesh\\Downloads\\chromedriver_win32_79\\chromedriver.exe" ;
	public static String ChromeDriverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver_win32_79\\chromedriver.exe";
	
    static String expectedTitle = "Order takeaway online from 30,000+ food delivery restaurants | Just Eat";
    static String actualTitle;
    public WebElement form;
    
	@Given("^launch Justeat url$")
	public void launch_Justeat_url() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(200);
		driver.get(url);    
	}

	@When("^Verify the home Page$")
	public void verify_the_home_Page() throws Throwable {
		actualTitle  = driver.getTitle();
		
			if (actualTitle.contentEquals(expectedTitle)){
	            System.out.println("Just Eat Home is displayed");
	        } else {
	            System.out.println("Failed -Just Eat url is failed to navigate to Homepage ");
	        }       
	}
	
	@Given("^I want food in \"([^\"]*)\"$")
	public void i_want_food_in(String postalcode) throws Throwable {
		driver.findElement(By.name("postcode")).sendKeys(postalcode);
	}

	@When("^I search for restaurants$")
	public void i_search_for_restaurants() throws Throwable {
	    driver.findElement(By.xpath("//button[@type =\"submit\"]")).click();
	}

	@Then("^I should see some restaurants in \"([^\"]*)\"$")
	public void i_should_see_some_restaurants_in(String postalcode) throws Throwable {
		String orderpageexp = "Popular cuisines";
		String orderpage = driver.findElement(By.xpath("//p[contains(text(), 'Popular cuisines')]")).getText();
		System.out.println(orderpage);
		if (orderpage.contentEquals(orderpageexp)){
		            System.out.println(postalcode + "relavant restaurants are displayed on Just Eat Website");
		  } else {
			  System.out.println("Sorry no restaurants are present in " + postalcode + "area");
		}  
	}
	
	@Given("^Filter the Pizzas on top$")
	public void filter_the_Pizzas_on_top() throws Throwable {
		driver.findElement(By.xpath("//label[@class ='o-formToggle-text' and "
				+ "@title = 'Pizza' and @data-test-id = 'cuisine_name' "
				+ "and @for = 'pizza-desktop-tile']")).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}

	@When("^Click on any top listed Restaurant$")
	public void click_on_any_top_listed_Restaurant() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); 
		driver.findElement(By.xpath("//h3[contains(text(), \"Eng - Android - Test Restaurant (Collection Only)\")]")).click();
	}

	@Then("^Add Pizza Deal to inbox$")
	public void add_Pizza_Deal_to_inbox() throws Throwable {
		//scroll down
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,400)");
		driver.findElement(By.xpath("//form[@data-product-id = '20181104']")).click();
	}

	@Then("^Select Pizza Deal$")
	public void select_Pizza_Deal() throws Throwable {	
		//NOT covering the test script 
	}

	@Then("^Select Skip Extras$")
	public void select_Skip_Extras() throws Throwable {
		//NOT covering the test script 
	}

	@Then("^Select option$")
	public void select_option() throws Throwable {
		//NOT covering the test script 
	}

	@Then("^Select some snacks$")
	public void select_some_snacks() throws Throwable {
		//NOT covering the test script 
	}

	@Then("^Add to Basket$")
	public void add_to_Basket() throws Throwable {
		//NOT covering the test script 
	}

	@Then("^Click on Checkout$")
	public void click_on_Checkout() throws Throwable {
		//NOT covering the test script 
	}

	@Then("^Close the driver$")
	public void Close_the_driver() throws Throwable {
	   
	  driver.close();
	  driver.quit();
	}


}
