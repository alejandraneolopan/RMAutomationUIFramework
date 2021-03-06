package org.fundacionjala.automation.scenario.steps.tablet.createMeeting;

import org.fundacionjala.automation.framework.pages.tablet.scheduler.CredentialsPage;
import org.fundacionjala.automation.framework.pages.tablet.scheduler.SchedulerPage;
import org.fundacionjala.automation.framework.utils.common.BrowserManager;
import org.fundacionjala.automation.framework.utils.common.PropertiesReader;
import org.junit.Assert;

import cucumber.api.java.en.Then;

public class CreateMeetingThenSteps {

    @Then("^validate that \"([^\"]*)\" has been created on timeline$")
    public void validate_that_has_been_created_on_timeline(String subject)
	    throws Throwable {
	SchedulerPage scheduler = new SchedulerPage();
	Assert.assertTrue(scheduler.displayAllDayOnTimeline()
		.isMeetingPresentOnTimeLine(subject));

	scheduler.displayAllDayOnTimeline().clickOnMeeting(subject)
		.clickOnRemoveButton()
		.setPassword(PropertiesReader.getExchangeOrganizerPwd())
		.clickOkButton();
    }

    @Then("^validate that \"([^\"]*)\" has been removed and it is not on timeline$")
    public void validate_that_has_been_removed_and_it_is_not_on_timeline(
	    String meetingName) throws Throwable {
	SchedulerPage scheduler = new SchedulerPage();
	Assert.assertFalse(scheduler.isMeetingPresentOnTimeLine(meetingName));
    }

    @Then("^validate that all day is displayed on timeline$")
    public void validate_that_all_day_is_displayed_on_timeline()
	    throws Throwable {
	SchedulerPage scheduler = new SchedulerPage();
	Assert.assertTrue(scheduler.verifyIfTimelineDisplayAllDay());
	BrowserManager.normalResize();
    }

    @Then("^validate that an error message is displayed for subject$")
    public void validate_that_an_error_message_is_displayed_for_subject()
	    throws Throwable {
	SchedulerPage scheduler = new SchedulerPage();
	Assert.assertTrue(scheduler.verifyErrorMessageOfSubject());
    }

    @Then("^validate that an error message is displayed with invalid credentials$")
    public void validate_that_an_error_message_is_displayed_with_invalid_credentials()
	    throws Throwable {
	CredentialsPage credential = new CredentialsPage();
	Assert.assertTrue(credential
		.verifyErrorMessageOfCredentialsIsDisplayed());
	credential.clickCancelButton();
    }

    @Then("^validate that an error message is displayed with conflict of time interval$")
    public void validate_that_an_error_message_is_displayed_with_conflict_of_time_interval()
	    throws Throwable {
	CredentialsPage credential = new CredentialsPage();
	Assert.assertTrue(credential
		.verifyErrorMessageOfMeetingConflictIsDisplayed());
	credential.clickCancelButton();
    }

    @Then("^Validate that start time date and end time date are disabled to edit$")
    public void validate_that_start_time_date_and_end_time_date_are_disabled_to_edit()
	    throws Throwable {
	SchedulerPage scheduler = new SchedulerPage();
	Assert.assertTrue(scheduler.verifyTextboxDisabled());
    }

    @Then("^validate that the timeline displays time in intervals of ten minutes$")
    public void validate_that_the_timeline_displays_time_in_intervals_of_ten_minutes()
	    throws Throwable {
	SchedulerPage scheduler = new SchedulerPage();
	Assert.assertTrue(
		scheduler.verifyTimeIntervals()
		);
    }
    
    @Then("^validate that \"([^\"]*)\" meeting is found on timeline$")
    public void validate_that_meeting_is_found_on_timeline(String subject) throws Throwable {
	SchedulerPage scheduler = new SchedulerPage();
	Assert.assertTrue(scheduler.displayAllDayOnTimeline()
		.isMeetingPresentOnTimeLine(subject));

	scheduler.displayAllDayOnTimeline()
		.clickOnMeeting(subject);
		
	scheduler.clickOnRemoveButton()
		.setPassword(PropertiesReader.getExchangeOrganizerPwd())
		.clickOkButton();
    }
}
