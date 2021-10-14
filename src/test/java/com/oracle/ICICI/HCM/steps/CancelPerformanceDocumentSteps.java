package com.oracle.ICICI.HCM.steps;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.ICICI.HCM.pages.PerformanceDocumentPage;
import com.oracle.ICICI.common.actions.Common_Library;
import com.oracle.ICICI.common.steps.DatabankInitialization;
import com.oracle.ICICI.common.steps.ReportingSteps;

import io.cucumber.java.en.Then;
import com.oracle.acs.util.report.ReportGeneration;

public class CancelPerformanceDocumentSteps {

	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	
	
	DatabankInitialization data= new DatabankInitialization();
	static final Logger log = LoggerFactory.getLogger(CancelPerformanceDocumentSteps.class);

	PerformanceDocumentPage perfDoc=new PerformanceDocumentPage();
	

@Then("^Cancel the document and verify$")
public void cancel_the_document_and_verify() {
	
	try {
		cmnLib.clickOnWebElement(perfDoc.performanceDocCheckBox);
		
		cmnLib.clickOnWebElement(perfDoc.ActionBtn);
		
		cmnLib.clickOnWebElement(perfDoc.cancelMenu);
		
		cmnLib.clickOnWebElement(perfDoc.docStatusclearLink);
		
		String status=perfDoc.DocumentStatusCancel.getText();
		
		System.out.println("Status :: " + status);
		
		if(status.equalsIgnoreCase("Canceled"))
		{
		
			log.info("Status Set as canceled");
			rpt.generateReport("", "Status set as canceled", "", "",
					"Status should be set as canceled",
					"Status Set as canceled", "Passed", "", true);			
		}
		else
		{
			rpt.generateReport("", "Status set as canceled", "", "",
					"Status should be set as canceled",
					"Status does not set as canceled", "Failed", "", true);
			Assert.fail("Status does not set as canceled");


		}
		
		cmnLib.clickOnWebElement(perfDoc.backButton);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}


}
