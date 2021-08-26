package Stepdefinition;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Award_points_negative_scenarios extends Generic_functions{
	public static boolean value;
	static WebElement ele;
	String ere;
	public static WebElement fr;
	static String str,text;
	static List<WebElement> grid_elements,drp_list;

	// TC_001-Validate that the user is navigated to Welcome page	
	@Given("user on home page")
	public void launchTheURL() throws Exception {
		try {
			app_launch();
			page_wait(2000);
			login(3,0);
			page_wait(7000);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_001");
		}	
	}
	@When("Navigated to home page")
	public void Award_points_negative_tc_001() throws Exception {
		try {
			page_wait(10000);
			page_explicit_wait("home",6000);
			value = driver.findElement(By.xpath(OR_reader("home"))).isDisplayed();
			Assert.assertEquals(true, value);
			click("home");
			page_wait(3000);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_001");
		}
	}

	@And("Click on Utilities tab and Award points tab")
	public static void click_utilities() throws Exception{
		try {
			click("utilities");		
			page_wait(3000);
			click("utilities_awardpoints");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_001");
		}
	}

	@Then("validate Award points page")
	public void click_award_points() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("utilities_awardpoints_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_001");
		}
	}

	// TC 001 - Verify the validation message on entering amount more than the available amount in "Redeem Award Points" page
	@Given("Click on redeem points button")
	public void click_redeem_points() throws Exception {
		try {
			page_wait(3000);
			click("awardpoints_redeeem_points_button");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_002");
		}
	}
	@When("Enter the amount more than available amount")
	public void greater_amount() throws Exception, InterruptedException {
		try{
			if((platformName.equals("Android"))){
				click("redeem_points_giftcard");
				text = td_reader("redeem_points_giftcard");
				scrolldown(text);
			}
			else {
				click("redeem_points_giftcard");
				driver.findElement(By.className("XCUIElementTypePickerWheel")).sendKeys(td_reader("redeem_points_giftcard"));
				page_wait(1000);
				click("dropdown_done");
			}
			page_wait(5000);
			click("redeem_points_amount");
			driver.findElement(By.xpath(OR_reader("redeem_points_amount"))).sendKeys(td_reader("redeem_points_amount",1));
			page_wait(2000);
			click("redeem_points_emailid");
			
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_002");
		}
	}

	@Then("Validate the message on award points page")
	public void Award_point_negative() throws Exception {
		try{
			page_wait(3000);
			str= driver.findElement(By.xpath(OR_reader("redeempoints_amount_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("redeempoints_amount_exceed_invalid_msg"));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_002");
		}
	}


	//TC 003 - Validate the validation message on entering amount less than the available amount in "Redeem Award Points" page
	@When("Enter the amount less than the available amount")
	public void lesser_Amount() throws Exception {
		try{
			field_clear("redeem_points_amount");
			click("redeem_points_amount");
			driver.findElement(By.xpath(OR_reader("redeem_points_amount"))).sendKeys(td_reader("redeem_points_amount",2));
			page_wait(2000);
			click("redeem_points_emailid");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_003");
		}
	}

	@Then("Validate the message on award points page on less amount")
	public void Award_point_negative_tc_002() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("redeempoints_amount_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("redeempoints_amount_less_invalid_msg"));
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_003");
		}
	}


	/*TC 004 -  Validate that user is not able to click on the 'Redeem' button on leaving the field 'Select a gift card' blank" */
	@When("Click the Redeem button on leaving the field Select a gift card blank")
	public void redeemButton_giftcardblank() throws Exception {
		try{
//			click("utilities");
//			click("utilities_award_points");
//			click("awardpoints_redeem_button");
//			value=driver.findElement(By.xpath(OR_reader("redeem_points"))).isEnabled();
//			Assert.assertEquals(value,true);
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_004");
		}
	}
	@Then("Validate the error message displayed")
	public static void Award_point_negative_tc_003() throws Exception, InterruptedException {
		try {
//			value=driver.findElement(By.xpath(OR_reader( "redeem_points"))).isEnabled();
//			Assert.assertEquals(value,false);
//			page_wait(1000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_004");
		}
	}


	/*TC 005 -  Validate that user is not able to click on the 'Redeem' button on leaving the field 'Enter Amount' blank on "Redeem Award Points" page */
	@When("Click on the Redeem button on leaving the field Enter Amount blank")
	public static void blank_amount_redeem_button() throws Exception{
		try {
//			click("utilities");
//			click("utilities_award_points");
//			click("awardpoints_redeem_button");
//			value=driver.findElement(By.xpath(OR_reader("redeem_points"))).isEnabled();
//			Assert.assertEquals(value,true);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_005");
		}
	}

	@Then("Validate the message displayed")
	public void Award_point_negative_tc_004() throws Exception {
		try{
//			click("redeem_points_giftcard");
//			text = td_reader("redeem_points_giftcard");
//			scrolldown(text);
//			value=driver.findElement(By.xpath(OR_reader("redeem_points"))).isEnabled();
//			Assert.assertEquals(value,true);
//			click("home");
//			page_wait(5);
//			click("hamburger");
//			click("logout");
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_005");
		}
		close();
	}
}
