package Stepdefinition;

import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Utilities_negative_scenario extends Generic_functions{
	public static boolean value;
    public static String text,context_app;

    @When("Open the app in IOS")
    public static void open_App_IOS() throws Exception {
        try {
            app_launch();
            page_wait(4000);
            value = driver.findElement(By.xpath(OR_reader( "welcome_page_title"))).isDisplayed();
            Assert.assertEquals(true,value);
            page_wait(4000);
            login(0,0);
            page_wait(6000);
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("open_App_IOS");
        }
    }


    @Then("Clicks on Utilities tab")
    public static void clicks_utilities() throws Exception {
        try {
        	page_wait(9000);
			page_explicit_wait("home",6000);
			value = driver.findElement(By.xpath(OR_reader("home"))).isDisplayed();
			Assert.assertEquals(true, value);
			click("home");
			page_wait(3000);
			click("utilities");	
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("clicks_utilities");
        }
    }
// TC001_Validate_leaving_fields_blank_add_card_page
    @When("Click on utilities wallet")
    public static void click_Utilities_wallet() throws Exception {
        try {
            click("utilities_wallet");
            page_wait(4000);
            value = driver.findElement(By.xpath(OR_reader("utilities_add_payment_button"))).isDisplayed();
			Assert.assertEquals(true,value);
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("click_Utilities_wallet");
        }
    }

    @Then("click on add card")
    public static void click_add_card() throws Exception {
        try{
            click("utilities_add_payment_button");
            page_wait(3000);
        click("utilities_add_debit_credit_card");}
        catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("click_add_card");
        }
    }

    @And("Validate message on leaving fields blank")
    public static void TC001_Validate_leaving_fields_blank_add_card_page() throws Exception {
        try{
            click("utilities_card_save");
            page_wait(4000);
            text=driver.findElement(By.xpath(OR_reader( "utilities_add_card_title"))).getText();
            Assert.assertEquals(text,td_reader("utilities_add_card_title"));
            text=driver.findElement(By.xpath(OR_reader( "utilities_save_as_invalid_msg"))).getText();
            Assert.assertEquals(text,td_reader("utilities_save_as_invalid_msg"));
            text= driver.findElement(By.xpath(OR_reader("utilities_ph_no_blank_msg"))).getText();
            Assert.assertEquals(text,td_reader("utilities_ph_no_blank_msg"));
            text= driver.findElement(By.xpath(OR_reader("utilities_address_line_one_invalid_msg"))).getText();
            Assert.assertEquals(text,td_reader("utilities_address_line_one_invalid_msg"));
            text= driver.findElement(By.xpath(OR_reader("utilities_state_invalid_msg"))).getText();
            Assert.assertEquals(text,td_reader("utilities_state_invalid_msg"));
            text= driver.findElement(By.xpath(OR_reader("utilities_city_invalid_msg"))).getText();
            Assert.assertEquals(text,td_reader("utilities_city_invalid_msg"));
            click("back_button");
            page_wait(6000);
        }catch (Exception e) { e.printStackTrace();
        takeScreenShot("TC001_Validate_leaving_fields_blank_on_add_card_page");}
    }
    //TC002_Validate the message on entering invalid details in the Add Card page
    @When("Enter invalid details in the Add Card page")
    public static void invalid_details_add_card() throws Exception {
        try{
        click_add_card();
        page_wait(4000);
        driver.findElement(By.xpath(OR_reader("utilities_card_number"))).sendKeys(td_reader("utilities_card_number",1));
        driver.findElement(By.xpath(OR_reader("utilities_card_expiry"))).sendKeys(td_reader("utilities_card_expiry",1));
        driver.findElement(By.xpath(OR_reader("utilities_card_cvc"))).sendKeys(td_reader("utilities_card_cvc",1));
        driver.findElement(By.xpath(OR_reader("utilities_card_postal_code"))).sendKeys(td_reader("utilities_card_postal_code",1));
        click("utilities_card_phoneno");
        driver.findElement(By.xpath(OR_reader("utilities_card_phoneno"))).sendKeys(td_reader("utilities_card_phoneno",1));
            driver.findElement(By.xpath(OR_reader("utilities_card_city"))).sendKeys(td_reader("utilities_card_city",1));
        page_wait(5000);
        click("utilities_card_save");
        	}
        catch (Exception e){e.printStackTrace();
        takeScreenShot("invalid_details_add_card");}
    }

    @Then("Validate message on entering invalid details on add card page")
    public static void TC002_validate_message_invalid_details_add_card() throws Exception {
        try{
            value = driver.findElement(By.xpath(OR_reader("utilities_card_error"))).isDisplayed();
            Assert.assertEquals(true,value);
        text = driver.findElement(By.xpath(OR_reader("utilities_ph_no_invalid_msg"))).getText();
        Assert.assertEquals(text,td_reader("utilities_ph_no_invalid_msg"));
        click("back_button");
        }catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("TC002_validate_message_invalid_details_add_card");
        }
    }

//TC003_Validate message on leaving fields blank in the Add Bank page
    @When("Click on add bank")
    public static void click_add_bank() throws Exception {
        try {
            click("utilities_add_payment_button");
            page_wait(2000);
            click("utilities_add_bank");
            value = driver.findElement(By.xpath(OR_reader("utilities_add_bank_title"))).isDisplayed();
			Assert.assertEquals(true,value);
        }catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("click_add_bank");
        }
    }

    @Then("Leave fields blank in the Add Bank page")
    public static void leave_field_blank_add_bank() throws Exception {
        try {
            click("utilities_bank_saveas");
            click("utilities_bank_name");
            click("utilities_bank_routingno");
            click("utilities_bank_accountno");
            click("utilities_bank_checkbox");
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("leave_field_blank_add_bank");
        }
    }

    @And("Validate message on leaving fields blank in Add Bank page")
    public static void TC003_Validate_message_on_leave_fields_blank_add_bank() throws Exception {
        try{
            page_wait(4000);
            text = driver.findElement(By.xpath(OR_reader("utilities_save_as_valid_msg_two"))).getText();
            Assert.assertEquals(text, td_reader("utilities_save_as_invalid_msg_two"));
            text = driver.findElement(By.xpath(OR_reader("utilities_account_holder_name_valid_msg_two"))).getText();
            Assert.assertEquals(text, td_reader("utilities_account_holder_name_invalid_msg_two"));
            text = driver.findElement(By.xpath(OR_reader("utilities_routing_no_valid_msg_two"))).getText();
            Assert.assertEquals(text, td_reader("utilities_routing_no_invalid_msg_two"));
            text = driver.findElement(By.xpath(OR_reader("utilities_account_no_valid_msg_two"))).getText();
            Assert.assertEquals(text, td_reader("utilities_account_no_invalid_msg_two"));
            page_wait(4000);
            click("back_button");
        }catch (Exception e) {e.printStackTrace();
            takeScreenShot("TC003_Validate_message_on_leave_fields_blank_add_bank");}
    }
//TC004_Validate that user gets validation message on entering invalid details in the Add Bank page
    @When("Enter invalid details in the Add Bank page")
    public static void invalid_details_add_bank() throws Exception {
        click("utilities_add_payment_button");
        page_wait(2000);
        click("utilities_add_bank");
        driver.findElement(By.xpath(OR_reader("utilities_bank_saveas"))).sendKeys(td_reader("utilities_bank_saveas",1));
        driver.findElement(By.xpath(OR_reader("utilities_bank_name"))).sendKeys(td_reader("utilities_bank_name",1));
        click("utilities_bank_routingno");
        driver.findElement(By.xpath(OR_reader("utilities_bank_routingno"))).sendKeys(td_reader("utilities_bank_routingno",1));
        click("utilities_account_no");
        driver.findElement(By.xpath(OR_reader("utilities_bank_accountno"))).sendKeys(td_reader("utilities_bank_accountno",1));
        click("utilities_bank_checkbox");
    }

    @Then("Validate message on entering invalid details in Add Bank page")
    public static void TC004_entering_invalid_details_AddBank_page() throws Exception {
        try{
            text = driver.findElement(By.xpath(OR_reader("utilities_account_holder_name_valid_msg_two"))).getText();
            Assert.assertEquals(text,td_reader("utilities_account_holder_name_invalid_msg"));
            text = driver.findElement(By.xpath(OR_reader("utilities_routing_no_valid_msg_two"))).getText();
            Assert.assertEquals(text,td_reader("utilities_routing_no_invalid_msg"));
            text = driver.findElement(By.xpath(OR_reader("utilities_account_no_valid_msg_two"))).getText();
            Assert.assertEquals(text,td_reader("utilities_account_no_invalid_msg"));
            click("back_button");
            click("utilities_back");
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("TC004_entering_invalid_details_AddBank_page");
        }
    }
//TC005_Validate award points page
    @When("Click on award points")
    public static void click_award_points() throws Exception {
        try{
//        click("utilities_awardpoints");
//        page_wait(2000);
        }
        catch (Exception e){
            e.printStackTrace();
            takeScreenShot("click_award_points");
        }
    }

    @Then("Verify the award points page")
    public static void TC005_Validate_award_points_page() throws Exception {
        try {
//            text = driver.findElement(By.xpath(OR_reader("utilities_awardpoints_title"))).getText();
//            Assert.assertEquals(text, td_reader("utilities_awardpoints_title"));
//            click("utilities_back");
        }catch (Exception e){
            e.printStackTrace(); takeScreenShot("TC005_Validate award points page");
        }
    }
    //TC006_Validate ID card
    @When("Click on ID card")
    public static void click_ID_card() throws Exception {
        try{
//            click("utilities_idcard");
        }catch (Exception e){e.printStackTrace();
        takeScreenShot("click_ID_card");}
    }

    @Then("Verify the ID card page")
    public static void TC006_verify_ID_card() throws Exception {
        try{
//            value=driver.findElement(By.xpath(OR_reader("utilities_ok_button"))).isDisplayed();
//            Assert.assertEquals(true,value);
        click("utilities_ok_button");
        }catch (Exception e){e.printStackTrace();
            takeScreenShot("TC006_verify_ID_card");}
    }

    //TC007_Validate Upload
    @When("Click on Upload")
    public static void click_upload() throws Exception {
        try{
//            click("utilities_upload");
        }catch (Exception e){e.printStackTrace();
            takeScreenShot("click_upload");}
    }

    @Then("Verify Upload")
    public static  void TC007_verify_upload() throws Exception {
        try{
//            value=driver.findElement(By.xpath(OR_reader("utilities_ok_button"))).isDisplayed();
//            Assert.assertEquals(true,value);
//            click("utilities_ok_button");
//            logout();
        }catch (Exception e){e.printStackTrace();
            takeScreenShot("TC007_verify_upload");}
    }

    public static void logout() throws Exception {
//        click("hamburger");
//        click("logout");
    }
}
