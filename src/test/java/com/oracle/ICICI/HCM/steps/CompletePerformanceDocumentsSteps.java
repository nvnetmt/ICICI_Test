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

public class CompletePerformanceDocumentsSteps {
	public static ReportGeneration rpt = ReportingSteps.getRpt();
	Common_Library cmnLib = ReportingSteps.cmnLib;


	
	DatabankInitialization data= new DatabankInitialization();
	static final Logger log = LoggerFactory.getLogger(CompletePerformanceDocumentsSteps.class);

	PerformanceDocumentPage perfDoc=new PerformanceDocumentPage();
	

@Then("^Complete document and verify$")
public void complete_document_and_verify() {
	
	try {
		TimeUnit.SECONDS.sleep(10);
		cmnLib.clickOnWebElement(perfDoc.docStatusclearLink);
		
		cmnLib.clickOnWebElement(perfDoc.performanceDocCheckBox);
		
		cmnLib.clickOnWebElement(perfDoc.ActionBtn);
		
		cmnLib.clickOnWebElement(perfDoc.completeMenu);
		
		//cmnLib.clickOnWebElement(perfDoc.docStatusclearLink);
		TimeUnit.SECONDS.sleep(10);
		
		String status=perfDoc.DocumentStatusCompleted.getText();
		
		System.out.println("Status :: " + status);
		
		if(status.equalsIgnoreCase("Completed"))
		{
		
			log.info("Status Set as Completed");
			rpt.generateReport("", "Status set as Completed", "", "",
					"Status should be set as Completed",
					"Status Set as Completed", "Passed", "", true);			
		}
		else
		{
			rpt.generateReport("", "Status set as Completed", "", "",
					"Status should be set as Completed",
					"Status does not set as Completed", "Failed", "", true);
			Assert.fail("Status does not set as Completed");


		}
		
		cmnLib.clickOnWebElement(perfDoc.backButton);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}


}
