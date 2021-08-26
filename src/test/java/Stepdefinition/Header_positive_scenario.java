package Stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Header_positive_scenario extends Generic_functions{
	static boolean value;
	String text,context_app;

	/*TC_001_Validate that the mpowered health logo/hamburger in the header*/
	@Given("Launch URL")
	public void launch_URL() throws Exception {
		try {
			app_launch();
			driver.resetApp();
			page_wait(4000);
			value = driver.findElement(By.xpath(OR_reader( "welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("launch_URL");
		}
	}
	@When("Navigated to the 'Header' page")
	public void navigated_header_page() throws Exception {
		try {
			login(0,0);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("navigated_header_page");
		}
	}	
	@Then("Verify hamburger in the header")
	public void header_positive_tc_001() throws Exception {
		try {
			page_wait(9000);
			page_explicit_wait("home",6000);
			value = driver.findElement(By.xpath(OR_reader("hamburger"))).isDisplayed();
			Assert.assertEquals(true, value);
		} catch (Exception e){
			e.printStackTrace();
			takeScreenShot("header_positive_tc_001");
		}
	}

	/*TC_002_Validation of the Drop down tab */
	@Given("Click on Drop down or  hamburger tab")
	public void click_DropDown_Hamburger() throws Exception {
		try {         
			page_wait(5000);
			click("hamburger");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("click_DropDown_Hamburger");
		}
	}
	@Then("Verify the drop down options")
	public void verify_dropdown_options() throws Exception {
		value=driver.findElement(By.xpath(OR_reader("header_profile"))).isDisplayed();
		Assert.assertEquals(true,value);
	}

	/* TC_003_Validate profile page on clicking  Your profile tab*/
	@When("click on  Your profile")
	public void click_your_profile() throws Exception {	
		click("header_profile");
		page_wait(7000);
	}
	@Then("Verify the profile page")
	public void verify_profile_page() throws Exception {
		try{
			value=driver.findElement(By.xpath(OR_reader("header_profile_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("back_button");
			}
		catch (Exception e){
			e.printStackTrace();
			takeScreenShot("verify_profile_page");
		}
	}

	/* TC_004_Validate  Your ratings dashboard */
	@When("click on  Your ratings")
	public void click_your_ratings() throws Exception {
		page_wait(3000);
		click("header_rating");
	}
	@Then("Verify the ratings dashboard page.")
	public void verify_Ratings_dashboard() throws Exception {
		try{
			value=driver.findElement(By.xpath(OR_reader("header_rating_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(2000);
			click("back_button");
			}
		catch (Exception e){
			e.printStackTrace();
			takeScreenShot("verify_Ratings_dashboard");
		}
	}

	/*TC_005_Validate the alerts page */
	@When("Click on Your alerts icon")
	public void click_alerts_icon() throws Exception {
		page_wait(3000);
		click("header_alert");
	}
	@Then("Verify the alerts page")
	public void verify_alerts_Page() throws Exception {
		try {
			page_wait(2000);
			value = driver.findElement(By.xpath(OR_reader("header_alert_title"))).isDisplayed();
			Assert.assertEquals(value,true);
			click("back_button");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_005");
		}
	}

	/*TC_006_Validate Help or FAQ  page*/
	@When("click on Help icon")
	public void click_help_icon() throws Exception {
		page_wait(3000);
		click("header_FAQ");
	}
	@Then("Verify  the help or FAQ page")
	public void TC_007_Validate_Help_or_FAQ_page() throws Exception {
		try {
			page_wait(2000);
			value = driver.findElement(By.xpath(OR_reader("header_FAQ_title"))).isDisplayed();
			Assert.assertEquals(value,true);
			click("back_button");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_007");
		}
	}

	/*TC_007_Validate the Contact Us page*/
	@When("click on  Contact Us")
	public void click_contact_us() throws Exception {
		page_wait(3000);
		click("header_contact_us");
		page_wait(7000);
	}
	@Then("Verify  Contact Us page")
	public void verify_contact_us() throws Exception {
		try {
			page_explicit_wait("header_contact_fname",4000);
			value = driver.findElement(By.xpath(OR_reader("header_contact_fname"))).isDisplayed();
			Assert.assertEquals(value,true);
			page_wait(2000);
			driver.findElement(By.xpath(OR_reader("header_contact_fname"))).sendKeys(td_reader("header_contact_fname"));
			page_wait(2000);
			driver.findElement(By.xpath(OR_reader("header_contact_lname"))).sendKeys(td_reader("header_contact_lname"));
			page_wait(2000);
			driver.findElement(By.xpath(OR_reader("header_contact_email"))).sendKeys(td_reader("header_contact_email"));
			page_wait(2000);
			Actions builder=new Actions(driver);
			builder.click(driver.findElement(By.xpath(OR_reader("header_contactus_feedback")))).build().perform();
			builder.sendKeys(td_reader("header_contactus_feedback")).build().perform();
			page_wait(2000);
			builder.click(driver.findElement(By.xpath(OR_reader("header_contactus_submit")))).build().perform();
			page_wait(9000);
			if((platformName.equals("Android"))){
				page_back();
			}
			else {
			app_launch();
			page_wait(6000);
			click("welcome_login");
			page_wait(6000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("verify_contact_us");
		}
	}

	/*TC_008_Validate  Privacy Policy dialogue box on clicking on the Privacy Policy*/
	@When("click on  Privacy Policy")
	public void click_privacy_policy() throws Exception {
		page_wait(3000);
		click("header_privacy_policy");
	}
	@Then("Verify the dialogue box")
	public void verify_dialogue_box() throws Exception {
		try {
			page_wait(8000);
			value = driver.findElement(By.xpath(OR_reader("header_privacy_ok"))).isDisplayed();
			Assert.assertEquals(value,true);
			click("header_privacy_ok");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_009");
		}
	}

	/*TC_009_Validate Terms & Conditions dialogue box on clicking on the Terms & Conditions*/
	@When("click on  Terms & Conditions")
	public void click_terms_conditions() throws Exception {
		page_wait(3000);
		click("header_terms_conditions");
		page_wait(9000);
	}
	@Then("Verify the  dialogue box on terms and conditions page")
	public void verify_terms_conditions() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("header_terms_conditions_ok"))).isDisplayed();
			Assert.assertEquals(value,true);
			click("header_terms_conditions_ok");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_010");
		}
	}

	/*TC_010_Validate that the user is navigated to the Feedback Port   page  on clicking Feedback*/
	@When("click on  Feedback")
	public void click_feedback() throws Exception {
		if((platformName.equals("Android"))){
			page_wait(3000);
			click("header_feedback");
			page_wait(9000);
		}
		else {
			click_DropDown_Hamburger();	
			page_wait(1000);
			click("header_feedback");
		}		
	}
	@And("Verify the Feedback Port.")
	public void verify_feedback_port() throws Exception {
		try {
			page_wait(20000);
			driver.findElement(By.xpath(OR_reader("header_feedback_your_feedback"))).sendKeys(td_reader("header_feedback_your_feedback"));
			driver.findElement(By.xpath(OR_reader("header_feedback_more_detail"))).sendKeys(td_reader("header_feedback_more_detail"));
			page_wait(4000);
			driver.findElement(By.xpath(OR_reader("header_feedback_email"))).sendKeys(td_reader("header_feedback_email"));
			page_wait(9000);
			click("header_feedback_share");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_010");
		}
	}
	@Then("Verify the thank you message")
	public void verify_thankYou_message() throws Exception {
		try{
			page_wait(10000);
			value = driver.findElement(By.xpath(OR_reader("header_feedback_thankyou"))).isDisplayed();
			Assert.assertEquals(value,true);
			if((platformName.equals("Android"))){
				page_back();
				page_back();
			}
			else {
			app_launch();
			page_wait(3000);
			click("welcome_login");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			takeScreenShot("verify_thankYou_message");
		}
	}

	/*TC_011_Validate the Landing page on clicking Log out icon*/
	@When("click on Log out icon")
	public void click_logOut() throws Exception {
		try {
			if((platformName.equals("Android"))){
				page_wait(5000);
				click("logout");
			}
			else {
				page_wait(4000);
				click("hamburger");
				click("logout");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			takeScreenShot("verify_thankYou_message");
		}
	}
	@Then("Verify navigation to the Landing  page")
	public void verify_landing_page() throws Exception {
		value=driver.findElement(By.xpath(OR_reader("welcome_page_title"))).isDisplayed();
		Assert.assertEquals(true,value);
		close();
		
	}
}
