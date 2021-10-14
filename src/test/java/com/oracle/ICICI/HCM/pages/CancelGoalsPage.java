package com.oracle.ICICI.HCM.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.acs.util.BrowserDriverUtil;

public class CancelGoalsPage extends BrowserDriverUtil {

	Common_Library cmnLib = new Common_Library();
	private Logger log = Logger.getLogger(CancelGoalsPage.class.getName());

	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:admUpl:UPsp1:sh:SO1Fs:hf01Sis:hf01Srh::content\"]")
	public WebElement ReviewPeriod;

	@FindBy(xpath = "(//div[contains(.,'Test Review-Period FY2020-21')])")
	public WebElement reviewPeriodValue;

	@FindBy(xpath = "//input[contains(@aria-controls,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:admUpl:UPsp1:sh:SO1Fs:hf01Sisj_id_1:hf01Srh::sgstnBdy')]")
	public WebElement employee;

	@FindBy(xpath = "//label[contains(.,'Not started')]")
	public WebElement goalStatusCheckBox;

	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:admUpl:UPsp1:sh:SO1Fs:hf05sf:hf03Inp::content\"]")
	public WebElement goalNameSearchTextBox;

	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:admUpl:UPsp1:sh:SO1Fs:hf05sf:hf03Cil::icon\"]")
	public WebElement searchGoalPlan;

	@FindBy(xpath = "(//label[contains(@class,'x19y')])[2]")
	public WebElement goalPlanCheckBox;

	@FindBy(xpath = "//span[contains(.,'Actions')]")
	public WebElement action;

	@FindBy(xpath = "//td[@class='xnv'][contains(.,'Cancel')]")
	public WebElement cancel;

	@FindBy(xpath = "//td[@class='xnv'][contains(.,'Delete')]")
	public WebElement delete;

	@FindBy(xpath = "(//td[contains(.,'ICICI_20C TEST_CAT PLAN')])[3]")
	public WebElement goalNames;

	@FindBy(xpath = "(//span[@class='AFStretchWidth text-orange'])[1]")
	public WebElement status;

	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:admUpl:UPsp1:SPdonei::icon\"]")
	public WebElement backbutton;

	@FindBy(xpath = "//*[@id=\"_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:0:hp01Upl:UPsp1:hp01Pce:hp01Lv:0:hp01Pse:hp02Cl\"]")
	public WebElement Input_Emp;

	@FindBy(xpath = "//a[@title='Clear filter Goal Status']")
	public WebElement ClearGoal;

	@FindBy(xpath = "//label[text()='Canceled']")
	public WebElement ChkBox_Canceled;

	public CancelGoalsPage() {
		PageFactory.initElements(getDriver(), this);
		log.info("Goals Page is initialized...");
	}

	public boolean SelectEmpReviewPeriod(String ReviewPeriod) throws Exception {
		getDriver().findElement(By.xpath("//a[contains(@id,'rpdSel::drop')]")).click();
		boolean found = false;
		List<WebElement> goalplan = getDriver().findElements(
				By.xpath("//ul[contains(@id,'_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:goalUpl:UPsp1:rpdSel::pop')]/li"));
		for (WebElement period : goalplan) {
			System.out.println("ReviewPeriod Name : " + period);
			if (period.getText().equalsIgnoreCase(ReviewPeriod)) {
				found = true;
				period.click();
			}
		}

		return found;

	}

	public boolean SelectEmpGoalPlan(String planName) throws Exception {
		getDriver().findElement(By.xpath("//a[contains(@id,'goalUpl:UPsp1:gpSel::drop')]")).click();
		boolean found = false;
		List<WebElement> goalplan = getDriver().findElements(By.xpath("//ul[contains(@id,'gpSel::pop')]/li"));
		for (WebElement plan : goalplan) {
			System.out.println("Goal plan Name : " + plan);
			if (plan.getText().equalsIgnoreCase(planName)) {
				found = true;
				plan.click();
			}
		}

		return found;

	}

	public boolean verifyCanceledGoal(String planName) throws Exception {
		boolean found = false;
		List<WebElement> goalplan = getDriver()
				.findElements(By.xpath("//a[contains(@id,'hf04Sbv:gpPce:goalLv:')]/span"));
		for (WebElement plan : goalplan) {
			System.out.println("Goal plan Name : " + plan);
			if (plan.getText().equalsIgnoreCase(planName)) {
				found = true;
			}
		}

		return found;

	}

}
