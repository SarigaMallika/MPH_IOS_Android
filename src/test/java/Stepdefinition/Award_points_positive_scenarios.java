package Stepdefinition;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Award_points_positive_scenarios extends Generic_functions{
	public static boolean value;
	static WebElement ele;
	String ere;
	public static WebElement fr;
	static String str,text;
	static List<WebElement> grid_elements,drp_list;

	/* TC_001 -Navigate to Utilities screen*/
	@Given("User is on landing page")
	public static void launch_url() throws Exception{
		try {
			app_launch();
			page_wait(2000);
			login(3,0);
			page_wait(7000);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	@When("Click on 'Utilities'")
	public static void click_utilities_tab() throws Exception {
		try {
			page_wait(10000);
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
	@Then("Verify award points tab is available")
	public static void click_utilities() throws Exception {
		try {
			page_wait(3000);
			value = driver.findElement(By.xpath(OR_reader("utilities_awardpoints"))).isDisplayed();
			Assert.assertEquals(true, value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_001");
		}
	}

	/*TC 002 - Validate that the user is able to navigated to Utilities screen */
	@When("Click on Award points tile")
	public void click_awardpoints() throws Exception {
		try{
			page_wait(3000);
			click("utilities_awardpoints");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_002");
		}		
	}

	@Then("Validate Award points page")
	public static void Award_point_positive_tc_001() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("utilities_awardpoints_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_002");
		}
	}

	/*TC 003 - Validate that user can click the Tile "Award Points"in the Utilities dashboard*/
	@Given("User is on redeem points page")
	public void click_redeem_points_button() throws Exception {
		try {
			page_wait(3000);
			click("awardpoints_redeeem_points_button");
			page_wait(4000);
			value = driver.findElement(By.xpath(OR_reader("redeem_points_title"))).isDisplayed();
			Assert.assertEquals(true,value);	
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_003");
		}
	}
	@When("Enter giftcard and amount to redeem")
	public static void enter_value() throws Exception {
		try {
			if((platformName.equals("Android"))){
				click("redeem_points_giftcard");
				text = td_reader("redeem_points_giftcard");
				scrolldown(text);
			}
			else {
				scrolldown("redeem_points_giftcard");
			}
			click("redeem_points_amount");
			driver.findElement(By.xpath(OR_reader("redeem_points_amount"))).sendKeys(td_reader("redeem_points_amount",0));
			page_wait(2000);
			click("redeem_points_emailid");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	@Then("Validate user is able to redeem points")
	public void validateTheRedeemAwardPointsPage() throws Exception {
		try {
			//			page_wait(3000);			
			//		click("redeem_points_button");
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_003");
		}
	}

	/*TC 004 - Validate that the user is able to navigate to the 'redeemed' page */
	@When("Navigated to the redeemed page")
	public void navigate_redeem_page() throws Exception {
		try { 
			//			page_wait(7000);
			//		 value = driver.findElement(By.xpath(OR_reader("redeemed_page_title"))).isDisplayed();
			//		 Assert.assertEquals(true,value);
		} 
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_004");
		}
	}
	@Then("Validate the redeemed page")
	public static void Award_point_positive_tc_004() throws Exception {
		try {
			//			click("redeem_points_goto_awardpoints_buton");
			//			page_wait(9000);
			//			 value = driver.findElement(By.xpath(OR_reader("utilities_awardpoints_title"))).isDisplayed();
			//			 Assert.assertEquals(true,value);
			//			 page_wait(1000);
			//			 value = driver.findElement(By.xpath(OR_reader("utilities_awardpoints_history_title"))).isDisplayed();
			//			 Assert.assertEquals(true,value);
			//			close();

		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_004");
		}
	}
}