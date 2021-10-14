package com.oracle.ICICI.HCM.steps;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.ICICI.HCM.pages.PerformanceDocumentPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;
import com.oracle.acs.util.BrowserDriverUtil;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;

public class TransferPerformanceDocumentSteps extends BrowserDriverUtil {
	
	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
    DatabankInitialization data= new DatabankInitialization();
	static final Logger log = LoggerFactory.getLogger(TransferPerformanceDocumentSteps.class);

	PerformanceDocumentPage perfDoc=new PerformanceDocumentPage();
	
	
	@SuppressWarnings("static-access")
	@Then("^Transfer Manager of document and verify \"([^\"]*)\" \"([^\"]*)\"$")
	public void Transfer_Manager_of_Document_and_verify(String ManagerName, String ManagerEmpId)  {

		try {
			Robot rob= new Robot();
			ManagerName=data.exl.read(data.strDataSheetName, data.DataRow, ManagerName);
			ManagerEmpId=data.exl.read(data.strDataSheetName, data.DataRow, ManagerEmpId);

			cmnLib.clickOnWebElement(perfDoc.performanceDocCheckBox);

			cmnLib.clickOnWebElement(perfDoc.ActionBtn);

			cmnLib.clickOnWebElement(perfDoc.TransferMenu);


			if(ManagerEmpId.length()>0)
			{
				if(cmnLib.waitForElementToBeVisible(perfDoc.ManagerIDTxt))
				{
					cmnLib.clickOnWebElement(perfDoc.ManagerIDTxt);
					cmnLib.enterDataInTextBox(perfDoc.ManagerIDTxt, ManagerEmpId, false);
					
					rob.keyPress(KeyEvent.VK_ENTER);
					rob.keyRelease(KeyEvent.VK_ENTER);

					log.info("Change Manager");
					rpt.generateReport("", "Change Manager", "", "\nManager id: " + ManagerEmpId,
							"Manager should exist",
							"Change Manager entered successfully", "Passed", "", true);			
				}
				else
				{
					rpt.generateReport("", "Change Manager entered", "", "",
							"Manager field should exist",
							"Change Manager field does not exist", "Failed", "", true);
					Assert.fail("Change Manager field does not exist");


				}
			}

			cmnLib.clickOnWebElement(perfDoc.SubmitTransferManager);
			
			
			TimeUnit.SECONDS.sleep(30);
			
			String status=getDriver().findElement(By.xpath("//span[contains(@title,'"+ManagerName+"')]")).getText();
			
			System.out.println("Status :: " + status);
			
			if(status.equalsIgnoreCase(ManagerName))
			{
			
				log.info("Manager Change");
				rpt.generateReport("", "Manager should be change", "", "",
						"Manager should be change",
						"Manager change successfully", "Passed", "", true);			
			}
			else
			{
				rpt.generateReport("", "Manager should be change", "", "",
						"Manager should be change",
						"Manager does not change", "Failed", "", true);
				Assert.fail("Manager does not change");


			}

			cmnLib.clickOnWebElement(perfDoc.backButton);

		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}
	
}
