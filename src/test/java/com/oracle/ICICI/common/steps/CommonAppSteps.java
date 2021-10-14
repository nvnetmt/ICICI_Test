package com.oracle.ICICI.common.steps;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.pages.HomePage;
import com.oracle.ICICI.common.pages.LoginPage;
import com.oracle.acs.util.BrowserDriverUtil;
import com.oracle.acs.util.PropertyUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Date;
import com.oracle.acs.util.report.ReportGeneration;
import java.text.ParseException;

public class CommonAppSteps extends BrowserDriverUtil{

	private Logger log = Logger.getLogger(CommonAppSteps.class.getName());
	Common_Library cmnLib = new Common_Library();
	DatabankInitialization data= new DatabankInitialization();
	public static ReportGeneration rpt = ReportingSteps.getRpt();

	String URL = PropertyUtils.getProperty("se.fusion.url");
	String username = PropertyUtils.getProperty("se.fusion.username");
	String password = PropertyUtils.getProperty("se.fusion.password");

	@Given("^User logs into application$")
	public void user_logs_into_application() throws Throwable {
		HomePage homepage = null;
		getDriver().get(URL);
//		TimeUnit.SECONDS.sleep(5);

		LoginPage loginPage = new LoginPage();
		rpt.enterStepHeader("Navigate to Url");
		Thread.sleep(getMediumSleep());
		if (getDriver().getTitle().contains("Sign In")) {
			rpt.generateReport("", "Navigate to Url", "", URL, "Browser must navigate to Url",
					"Browser navigated to Url", "Passed", "", true);
		} else {
			rpt.generateReport("", "Navigate to Url", "", URL, "Browser must navigate to Url",
					"Failed to load Signin page", "Failed", "", true);
			Assert.fail("Failed to load Signin Page");

		}

		if(username.length()<=0) {
			username = PropertyUtils.getProperty("se.fusion.username");
		}
		if(password.length()<=0) {
			password = PropertyUtils.getProperty("se.fusion.password");
		}
		homepage = loginPage.login(username, password);
		rpt.enterStepHeader("Login to Application");
		if (homepage != null) {
			rpt.generateReport("", "Enter Username", "", username, "Username must be entered", "Username entered",
					"Info", "", false);
			rpt.generateReport("", "Enter Password", "", password, "Password must be entered", "Password entered",
					"Info", "", false);
			rpt.generateReport("", "Click Sign In button", "", "", "Sign In button must be clicked",
					"Clicked Sign In button", "Passed", "", true);
		} else {
			rpt.generateReport("", "Login to application", "Enter Username, Password and Click Sign In button",
					"Username: " + username + "\nPassword: " + password, "Login must be Successful",
					"Login Un-Successful", "Failed", "", true);
			Assert.fail("Login Un-Successful");
		}



	}

	@Given("^User logs into application \"([^\"]*)\",\"([^\"]*)\"$")
	public void user_logs_into_application(String username, String password) throws Throwable {
		username=data.exl.read(data.strDataSheetName,data. DataRow, username);
		password=data.exl.read(data.strDataSheetName,data. DataRow, password);
		HomePage homepage = null;
		getDriver().get(URL);
		TimeUnit.SECONDS.sleep(2);
		LoginPage loginPage = new LoginPage();
		rpt.enterStepHeader("Navigate to Url");
		Thread.sleep(getMediumSleep());
		if (getDriver().getTitle().contains("Sign In")) {
			rpt.generateReport("", "Navigate to Url", "", URL, "Browser must navigate to Url",
					"Browser navigated to Url", "Passed", "", true);
		} else {
			rpt.generateReport("", "Navigate to Url", "", URL, "Browser must navigate to Url",
					"Failed to load Signin page", "Failed", "", true);
			Assert.fail("Failed to load Signin Page");
		}
		if(username.length()<=0) {
			username = PropertyUtils.getProperty("se.fusion.username");
		}
		if(password.length()<=0) {
			password = PropertyUtils.getProperty("se.fusion.password");
		}
		homepage = loginPage.login(username, password);
		rpt.enterStepHeader("Login to Application");
		if (homepage != null) {
			rpt.generateReport("", "Enter Username", "", username, "Username must be entered", "Username entered",
					"Info", "", false);
			rpt.generateReport("", "Enter Password", "", password, "Password must be entered", "Password entered",
					"Info", "", false);
			rpt.generateReport("", "Click Sign In button", "", "", "Sign In button must be clicked",
					"Clicked Sign In button", "Passed", "", true);
		} else {
			rpt.generateReport("", "Login to application", "Enter Username, Password and Click Sign In button",
					"Username: " + username + "\nPassword: " + password, "Login must be Successful",
					"Login Un-Successful", "Failed", "", true);
			Assert.fail("Login Un-Successful");
		}
	}

	
	public void user_logs_into_application(String URL, String username, String password) throws Throwable {
		try {


			HomePage homepage = null;
			System.out.println("URL : "+URL);
			System.out.println("URL : "+username);
			System.out.println("URL : "+password);
			System.out.println("In side new function");
			getDriver().get(URL);
			TimeUnit.SECONDS.sleep(5);

			LoginPage loginPage = new LoginPage();
			rpt.enterStepHeader("Navigate to Url");
			Thread.sleep(getMediumSleep());
			if (getDriver().getTitle().contains("Sign In")) {
				rpt.generateReport("", "Navigate to Url", "", URL, "Browser must navigate to Url",
						"Browser navigated to Url", "Passed", "", true);
			} else {
				rpt.generateReport("", "Navigate to Url", "", URL, "Browser must navigate to Url",
						"Failed to load Signin page", "Failed", "", true);
				Assert.fail("Failed to load Signin Page");

			}

			if(username.length()<=0) {
				username = PropertyUtils.getProperty("se.fusion.username");
			}
			if(password.length()<=0) {
				password = PropertyUtils.getProperty("se.fusion.password");
			}
			homepage = loginPage.login(username, password);
			rpt.enterStepHeader("Login to Application");
			if (homepage != null) {
				rpt.generateReport("", "Enter Username", "", username, "Username must be entered", "Username entered",
						"Info", "", false);
				rpt.generateReport("", "Enter Password", "", password, "Password must be entered", "Password entered",
						"Info", "", false);
				rpt.generateReport("", "Click Sign In button", "", "", "Sign In button must be clicked",
						"Clicked Sign In button", "Passed", "", true);
			} else {
				rpt.generateReport("", "Login to application", "Enter Username, Password and Click Sign In button",
						"Username: " + username + "\nPassword: " + password, "Login must be Successful",
						"Login Un-Successful", "Failed", "", true);
				Assert.fail("Login Un-Successful");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}




	public boolean selectOptionFromComboBox(String strLabelName, String strOptionValue) {
		boolean returnStatus = false;

		try {
			cmnLib.waitForPageLoaded();
			if (cmnLib
					.clickOnWebElement(getDriver().findElement(
							By.xpath("//label[text()='" + strLabelName + "']//parent::td//parent::tr//td[2]//a")))
					&& cmnLib.waitForElementToBeVisible(
							getDriver().findElement(By.xpath("//td/ul[contains(@id,'::pop')]")))) {
				List<WebElement> ListOptions = getDriver().findElements(By.xpath("//td/ul[contains(@id,'::pop')]//li"));
				for (WebElement option : ListOptions) {
					if (option.getText().equalsIgnoreCase(strOptionValue)) {
						option.click();
						returnStatus = true;
						log.info("Selected option from " + strLabelName);
						break;
					}
				}
			} else {
				log.info("List Menu not visible for " + strLabelName + "  Combobox");
			}

		} catch (

				Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to select option from " + strLabelName + " Combobox");
		}
		return returnStatus;
	}


	public boolean selectOptionFromComboBox(WebElement comboBoxArrow, String strOptionValue) {
		boolean returnStatus = false;

		try {
			if (cmnLib.clickOnWebElement(comboBoxArrow) && cmnLib
					.waitForElementToBeVisible(getDriver().findElement(By.xpath("//td/ul[contains(@id,'::pop')]")))) {
				List<WebElement> ListOptions = getDriver().findElements(By.xpath("//td/ul[contains(@id,'::pop')]//li"));
				for (WebElement option : ListOptions) {
					if (option.getText().equalsIgnoreCase(strOptionValue)) {
						option.click();
						returnStatus = true;
						log.info("Selected Option");
						break;
					}
				}
				log.info("Expected option not found");
			} else {
				log.info("List Menu not visible");
			}

		} catch (

				Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Unable to select option from Combobox");
		}
		return returnStatus;
	}

	public boolean selectOptionFromActionsDropdown(WebElement dropdownElement, String optionvalue) {

		boolean returnStatus = false;

		try {
			if (cmnLib.clickOnWebElement(dropdownElement) && cmnLib.waitForElementToBeVisible(
					getDriver().findElement(By.xpath("//table[contains(@id,'Mn::ScrollContent')]")))) {
				List<WebElement> ListOptions = getDriver()
						.findElements(By.xpath("//table[contains(@id,'Mn::ScrollContent')]//td[2]"));
				for (WebElement option : ListOptions) {
					if (option.getText().contains(optionvalue)) {
						option.click();
						returnStatus = true;
						log.info("Selected Option");
						break;
					}
				}
				log.info("Expected option not found");
			} else {
				log.info("List Menu not visible");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Unable to select option from Combobox");
		}
		return returnStatus;
	}


	public static String addDaysToDate(String date, String days) {

		int iDays = Integer.parseInt(days);
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
		Date inputDate;
		try {
			inputDate = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Unable to parse the given String <" + date + "> to Date");
		}

		long inputTime = inputDate.getTime();
		long outputTime = inputTime + (iDays * 1000L * 60 * 60 * 24);
		inputDate.setTime(outputTime);
		return sdf.format(inputDate);
	}

	static public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
		return sdf.format(date);
	}


	@Then("^User logs out of Fusion application$")
	public void user_logs_out_of_Fusion_application() throws Throwable {
		LoginPage loginPage = new LoginPage();
		if (loginPage.logout()) {
			rpt.generateReport("", "Log out of the application", "", "", "User must be logged out of the application",
					"User logged out of the application", "Passed", "", true);
		} else {
			rpt.generateReport("", "Log out of the application", "", "", "User must be logged out of the application",
					"User not logged out of the application", "Failed", "", true);
		}

	}

}


