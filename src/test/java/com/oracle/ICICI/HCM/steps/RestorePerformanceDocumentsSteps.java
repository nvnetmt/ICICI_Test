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

public class RestorePerformanceDocumentsSteps {
	
	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;
	DatabankInitialization data= new DatabankInitialization();
	static final Logger log = LoggerFactory.getLogger(RestorePerformanceDocumentsSteps.class);

	PerformanceDocumentPage perfDoc=new PerformanceDocumentPage();
	

@Then("^Restore the document and verify$")
public void restore_the_document_and_verify() {
	
	try {
		TimeUnit.SECONDS.sleep(10);
		cmnLib.clickOnWebElement(perfDoc.docStatusclearLink);
		
		cmnLib.clickOnWebElement(perfDoc.performanceDocCheckBox);
		
		cmnLib.clickOnWebElement(perfDoc.ActionBtn);
		
		cmnLib.clickOnWebElement(perfDoc.ReopenMenu);
		
		//cmnLib.clickOnWebElement(perfDoc.docStatusclearLink);
		TimeUnit.SECONDS.sleep(10);
		
		String status=perfDoc.DocumentStatusInProgress.getText();
		
		System.out.println("Status :: " + status);
		
		if(status.equalsIgnoreCase("In progress"))
		{
		
			log.info("Status Set as In progress");
			rpt.generateReport("", "Status set as In progress", "", "",
					"Status should be set as In progress",
					"Status Set as In progress", "Passed", "", true);			
		}
		else
		{
			rpt.generateReport("", "Status set as In progress", "", "",
					"Status should be set as In progress",
					"Status does not set as In progress", "Failed", "", true);
			Assert.fail("Status does not set as In progress");


		}
		
		cmnLib.clickOnWebElement(perfDoc.backButton);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}

}
