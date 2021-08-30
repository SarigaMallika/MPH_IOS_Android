package Stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Signup_negative_scenario extends Generic_functions{
	public static String str;
	public static boolean value;

	/* TC_001 -Validate that the user should get a  validation message  on entering invalid 'first name' and 'last name' */
	@Given("Launch  URL and click on signup")
	public void app_launching() throws Exception {
		try {
			app_launch();
			page_wait(4000);
			click("welcome_signup");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	@When("Enter invalid 'Firstname' and 'Lastname' details")
	public static void enter_invalid_name() throws Exception {
		try {
			click("signup_first_name");
			driver.findElement(By.xpath(OR_reader("signup_first_name"))).sendKeys(td_reader("signup_first_name",0));
			click("signup_last_name");
			str= driver.findElement(By.xpath(OR_reader("signup_firstname_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_firstname_valid_msg"));
			click("signup_page_back");
			click("welcome_signup");
			click("signup_last_name");
			driver.findElement(By.xpath(OR_reader("signup_last_name"))).sendKeys(td_reader("signup_last_name",0));
			click("signup_email_id");
			page_wait(3000);
			str= driver.findElement(By.xpath(OR_reader("signup_lastname_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_lastname_valid_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_invalid_name");
		}
	}

	/* To refresh the page that is currently in use */
	@Then("Verify the validation message")
	public static void signup_negative_validation_msg() throws Exception {
		click("signup_page_back");
		click("welcome_signup");
	}
	/* TC_002 -Validate that the user should get a  validation message  on entering invalid 'Email ID' */
	@When("Enter invalid 'Email ID'")
	public static void enter_invalid_email() throws Exception {
		try {
			click("signup_email_id");
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id",0));
			click("signup_phone_number");
			page_wait(3000);
			str= driver.findElement(By.xpath(OR_reader("signup_emailid_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_email_invalid_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_invalid_email");
		}
	}
	/* TC_003 -Validate that the user should  get a  validation message on leaving 'Email ID' field  blank*/
	@When("Enter 'Email ID' as blank")
	public static void enter_blank_email() throws Exception  {
		try {
			click("signup_email_id");
			click("signup_phone_number");
			page_wait(3000);
			str = driver.findElement(By.xpath(OR_reader("signup_emailid_blank_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_email_blank_msg")); 
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_blank_email");
		}
	}
	/* TC_004 - Validate that the user should get a validation message on entering phone number with less than 10 digits in the 'Phone number' field */
	@When("Enter phone number with less than ten digits")
	public static void invalid_phone_no() throws Exception {
		try {
			page_wait(2000);
			click("signup_phone_number");
			page_wait(2000);
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number",0));
			click("signup_password");
			page_wait(3000);
			str= driver.findElement(By.xpath(OR_reader("signup_phonenumber_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_less_ten_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_invalid_phone_no");
		}
	}
	/* TC_005 - Validate that the user should get a validation message on entering phone number with more than 10 digits in the 'Phone number' field */
	@When("Enter phone number with more than ten digits")
	public static void enter_invalid_phoneno() throws Exception {
		try {
			click("signup_phone_number");
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number",1));
			click("signup_password");
			str= driver.findElement(By.xpath(OR_reader("signup_phonenumber_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_more_ten_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_invalid_phoneno");
		}
	}
	/* TC_006 - Validate that the user should get a validation message on entering already registered phone number  */
	@When("Enter already registered phone number")
	public static void enter_registered_phoneno() throws Exception {
		try {
			page_wait(3000);
			driver.findElement(By.xpath(OR_reader("signup_first_name"))).sendKeys(td_reader("signup_first_name",1));
			driver.findElement(By.xpath(OR_reader( "signup_last_name"))).sendKeys(td_reader("signup_last_name",1));
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id",1));
			driver.findElement(By.xpath(OR_reader( "signup_phone_number"))).sendKeys(td_reader("signup_phone_number",2));
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader( "signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",2));
			click("signup_terms_and_conditions");
			if((platformName.equals("iOS"))){
				click("signup_terms_and_conditions");
			}
			page_wait(5000);
			click("signup");
			page_wait(15000);	
			str= driver.findElement(By.xpath(OR_reader("signup_exist_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_exist_no_msg"));	
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_registered_phoneno");
		}
	}
	/* TC_007 -  Validate that the user should get a validation message  on leaving 'Password' field blank */
	@When("Enter 'Password' as blank")
	public static void enter_blank_password() throws Exception  {
		try {
			click("signup_password");
			click("signup_confirm_password");
			page_wait(3000);
			str = driver.findElement(By.xpath(OR_reader("password_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_pass_blank_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_blank_password");
		}
	}
	/*TC_008 - Validate that the password strength message  and progress bar is displayed while entering password in 'Password' field   */
	@When("Enter password")
	public static void enter_password() throws Exception {
		try {
			click("signup_password");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",0));
			click("signup_confirm_password");
			page_wait(3000);
			str= driver.findElement(By.xpath(OR_reader("passwordstrength_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_pass_stren_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_password");
		}
	}
	/*TC_009 -Validate that the user should get a  validation message on entering different data in 'Password' and 'Confirm Password' fields  */
	@When("Enter password and confirm password data differently")
	public static void enter_different_password() throws Exception  {
		try {
			click("signup_password");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",0));
			click("signup_confirm_password");
			driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",0));
			click("signup_referral_code");
			page_wait(3000);
			str= driver.findElement(By.xpath(OR_reader("passwordmatch_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_pass_match_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_different_password");
		}
	}

	/* TC_010 - Validate the 'Apply' button disabled when Referral code field is blank */
	@When("Referral code is blank")
	public static void referral_code_blank() throws Exception {
		try {
			str = driver.findElement(By.xpath(OR_reader("signup_referral_code"))).getText();
			if(str.equalsIgnoreCase("")) {
				Assert.assertTrue("Referral code field is blank", true);
			}
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_referral_code_blank");
		}
	}
	@Then("Verify that the Apply button is disabled")
	public static void apply_button_disabled() throws Exception {
		try {
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_apply_button"))).isEnabled(),true);
			signup_negative_validation_msg();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_apply_button_disabled");
		}
	}	

	/* TC_011 - Validate that the user should get a  validation message on entering invalid referral code */
	@When("Enter invalid referral code")
	public static void Enter_invalid_referral_code() throws Exception {
		try {
			page_wait(1000);
			click("signup_referral_code");
			driver.findElement(By.xpath(OR_reader("signup_referral_code"))).sendKeys(td_reader("signup_referral_code",0));
			click("signup_apply_button");
			click("signup_apply_button");			
			page_explicit_wait("signup_referral_code_invalid_msg",5000);
			str= driver.findElement(By.xpath(OR_reader("signup_referral_code_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_referral_code_invalid_msg"));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_Enter_invalid_referral_code");
		}
	}	

	/*TC_012 -  Validate that the 'Sign Up' button is disabled  when 'Terms & Conditions' is unchecked   */
	@When("Check box is unchecked")
	public static void check_box_unchecked() throws Exception  {
		try {
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_terms_and_conditions"))).isSelected(),false);
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup"))).isEnabled(),true);
			close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_check_box_unchecked");
		}		
	}
}	