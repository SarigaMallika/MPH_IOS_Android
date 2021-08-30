package Stepdefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;

import Reusable_Functions.Generic_functions;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Signup_positive_scenario extends Generic_functions{
	public static boolean value1,value2;
	private static Scenario scenario1;
	static String str;
	
	@Before
	 public void before(Scenario scenario) {
	               this.scenario1 = scenario;
	 }

	/*TC_001 - Validate that the app is open and user clicks on the Signup button and navigates to Signup page*/
	@Given("Launch the URL and click on signup")
	public static void launch_url() throws Exception {
		try {
			app_launch();
			page_wait(3000);
			click("welcome_signup");			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Then("Navigated to signup page")
	public static void navigate_signup_page() throws Exception  {
		try {
			value1=driver.findElement(By.xpath(OR_reader("signup_page_title"))).isDisplayed();
			Assert.assertEquals(true,value1);
			value1= driver.findElement(By.xpath(OR_reader("mph_logo"))).isEnabled();
			Assert.assertEquals(value1,true);
		} catch (Exception e) {
			e.printStackTrace();	
			takeScreenShot("signup_positive_navigate_signup_page");
		}
	}
	
	/*TC_002 Verify clicking on login link will navigate to login page*/
	@When("Clicks on the 'Login' link")
	public static void click_on_login_link() throws Exception{
		try{
			page_wait(3000);
			click("login_link");	
			if (platformName.equals("iOS")) {
				page_wait(2000);						
				click("continue");
				page_wait(3000);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_click_on_login_link");
		}
	}
	@Then("Navigates to the login page")
	public static void navigate_to_login() throws Exception{
		try{
			page_wait(6000);
			str= driver.findElement(By.xpath(OR_reader("login_page_title"))).getText();
//			Assert.assertEquals(str,td_reader("login_page_title"));
			if((platformName.equals("iOS"))){
				click("login_cancel_btn");
			}
			page_back();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_navigate_to_login");
		}
	}
	
	/* TC_003 - Validate that the data entered in both Password and Confirm password fields are masked */
	@When("Enter details in the 'Password' and 'Confirmed Password' field should be masked")
	public void enter_password() throws Exception {
		try {		
			click("signup_password");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader( "signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",2));
			page_wait(1000);
			value1=driver.findElement(By.xpath(OR_reader( "signup_password"))).isDisplayed();
			value2=driver.findElement(By.xpath(OR_reader( "signup_confirm_password"))).isDisplayed();
			Assert.assertEquals(true,value1);
			Assert.assertEquals(true,value2);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_enter_password");
		}
	}

	/* TC_004 - Validate that the password should be displayed on an eye click for Password fields*/
	@When("Clicks on the Eye")
	public void click_on_show_password() throws Exception {
		try {
			click("signup_page_back");
			page_wait(3000);
			click("welcome_signup");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			page_wait(3000);
			click("signup_show_password");
			if((platformName.equals("iOS"))){
				click("signup_show_password");
			}
			else {
				page_wait(2000);
			}					
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_click_on_show_password");
		}
	}	
	@Then("Orginal value should be displayed in the password fields")
	public static void display_value() throws Exception  {
		try {
			page_wait(3000);
			value1=driver.findElement(By.xpath(OR_reader( "signup_show_password"))).isDisplayed();
			Assert.assertEquals(true,value1);
		} catch (Exception e) {
			e.printStackTrace();	
			takeScreenShot("signup_positive_display_value");
		}
	}

	/* TC_005 - Validate the Confirm password field by comparing data entered in the Password field */ 
	@When("Enter same values of 'Password' in the 'Confirmed Password' field")
	public void enter_valid_password() throws Exception {
		try {
			click("signup_page_back");
			page_wait(3000);
			click("welcome_signup");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",2));
			value1=driver.findElement(By.xpath(OR_reader( "signup_password"))).isDisplayed();
			value2=driver.findElement(By.xpath(OR_reader( "signup_confirm_password"))).isDisplayed();
			Assert.assertEquals(true,value1);
			Assert.assertEquals(true,value2);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_enter_valid_password");
		}
	}

	/* TC_006 -  Validate user is able to click on Sign Up with valid credentials */
	@When("Enter valid credentials and apply link should be enabled after adding referral code")
	public void enter_valid_cred() throws Exception {
		try {
			click("signup_page_back");
			page_wait(3000);
			click("welcome_signup");
			driver.findElement(By.xpath(OR_reader("signup_first_name"))).sendKeys(td_reader("signup_first_name",1));
			driver.findElement(By.xpath(OR_reader("signup_last_name"))).sendKeys(td_reader("signup_last_name",1));
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id",1));
			if(scenario1.getId().contains("Signup_positive")) {
				phone_number("signup_phone_number","signup_phone_number", 3);
			}
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader( "signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",2));
			driver.findElement(By.xpath(OR_reader("signup_referral_code"))).sendKeys(td_reader("signup_referral_code",1));				
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_enter_valid_cred");
		}
	}	
	@Then("After Click on Apply, validation message is displayed")
	public void verify_OTP_page() throws Exception {
		try {
			click("signup_apply_button");			
			if((platformName.equals("iOS"))){
				click("signup_apply_button");
				click("signup_terms_and_conditions");
			}
			page_wait(5000);
			str= driver.findElement(By.xpath(OR_reader("signup_referral_text"))).getText();
			Assert.assertEquals(str,td_reader("signup_referral_text"));
			click("signup");		
			}
		catch (Exception e){
			e.printStackTrace();
			takeScreenShot("signup_positive_verify_OTP_page");
		}
	}

	/* Tc_007 - Verify the scenario when navigate to the otp Login page */
	@Given("Click on Resend otp and user will get the validation message")
	public void enter_otp() throws Exception {
		try {
			value1 = driver.findElement(By.xpath(OR_reader("otp_title"))).isDisplayed();
			Assert.assertEquals(true, value1);
			click("resend_otp");
			page_wait(5000);
			value1=driver.findElement(By.xpath(OR_reader("otp_verify"))).isDisplayed();
			Assert.assertEquals(true,value1);				
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_click_on_resend_otp");
		}		
	}
	@When("Enter the four digit verification code")
	public static void enter_the_four_digit_verification_code() throws Exception {
		try {
			page_wait(7000);
			driver.findElement(By.xpath(OR_reader("otp_1"))).sendKeys(td_reader("otp_1"));
			driver.findElement(By.xpath(OR_reader("otp_2"))).sendKeys(td_reader("otp_2"));
			driver.findElement(By.xpath(OR_reader("otp_3"))).sendKeys(td_reader("otp_3"));
			driver.findElement(By.xpath(OR_reader("otp_4"))).sendKeys(td_reader("otp_4"));	
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_enter_the_four_digit_verification_code");
		}		
	}
	@Then("Click on verify button")
	public void click_verify() throws Exception, InterruptedException {
		try {
			page_wait(5000);
			click("verify");
			page_wait(1000);
			value1=driver.findElement(By.xpath(OR_reader( "welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value1);
//			close();
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_click_verify");
		}		
	}
	
}