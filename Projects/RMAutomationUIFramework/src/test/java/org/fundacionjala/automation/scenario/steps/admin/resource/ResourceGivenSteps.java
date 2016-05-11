package org.fundacionjala.automation.scenario.steps.admin.resource;

import org.fundacionjala.automation.framework.pages.admin.home.AdminPage;
import org.fundacionjala.automation.framework.pages.admin.login.LoginPage;
import org.fundacionjala.automation.framework.utils.api.managers.ResourceAPIManager;
import org.fundacionjala.automation.framework.utils.api.objects.admin.Resource;
import org.fundacionjala.automation.framework.utils.common.BrowserManager;
import org.fundacionjala.automation.framework.utils.common.PropertiesReader;

import cucumber.api.java.en.Given;

public class ResourceGivenSteps {
	@Given("^I as Administrator Login to Room Manager$")
	public void i_as_Administrator_Login_to_Room_Manager() throws Throwable {
		BrowserManager.openBrowser();
		LoginPage login = new LoginPage();
		login
				.setUserName(PropertiesReader.getUserName())
				.setPassword(PropertiesReader.getPassword())
				.clickOnSigInButton()
				.refreshPage()
				.leftMenu
				.clickOnIssuesButton()
				.clickOnEmailServerButton();

	}
	@Given("^I have a resource created with the name \"([^\"]*)\", display name \"([^\"]*)\", description \"([^\"]*)\" and icon \"([^\"]*)\"$")
	public void i_have_a_resource_created_with_the_name_display_name_description_and_icon(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		Resource resource = new Resource(arg1, arg2, "fa " + arg4, "", arg3);
		ResourceAPIManager.postRequest(PropertiesReader.getServiceURL()+"/resources", resource);
	}
	@Given("^I am in the first page$")
	public void i_am_in_the_first_page() throws Throwable {
		AdminPage home = new AdminPage();
		home
			.leftMenu
			.clickOnResourcesButton()
			.clickOnFirstPageButton();
	}
	@Given("^I am in the last page$")
	public void i_am_in_the_last_page() throws Throwable {
		AdminPage home = new AdminPage();
		home
			.leftMenu
			.clickOnResourcesButton()
			.clickOnLastPageButton();
	}
}
