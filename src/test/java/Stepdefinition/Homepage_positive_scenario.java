package Stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Homepage_positive_scenario extends Generic_functions {
	public static boolean value,value1,str,str1;
	WebElement ele;
	String ere;
	
	/*TC_001 -Validate that the user is navigated to Welcome page*/
	@Given("Welcome page is available")
	public static void browser_is_open() {
		try {
			app_launch();
			page_wait(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	@When("Click on 'Welcome Login' button")
    public static void home_positive_tc_001() throws Exception {
//		click("welcome_login");
//		click("continue");
//		page_wait(8000);
		login(0,0);
	}
	@Then("Verify the Welcome page")
	public static void verify_WelcomePage() throws Exception {
		try {
//			page_wait(8000);
//			value = driver.findElement(By.xpath(OR_reader( "login_title"))).isDisplayed();
//			Assert.assertEquals(true,value);
			page_wait(9000);
			page_explicit_wait("home",6000);
			value = driver.findElement(By.xpath(OR_reader("hamburger"))).isDisplayed();
			Assert.assertEquals(true, value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_verify_WelcomePage");
		}
	}
	
	/*Tc_002- Validate that the user is able to Login with valid credentials*/
	@When("User enters valid phonenumber and password")
	public static void enter_login_details() throws InterruptedException, Exception {
		try {
//			page_wait(7000);
//			click("login_phone_number");
//			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",0));
//			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("login_password",0));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_enter_login_details");
		}
	}
	@Then("click on 'login' button")
	public static void click_on_login() throws InterruptedException, Exception {
//		page_wait(10000);
//		click("login");
//       Thread.sleep(5000);
	}
	/*Tc_003 - Validate that the user is navigated to  the Home page and User should be able to click on all the grid tiles */
	@When("clicks on all the grid tiles")
	public static void clicks_on_all_tiles() throws Exception, InterruptedException {
		try {
    		page_wait(5000);
    		click("homepage_first_tile");						
			page_wait(8000);
			str= driver.findElement(By.xpath(OR_reader("homepage_tabs_title"))).isDisplayed();  
	     	Assert.assertEquals(true,str);	
	     	page_wait(5000);
			click("home");
			page_wait(8000);
			click("homepage_second_tile");
			page_wait(8000);
			str= driver.findElement(By.xpath(OR_reader("homepage_tabs_title"))).isDisplayed();
			Assert.assertEquals(true,str);	
			page_wait(5000);
			click("home");
			page_wait(8000);
			click("homepage_third_tile");
			page_wait(8000);
		   str= driver.findElement(By.xpath(OR_reader("homepage_tabs_title"))).isDisplayed();
		   Assert.assertEquals(true,str);
		   page_wait(5000);
		   click("home");
		   page_wait(5000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_clicks_on_all_tiles");
		}
		
	}
	/*TC_004 -Validate that the user is navigated to the Second Opinion page on clicking 'Request for second opinion' button*/
	@When("clicks on the 'Request for second opinion' button")
	public static void clicks_on_request_second_opinion() throws InterruptedException, Exception {
		try {
			page_wait(9000);
			click("homepage_request_second_opinion_tab");
			page_wait(1000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_clicks_on_request_second_opinion");
		}
	}
	@Then("navigated to the Second opinion page")
	public static void navigate_to_second_opinion_page() throws Exception {
		try {
			str1=driver.findElement(By.xpath(OR_reader( "request_second_opinion_title"))).isDisplayed();
			Assert.assertEquals(true,str1);
			page_wait(1500);
			click("home");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_navigate_to_second_opinion_page");
		}
	}
	/*TC_005-Validate that the user is navigated to the  Refer a friend page on clicking 'Refer a friend' button*/
	@When("clicks on 'Refer a friend' button")
	public static void clicks_on_refer_a_friend() throws InterruptedException, Exception {
		try {
			Thread.sleep(2000);
			click("homepage_refer_a_friend_tab");
			page_wait(1500);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_clicks_on_refer_a_friend");
		}				
	}
	@Then("navigated to the Refer a friend page")
	public static void navigated_to_refer_a_friend_page() throws Exception {
		try {
			value1=driver.findElement(By.xpath(OR_reader("refer_a_friend_title"))).isDisplayed();
			Assert.assertEquals(true,value1);
			page_wait(3000);
			click("home");
			click("hamburger");
			page_wait(2000);
			click("logout");
			close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_navigated_to_refer_a_friend_page");
		}		
	}
}