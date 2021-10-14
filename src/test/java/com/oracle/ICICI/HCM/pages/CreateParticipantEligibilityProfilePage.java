package com.oracle.ICICI.HCM.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class CreateParticipantEligibilityProfilePage extends BrowserDriverUtil {

	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(CreateParticipantEligibilityProfilePage.class.getName());

	@FindBy(xpath = "//h1[contains(text(),'Create Participant Eligibility Profile')]")
	public WebElement hdrCreateParticipantEligibilityProfile;

	@FindBy(css = "input[id$='it1::content']")
	public WebElement txtName;

	@FindBy(css = "input[id$='it3::content']")
	public WebElement txtDescription;

	@FindBy(css = "img[id$='create::icon']")
	public WebElement icnCreate;

	@FindBy(xpath = "//label[text()='Sequence']//preceding-sibling::input")
	public WebElement txtSequence;

	@FindBy(xpath = "//label[text()='Gender']//ancestor::td[1]//a")
	public WebElement lnkGender;

	@FindBy(xpath = "//label[text()='Grade']//ancestor::td[1]//input")
	public WebElement txtGrade;

	@FindBy(xpath = "//label[text()='Name']//ancestor::td[1]//input")
	public WebElement txtDepartment;

	@FindBy(css = "div[id$='ctb2']")
	public WebElement btnSaveAndClose;

	public CreateParticipantEligibilityProfilePage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Create Participant Eligibility Profile Page is initialized...");
	}

	public boolean selectTab(String tabName) {
		try {
			getDriver().findElement(By.xpath("//a[contains(text(),'" + tabName + "') and not(contains(@id,'Cnvr'))]"))
					.click();
			WebElement element = getDriver().findElement(By.xpath("//a[contains(text(),'" + tabName
					+ "') and contains(@class,'Selected') and not(contains(@id,'Cnvr'))]"));
			cmnLib.waitForElementToBeVisible(element);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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

	public boolean selectOptionFromComboBoxInsideTable(WebElement comboBoxArrow, String strOptionValue) {
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

}
