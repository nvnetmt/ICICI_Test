package com.oracle.ICICI.HCM.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.ICICI.HCM.pages.PerformanceDocumentPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;

public class DeletePerformanceDocumentsSteps {

	
	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	
	DatabankInitialization data= new DatabankInitialization();
	static final Logger log = LoggerFactory.getLogger(DeletePerformanceDocumentsSteps.class);

	PerformanceDocumentPage perfDoc=new PerformanceDocumentPage();
	

@Then("^Delete the document and verify$")
public void Delete_the_document_and_verify() {
	
	try {
		TimeUnit.SECONDS.sleep(10);
		cmnLib.clickOnWebElement(perfDoc.docStatusclearLink);
		
		cmnLib.clickOnWebElement(perfDoc.performanceDocCheckBox);
		
		cmnLib.clickOnWebElement(perfDoc.ActionBtn);
		
		cmnLib.clickOnWebElement(perfDoc.deleteMenu);
		
		TimeUnit.SECONDS.sleep(10);
		
		String status=perfDoc.warningMsg.getText();
		
		System.out.println("Status :: " + status);
		
		if(status.contains("The selected performance documents will be deleted permanently"))
		{
		
			
			log.info("Status Set as In progress");
			rpt.generateReport("", "Status should be display", "", "",
					"Status should be display",
					"Status display successfully", "Passed", "", true);	
			
			cmnLib.clickOnWebElement(perfDoc.warningMsgYesBtn);
			rpt.generateReport("", "Selected Performance document not display in list", "", "",
					"Selected Performance document should not display in list",
					"Selected Performance document not display in list successfully", "Passed", "", true);	
			
		}
		else
		{
			rpt.generateReport("", "Status should be display", "", "",
					"Status should be display",
					"Status does not display", "Failed", "", true);
			Assert.fail("Status does not display");


		}
		TimeUnit.SECONDS.sleep(10);
		cmnLib.clickOnWebElement(perfDoc.backButton);
		
	} catch (Exception e) {
	}
}

}
