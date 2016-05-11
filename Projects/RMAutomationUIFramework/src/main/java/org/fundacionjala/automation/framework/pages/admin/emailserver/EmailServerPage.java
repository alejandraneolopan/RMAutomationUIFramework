package org.fundacionjala.automation.framework.pages.admin.emailserver;

import java.util.List;

import org.fundacionjala.automation.framework.maps.admin.conferencerooms.ConferenceRoomsMap;
import org.fundacionjala.automation.framework.maps.admin.emailserver.EmailServerMap;
import org.fundacionjala.automation.framework.pages.admin.home.AdminPage;
import org.fundacionjala.automation.framework.utils.common.BrowserManager;
import org.fundacionjala.automation.framework.utils.common.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailServerPage extends AdminPage {
	
	@FindBy (xpath = EmailServerMap.ADD_BUTTON) WebElement addButton;
	@FindBy (xpath = EmailServerMap.REMOVE_BUTTON) WebElement removeButton;
	@FindBy (xpath = EmailServerMap.EMAIL_SERVER_BUTTON) WebElement emailServerButton;
	@FindBy (xpath = EmailServerMap.EDIT_BUTTON) WebElement editButton;
	@FindBy (xpath = EmailServerMap.USERNAME_TEXT_FIELD) WebElement userNameTextField;
	@FindBy (xpath = EmailServerMap.PASSWORD_TEXT_FIELD) WebElement passwordTextField;
	@FindBy (xpath = EmailServerMap.ACCEPT_BUTTON) WebElement acceptButton;
	@FindBy (xpath = EmailServerMap.DESCRIPTION_TEXT_FIELD) WebElement descriptionTextField;
	@FindBy (xpath = EmailServerMap.ERROR_MESSAGE) WebElement errorMessage;
	
	public EmailServerPage() {
		PageFactory.initElements(BrowserManager.getDriver(), this);
	}
	
	public AddEmailServerPage clickOnAddButton() {
		(new WebDriverWait(BrowserManager.getDriver(), 20)).until(ExpectedConditions.visibilityOf(addButton));
		addButton.click();
		
		LogManager.info("Add Email Server Button has been clicked");
		
		return new AddEmailServerPage();
	}

	public DeleteEmailServerPage clickOnRemoveButton() {
		(new WebDriverWait(BrowserManager.getDriver(), 30)).until(ExpectedConditions.elementToBeClickable(removeButton));
		removeButton.click();
		
		LogManager.info("Remove Email Server Button has been clicked");
		
		return new DeleteEmailServerPage();
	}
	
	public EmailServerPage clickOnServerButton() {
		(new WebDriverWait(BrowserManager.getDriver(), 30)).until(ExpectedConditions.elementToBeClickable(emailServerButton));
		emailServerButton.click();
		
		LogManager.info("Email Server Button has been clicked");
		
		return this;
	}
	
	public EmailServerPage clickOnEditCredentialButton() {
		(new WebDriverWait(BrowserManager.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(EmailServerMap.EDIT_BUTTON)));
		editButton.click();
		
		LogManager.info("Edit Email Server Credential Button has been clicked");
		
		return this;
	}
	
	public EmailServerPage setUserName(String userName) {
		(new WebDriverWait(BrowserManager.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(EmailServerMap.USERNAME_TEXT_FIELD)));
		userNameTextField.clear();
		userNameTextField.sendKeys(userName);
		
		LogManager.info("Domain User Name " + userName +  " has been set up");
		
		return this;
	}
	
	public EmailServerPage setPassword(String password) {
		(new WebDriverWait(BrowserManager.getDriver(), 30)).until(ExpectedConditions.visibilityOf(passwordTextField));
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
		
		LogManager.info("Domain Password " + password + " has been set up");
		
		return this;
	}
	
	public EmailServerPage clickOnAcceptButton() {
		(new WebDriverWait(BrowserManager.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(EmailServerMap.ACCEPT_BUTTON)));
		acceptButton.click();
		(new WebDriverWait(BrowserManager.getDriver(), 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EmailServerMap.EDIT_BUTTON)));
		
		LogManager.info("Edit Email Server Credential Accept Button has been clicked");
		
		return this;
	}

	public boolean findEmailServer() {
		try{
			WebElement hostName = BrowserManager.getDriver().findElement(By.xpath(EmailServerMap.HOST_NAME));
			LogManager.info("Email Server Host Name " + hostName.getText() + " has been found");
			return true;
		}catch (Exception e) {
			LogManager.info("Email Server Host Name has not been found");
			return false;
		}
	}
	
	public boolean verifyIfThereAreRooms() {
		List<WebElement> roomsList = BrowserManager.getDriver().findElements(By.xpath(ConferenceRoomsMap.ROOMS_COLUMN));
		return (roomsList.size() > 0);
	}
	
	public String getUserName() {
		String userName = userNameTextField.getAttribute("value");
		
		LogManager.info("User Name " + userName + " has been obtained");
		
		return userName;
	}
	
	public String getEmailServerDescription() {
		String description = descriptionTextField.getAttribute("value");
		
		LogManager.info("Email Server Description " + description + " has been obtained");
		
		return description;
	}
	
	public EmailServerPage waitForErrorMessage() {
		(new WebDriverWait(BrowserManager.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(EmailServerMap.ACCEPT_BUTTON)));
		acceptButton.click();
		(new WebDriverWait(BrowserManager.getDriver(), 30)).until(ExpectedConditions.visibilityOf(errorMessage));
		String myErrorMessage = errorMessage.getText();
		
		LogManager.info("Error Message " + myErrorMessage + " has been found");
		
		return this;
	}
	
	public String getErrorMessage() {
		String myErrorMessage = errorMessage.getText();
		
		LogManager.info("Error Message " + myErrorMessage + " has been obtained");
		
		return myErrorMessage;
	}
}
