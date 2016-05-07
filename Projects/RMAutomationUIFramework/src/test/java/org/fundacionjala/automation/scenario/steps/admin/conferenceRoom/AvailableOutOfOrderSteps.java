package org.fundacionjala.automation.scenario.steps.admin.conferenceRoom;


import org.fundacionjala.automation.framework.pages.admin.conferencerooms.ConferenceRoomsPage;
import org.fundacionjala.automation.framework.pages.admin.home.AdminPage;
import org.fundacionjala.automation.framework.pages.admin.login.LoginPage;
import org.fundacionjala.automation.framework.utils.api.managers.OutOfOrderAPIManager;
import org.fundacionjala.automation.framework.utils.api.objects.admin.OutOfOrder;
import org.fundacionjala.automation.framework.utils.common.BrowserManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AvailableOutOfOrderSteps {
	AdminPage home;
	ConferenceRoomsPage room;
	
	@Given("^I create an Out of Order on a specific \"([^\"]*)\" room$")
	public void i_create_an_Out_of_Order_on_a_specific_room(String arg1) throws Throwable {
		/*OutOfOrder outOfOrder = new OutOfOrder("2016-06-06T02:30:00.000Z", "2016-06-06T02:35:00.000Z", "572bd5092af305ac2ee05802", "Temporarily Out of Order", false);
		OutOfOrderAPIManager.postRequest(
		"http://172.20.208.84:4040/services/572d083bd63d1e940e6baf93/rooms/572d083bd63d1e940e6baf9c/out-of-orders?active=false&email=true", outOfOrder);*/
	} 
	
	@Given("^I logged to Room Manager Admin$")
	public void i_logged_to_Room_Manager_Admin() throws Throwable {
		BrowserManager.openBrowser();
		LoginPage login = new LoginPage();
		home = login.setUserName("Administrator")
					.setPassword("Control*123")
					.clickOnSigInButton()
					.refreshPage();
	}

	@When("^I did click on the icon of Out of Order$")
	public void i_did_click_on_the_icon_of_Out_of_Order() throws Throwable {
		room = home.leftMenu.clickOnConferenceRoomsButton()
				   			.selectOutOfOrderIcon();
	}
	
	@When("^I sign in to Tablet page using the \"([^\"]*)\" room$")
	public void i_sign_in_to_Tablet_page_using_the_room(String arg1) throws Throwable {
	    
	}
	
	@Then("^I validate if the \"([^\"]*)\" room has changed its status to non-available$")
	public void i_validate_if_the_room_has_changed_its_status_to_non_available(String arg1) throws Throwable {
	    
	}
	
}