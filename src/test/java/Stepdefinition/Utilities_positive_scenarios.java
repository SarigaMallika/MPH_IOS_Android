package Stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Utilities_positive_scenarios extends Generic_functions {
	public static boolean value;
	public static String text;

	/* TC_001 -Navigate to Utilities screen*/
	@Given("user is on home page")
	public static void launch_url() throws Exception{
		try {
			app_launch();
			page_wait(2000);
			login(0,0);
			page_wait(6000);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	@When("clicks on Utilities tab")
	public static void click_utilities() throws Exception {
		try {
			page_wait(9000);
			page_explicit_wait("home",6000);
			value = driver.findElement(By.xpath(OR_reader("home"))).isDisplayed();
			Assert.assertEquals(true, value);
			click("home");
			page_wait(3000);
			click("utilities");				
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_001");
		}	
	}
	@Then("Navigate to Utilities Dashboard")
	public static void utilities_positive_tc_001() throws Exception {
		try {
			page_wait(2000);
			value = driver.findElement(By.xpath(OR_reader("utilities_wallet"))).isDisplayed();
			Assert.assertEquals(true, value);			
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_001");
		}	
	}

	/* TC_002 - Verify that click on all the Tiles in the Utilities dashboard*/
	@When("Click all tiles in utilities dashboard")
	public static void utilities_positive_tc_003() throws Exception {
		try {
			page_wait(5000);
			click("utilities_wallet");
			page_wait(6000);
			value = driver.findElement(By.xpath(OR_reader("utilities_add_payment_button"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("utilities_back");
			click("utilities_awardpoints");
			page_wait(3000);
			value = driver.findElement(By.xpath(OR_reader("utilities_awardpoints_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("utilities_back");			 
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_003");
		}	
	}
	@Then("verify navigation to the pages")
	public static void navigation_to_pages() throws Exception {
		try {
			click("utilities_idcard");
			page_wait(3000);
			value = driver.findElement(By.xpath(OR_reader("utilities_ok_button"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(3000);
			click("utilities_ok_button");
			page_wait(3000);
			if((platformName.equals("Android"))){
				click("utilities_settings");
				page_wait(3000);
				value = driver.findElement(By.xpath(OR_reader("utilities_deactivate"))).isDisplayed();
				Assert.assertEquals(true,value);
				page_back();
			}
			click("utilities_upload");
			page_wait(3000);
			value = driver.findElement(By.xpath(OR_reader("utilities_ok_button"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(3000);
			click("utilities_ok_button");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_003");
		}	
	}

	/* TC_004 - Add card details  in the Wallet dashboard*/
	@Given("user is on wallet page")
	public static void user_on_wallet_page() throws Exception {
		page_wait(3000);
		click("utilities_wallet");	 
	}
	@When("Enter card details in wallet dashboard")
	public static void utilities_positive_tc_004() throws Exception {
		try {
			page_wait(3000);
			click("utilities_add_payment_button");
			page_wait(1000);
			click("utilities_add_debit_credit_card");
			driver.findElement(By.xpath(OR_reader("utilities_card_saveas"))).sendKeys(td_reader("utilities_card_saveas"));
			driver.findElement(By.xpath(OR_reader("utilities_card_name"))).sendKeys(td_reader("utilities_card_name"));
			page_wait(1000);
			driver.findElement(By.xpath(OR_reader( "utilities_card_number"))).sendKeys(td_reader("utilities_card_number",0));
			page_wait(1000);
			driver.findElement(By.xpath(OR_reader( "utilities_card_expiry"))).sendKeys(td_reader("utilities_card_expiry",0));
			page_wait(1000);
			driver.findElement(By.xpath(OR_reader("utilities_card_cvc"))).sendKeys(td_reader("utilities_card_cvc",0));
			page_wait(1000);
			driver.findElement(By.xpath(OR_reader("utilities_card_postal_code"))).sendKeys(td_reader("utilities_card_postal_code",0));
			page_wait(1000);
			driver.findElement(By.xpath(OR_reader("utilities_card_phoneno"))).sendKeys(td_reader("utilities_card_phoneno",0));
			driver.findElement(By.xpath(OR_reader( "utilities_card_address1"))).sendKeys(td_reader("utilities_card_address1"));
			driver.findElement(By.xpath(OR_reader("utilities_card_address2"))).sendKeys(td_reader("utilities_card_address2"));
			page_wait(2000);
			click("utilities_card_state");
			if((platformName.equals("Android"))){				
				text = td_reader("utilities_card_state");
				scrolldown(text);
			}
			else {
				scrolldown("utilities_card_state");
			}
			page_wait(3000);
			driver.findElement(By.xpath(OR_reader("utilities_card_city"))).sendKeys(td_reader("utilities_card_city",0));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_004");
		}	
	}
	@Then("Verify card details is saved")
	public static void card_details_save() throws Exception {
		try {
			page_wait(2000);
			click("utilities_card_save");
			if((platformName.equals("iOS"))){	
				click("utilities_card_save");
			}			
			page_explicit_wait("utilities_ok_button",9000);
			click("utilities_ok_button");
			page_wait(9000);
			value = driver.findElement(By.xpath(OR_reader("utilities_card_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_004");
		}
	}

	/* TC_005 - Add bank details  in the Wallet dashboard*/
	@Given("user is on add bank details page")
	public void on_add_bank_details() throws Exception {
		try {
			page_wait(4000);
			click("utilities_plus_icon");
			page_wait(3000);
			click("utilities_add_bank");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_004");
		}
	}
	@When("Enter bank details in wallet dashboard")
	public void bank_details() throws Exception {
		try {	
			page_wait(2000);
			value = driver.findElement(By.xpath(OR_reader("utilities_add_bank_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(1000);
			driver.findElement(By.xpath(OR_reader("utilities_bank_saveas"))).sendKeys(td_reader("utilities_bank_saveas",0));
			driver.findElement(By.xpath(OR_reader("utilities_bank_name"))).sendKeys(td_reader("utilities_bank_name",0));
			page_wait(1000);
			driver.findElement(By.xpath(OR_reader("utilities_bank_routingno"))).sendKeys(td_reader("utilities_bank_routingno",0));
			page_wait(2000);
			click("utilities_bank_holdertype");
			if((platformName.equals("Android"))){				
				text = td_reader("utilities_bank_holdertype");
				scrolldown(text);
			}
			else {
				scrolldown("utilities_bank_holdertype");
			}			
			driver.findElement(By.xpath(OR_reader("utilities_bank_accountno"))).sendKeys(td_reader("utilities_bank_accountno",0));
			page_wait(1000);
			click("utilities_bank_checkbox");
			if((platformName.equals("iOS"))){
				click("utilities_bank_checkbox");
			}
			page_wait(3000);
			click("utilties_bank_save_button");
			page_wait(2000);
			click("utilities_ok_button");
			page_wait(4000);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_005");
		}
	}

	//TC_004 - Check deactivate tab 
	@Given("user is on settings page")
	public static void user_on_settings_page() {
		try {
			if((platformName.equals("Android"))){			
				click("utilities");
				click("utilities_settings");
			}
			else {
				click("utilities_back");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	@Then("User should able to click on Deactivate tile")
	public static void utilities_positive_tc_005() throws Exception {
		try {	
			if((platformName.equals("Android"))){
				page_wait(1000);
				click("utilities_deactivate");
				value = driver.findElement(By.xpath(OR_reader("utilities_deactivate_title"))).isDisplayed();
				Assert.assertEquals(true,value);
				click("utilities_deactivate_cancel");
				page_wait(3000);
			}
			page_explicit_wait("home",3000);
			click("home");
			page_wait(3000);
			click("hamburger");
			click("logout");
			close();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_005");
		}	
	}
}
